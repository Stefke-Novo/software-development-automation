package fon.basketball.analyzer.controllers;

import fon.basketball.analyzer.models.Match;
import fon.basketball.analyzer.services.MatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/match")
public class MatchController {

    private final MatchService matchService;

    public MatchController(MatchService matchService){
        this.matchService=matchService;
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Match>> getAll(){
        return ResponseEntity.ok(matchService.getAll());
    }

}
