package org.example.kinoxp.controllers;

import org.example.kinoxp.dtos.workAssignmentDtos.WorkAssignmentDto;
import org.example.kinoxp.services.WorkAssignmentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<WorkAssignmentDto>  getShifts() {
        return workAssignmentService.getShifts();
    }



}
