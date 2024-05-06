package fon.basketball.analyzer.controllers;

import fon.basketball.analyzer.models.PlayerMatch;
import fon.basketball.analyzer.services.PlayerMatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/player-match")
public class PlayerMatchController {

    private final PlayerMatchService playerMatchService;

    public PlayerMatchController(PlayerMatchService playerMatchService){
        this.playerMatchService = playerMatchService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PlayerMatch>> getAll(){
        return ResponseEntity.ok(this.playerMatchService.getAll());
    }
}
