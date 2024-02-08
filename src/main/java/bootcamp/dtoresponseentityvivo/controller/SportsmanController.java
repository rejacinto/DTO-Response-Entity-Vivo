package bootcamp.dtoresponseentityvivo.controller;

import bootcamp.dtoresponseentityvivo.dto.SportsmanDto;
import bootcamp.dtoresponseentityvivo.model.Sport;
import bootcamp.dtoresponseentityvivo.service.ISportService;
import bootcamp.dtoresponseentityvivo.service.SportServiceImp;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class SportsmanController {

    private final ISportService sportService = new SportServiceImp();

    @GetMapping("/findSports")
    public List<Sport> getSports() {
        return sportService.findAll();
    }

    @GetMapping("/findSport/{name}")
    public String getSportByName(@PathVariable String name) {
        return sportService.findByName(name);
    }

    @GetMapping("/findSportsPersons")
    public List<SportsmanDto> getSportsPersons() {
        return sportService.findSportsmen();
    }

}
