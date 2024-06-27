package scaffolding.demo.services.impl;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scaffolding.demo.entities.UserEntity;
import scaffolding.demo.models.Match;
import scaffolding.demo.models.MatchDifficulty;
import scaffolding.demo.models.RoundMatch;
import scaffolding.demo.models.User;
import scaffolding.demo.repositories.UserRepository;
import scaffolding.demo.services.UserService;
import scaffolding.demo.services.MatchService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MatchService matchService;

    @Override
    public User createUser(String userName, String email) {
        Optional<UserEntity> userEntityOptional = userRepository.getByEmail(email);
        if(userEntityOptional.isPresent()){
            throw new IllegalArgumentException("El correo electrónico ya está registrado.");
        } else {
            UserEntity userEntity = new UserEntity();
            userEntity.setUserName(userName);
            userEntity.setEmail(email);
            UserEntity userEntitySaved = userRepository.save(userEntity);
            return modelMapper.map(userEntitySaved, User.class);
        }
    }
    @Override
    public Match createUserMatch(Long userId, MatchDifficulty matchDifficulty){
        Optional<UserEntity> userEntity = userRepository.findById(userId);
        if(userEntity.isEmpty()){
            throw new EntityNotFoundException("Usuario no encontrado");
        }else{
            User user = modelMapper.map(userEntity.get(), User.class);
            return matchService.createMatch(user, matchDifficulty);
        }
    }

    @Override
    public RoundMatch playUserMatch(Long userId, Long matchId, Integer numberAtPlay) {
        Match match = matchService.getMatchById(matchId);
        if (match.getUser().getId().equals(userId)){
            return matchService.playMatch(match, numberAtPlay);
        }else{
            throw new IllegalArgumentException("El usuario no coincide con el propietario del partido.");
        }
    }
}
