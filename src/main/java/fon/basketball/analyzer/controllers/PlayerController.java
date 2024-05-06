package fon.basketball.analyzer.controllers;

import fon.basketball.analyzer.models.Player;
import fon.basketball.analyzer.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/player")
public class PlayerController {
    private final PlayerService playerService;

    public PlayerController(PlayerService playerService){
        this.playerService=playerService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Player>> getAll(){
        return ResponseEntity.ok(this.playerService.getAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Object> getPlayer(@PathVariable long id) throws Exception {
        try {
            return ResponseEntity.ok(this.playerService.getPlayerById(id));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "/get")
    public ResponseEntity<Player> getPlayerByNameSurenameAndNumber(@RequestParam String name, @RequestParam String surname, @RequestParam int number){
        return ResponseEntity.ok(this.playerService.getPlayer(name,surname,number));
    }
    @PostMapping(path = "/update")
    public ResponseEntity<Object> updatePlayer(@RequestBody Player player) {
        try{
            return ResponseEntity.ok(this.playerService.updatePlayer(player));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping(path = "/delete")
    public ResponseEntity<Object> deletePlayer(@RequestBody Player player){
        try{
            player = this.playerService.deletePlayer(player);
            return ResponseEntity.ok(player);
        }catch(Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
