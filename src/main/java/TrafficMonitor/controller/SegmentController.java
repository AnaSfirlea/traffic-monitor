package TrafficMonitor.controller;


import TrafficMonitor.dtos.SegmentCreationDto;
import TrafficMonitor.dtos.SegmentDto;
import TrafficMonitor.service.SegmentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segments")
@AllArgsConstructor
public class SegmentController {

    @Autowired
    private SegmentServiceImpl service;

    @GetMapping
    public List<SegmentDto> getSegments(){
        return service.getSegments();
    }

    @PostMapping
    public SegmentDto addSegment(@RequestBody final SegmentCreationDto dto) {
        return service.addSegment(dto);
    }

    @GetMapping("/segment/{id}")
    public SegmentDto getOne(@PathVariable final Long id){
        return service.getOne(id);
    }

}
