package TrafficMonitor.controller;

import TrafficMonitor.dtos.IntersectionCreationDto;
import TrafficMonitor.dtos.IntersectionDto;
import TrafficMonitor.service.IntersectionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/intersections")
@AllArgsConstructor
public class IntersectionController {

    @Autowired
    private IntersectionService service;

    @GetMapping
    public List<IntersectionDto> getIntersections(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return service.getIntersections();
    }

    @PostMapping
    public IntersectionDto addIntersection(@RequestBody final IntersectionCreationDto dto,
                                 HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return service.addIntersection(dto);
    }

    @GetMapping("/intersection/{id}")
    public IntersectionDto getOne(@PathVariable final Long id,
                             HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return service.getOne(id);
    }

    @DeleteMapping("/intersection/{id}")
    public void deleteIntersection(@PathVariable final Long id,
                              HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        service.deleteIntersection(id);
    }
}
