package scaffolding.demo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scaffolding.demo.dto.MatchDto;
import scaffolding.demo.entities.MatchEntity;
import scaffolding.demo.entities.UserEntity;
import scaffolding.demo.models.*;
import scaffolding.demo.repositories.MatchRepository;
import scaffolding.demo.repositories.UserRepository;
import scaffolding.demo.services.MatchService;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private ModelMapper modelMapper;

    private final Random random = new Random();

    @Override
    public Match createMatch(User user, MatchDifficulty matchDifficulty){
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUserEntity(modelMapper.map(user, UserEntity.class));//pasamos lo recibido a entity para que pueda impactar en la BD
        matchEntity.setDifficulty(matchDifficulty);
        switch (matchDifficulty){
            case HARD -> matchEntity.setRemainingTries(5);
            case MEDIUM -> matchEntity.setRemainingTries(7);
            case EASY -> matchEntity.setRemainingTries(10);
            default -> throw new IllegalArgumentException("Dificultad de partida no válida.");
        }
        matchEntity.setNumberToGuess(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setUpdateDate(LocalDateTime.now());
        matchEntity.setCreatedDate(LocalDateTime.now());
        MatchEntity matchEntitySaved = matchRepository.save(matchEntity);
        return modelMapper.map(matchEntitySaved, Match.class);
    }

    @Override
    public Match getMatchById(Long matchId) {
        Optional<MatchEntity> matchEntityOptional = matchRepository.findById(matchId);
        if(matchEntityOptional.isEmpty()){
            throw new EntityNotFoundException("No hay match con este Id");
        }
        else {
            return modelMapper.map(matchEntityOptional.get(), Match.class);
        }
    }

    @Override
    public RoundMatch playMatch(Match match, Integer number) {
        RoundMatch roundMatch = new RoundMatch();
        roundMatch.setMatchId(match);
        if(match.getStatus().equals(MatchStatus.FINISH)){
            return null;
        }
        if(match.getNumberToGuess().equals(number)){
            match.setStatus(MatchStatus.FINISH);
            roundMatch.setRespuesta("Ganador!!!");
        }else {
            match.setRemainingTries(match.getRemainingTries() - 1);
            if (match.getRemainingTries().equals(0)) {
                match.setStatus(MatchStatus.FINISH);
                roundMatch.setRespuesta("Se quedó sin intentos");
            } else {
                if (number > match.getNumberToGuess()) {
                roundMatch.setRespuesta("El número que buscamos es menor");
            }
            else roundMatch.setRespuesta("El número que buscamos es mayor");
            }
        }
        UserEntity userEntity = modelMapper.map(match.getUser(), UserEntity.class);
        MatchEntity matchEntity=modelMapper.map(match, MatchEntity.class);
        matchEntity.setUserEntity(userEntity);
        matchEntity.setUpdateDate(LocalDateTime.now());
        matchRepository.save(matchEntity);
        return roundMatch;
    }

}
