package fon.basketball.analyzer.controllers;

import fon.basketball.analyzer.models.Player;
import fon.basketball.analyzer.services.PlayerService;
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
    public List<Player> getAll(){
        return this.playerService.getAll();
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public Player getPlayer(@PathVariable long id) throws Exception {
        return this.playerService.getPlayerById(id);
    }

    @GetMapping(path = "/get")
    public Player getPlayerByNameSurenameAndNumber(@RequestParam String name, @RequestParam String surname, @RequestParam int number){
        return this.playerService.getPlayer(name,surname,number);
    }
    @PostMapping(path = "/update")
    public Player updatePlayer(@RequestBody Player player) throws Exception {
        return this.playerService.updatePlayer(player);
    }
}
