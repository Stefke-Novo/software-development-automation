package fon.basketball.analyzer.controllers;

import fon.basketball.analyzer.models.Team;
import fon.basketball.analyzer.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/team")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService){
        this.teamService=teamService;
    }

    @GetMapping(path = "all")
    public ResponseEntity<List<Team>> getAll(){
        return ResponseEntity.ok(this.teamService.getAll());
    }
}
