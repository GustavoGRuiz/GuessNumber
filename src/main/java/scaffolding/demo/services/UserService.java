package scaffolding.demo.services;

import org.springframework.stereotype.Service;
import scaffolding.demo.models.Match;
import scaffolding.demo.models.MatchDifficulty;
import scaffolding.demo.models.RoundMatch;
import scaffolding.demo.models.User;

@Service
public interface UserService {

    User createUser(String userName, String email);
    Match createUserMatch(Long userId, MatchDifficulty difficulty);
    RoundMatch playUserMatch(Long userId, Long matchId, Integer number);

}
