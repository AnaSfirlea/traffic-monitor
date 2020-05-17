package TrafficMonitor.controller;

import TrafficMonitor.dtos.JourneyCreationDto;
import TrafficMonitor.dtos.JourneyDto;
import TrafficMonitor.service.JourneyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/journeys")
@AllArgsConstructor
public class JourneyController {

    @Autowired
    private JourneyService service;

    @GetMapping
    public List<JourneyDto> getJourneys(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return service.getJourneys();
    }

    @PostMapping
    public JourneyDto addJourney(@RequestBody final JourneyCreationDto dto,
                                 HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return service.addJourney(dto);
    }

    @GetMapping("/journey/{id}")
    public JourneyDto getOne(@PathVariable final Long id,
                             HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return service.getOne(id);
    }

    @DeleteMapping("/journey/{id}")
    public void deleteJourney(@PathVariable final Long id,
                              HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        service.deleteJourney(id);
    }

}
