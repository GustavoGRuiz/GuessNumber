package scaffolding.demo.services;

import org.springframework.stereotype.Service;
import scaffolding.demo.models.Match;
import scaffolding.demo.models.MatchDifficulty;
import scaffolding.demo.models.RoundMatch;
import scaffolding.demo.models.User;

@Service
public interface MatchService {

    Match createMatch(User user, MatchDifficulty matchDifficulty);

    Match getMatchById(Long matchId);
    RoundMatch playMatch(Match match, Integer number);
}
