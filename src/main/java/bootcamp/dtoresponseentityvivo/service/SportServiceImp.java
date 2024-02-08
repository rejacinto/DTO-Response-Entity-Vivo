package bootcamp.dtoresponseentityvivo.service;

import bootcamp.dtoresponseentityvivo.dto.SportsmanDto;
import bootcamp.dtoresponseentityvivo.model.Person;
import bootcamp.dtoresponseentityvivo.model.Sport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SportServiceImp implements ISportService {

    private final Sport futbol = new Sport("Futbol", "Amateur");
    private final Sport basquet = new Sport("Basquet", "Profesional");
    private final Sport tenis = new Sport("Tenis", "Senior");

    private final List<Sport> sports = Arrays.asList(futbol, basquet, tenis);

    private final List<Person> people = Arrays.asList(
            new Person("Renzo", "Jacinto", 25, Arrays.asList(futbol, tenis)),
            new Person("Fulano", "Mengano", 35, Arrays.asList(basquet, tenis))
    );

    @Override
    public List<Sport> findAll() {
        return sports;
    }

    @Override
    public String findByName(String name) {
        Optional<Sport> sport =  sports.stream().filter(s -> s.getName().equalsIgnoreCase(name)).findFirst();
        if (sport.isPresent()) return sport.get().getLevel();
        return "No existe el deporte '" + name + "'";
    }

    @Override
    public List<SportsmanDto> findSportsmen() {
        List<SportsmanDto> sportsmanDtos = new ArrayList<>();

        for (Person person : people) {
            if (person.getSports().isEmpty()) continue;
            SportsmanDto sportsmanDto = new SportsmanDto(person.getFirstName() + " " + person.getLastName(), person.getSports().stream().map(Sport::getName).collect(Collectors.toList()));
            sportsmanDtos.add(sportsmanDto);
        }

        return sportsmanDtos;
    }
}
