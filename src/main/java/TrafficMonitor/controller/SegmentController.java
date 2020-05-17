package TrafficMonitor.controller;


import TrafficMonitor.dtos.SegmentCreationDto;
import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.service.SegmentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/segments")
@AllArgsConstructor
public class SegmentController {

    @Autowired
    private SegmentService service;

    @GetMapping
    public List<SegmentDto> getSegments(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        return service.getSegments();
    }

    @PostMapping
    public SegmentDto addSegment(@RequestBody final SegmentCreationDto dto,
                                 HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return service.addSegment(dto);
    }

    @PostMapping("/populate")
    public void populateSegments(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");
        service.populateRepository();
    }

    @GetMapping("/segment/{id}")
    public SegmentDto getOne(@PathVariable final Long id,
                             HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin", "*");

        return service.getOne(id);
    }

    @DeleteMapping("/segment/{id}")
    public void deleteSegment(@PathVariable final Long id,
                              HttpServletResponse response) {

        response.setHeader("Access-Control-Allow-Origin", "*");

        service.deleteSegment(id);
    }
}
