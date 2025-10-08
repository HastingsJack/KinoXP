package org.example.kinoxp.controllers;

import org.example.kinoxp.dtos.workAssignmentDtos.WorkAssignmentDto;
import org.example.kinoxp.services.WorkAssignmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/workAssignment")
public class WorkAssignmentController {

    private WorkAssignmentService workAssignmentService;

    public WorkAssignmentController(WorkAssignmentService workAssignmentService) {
        this.workAssignmentService = workAssignmentService;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/shifts")
    public List<WorkAssignmentDto>  getShifts(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate start,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            LocalDate end) {
        return workAssignmentService.getShifts(start, end);
    }



}
