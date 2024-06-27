package scaffolding.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import scaffolding.demo.dto.DummyDto;
import scaffolding.demo.dto.UserDto;
import scaffolding.demo.models.Dummy;
import scaffolding.demo.models.User;
import scaffolding.demo.services.MatchService;

@RestController
@RequestMapping("/guess-number/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;


}
