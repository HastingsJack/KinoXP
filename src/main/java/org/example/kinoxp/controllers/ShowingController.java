package org.example.kinoxp.controllers;


import org.example.kinoxp.dto.ShowingDto;
import org.example.kinoxp.models.Showing;
import org.example.kinoxp.repositories.ShowingRepository;
import org.example.kinoxp.services.ShowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/showings")
@CrossOrigin("*")
public class ShowingController {

    private final ShowingService showingService;

    @Autowired
    ShowingRepository showingRepository;


    public ShowingController(ShowingService showingService) {
        this.showingService = showingService;
    }

    //create
    @PostMapping()
    public Showing create(@RequestBody Showing showing) {
        System.out.println("hello from showing create");
        return showingRepository.save(showing);
    }

    //read
    @GetMapping("/all")
    public List<Showing> findAll() {
        return showingRepository.findAll();
    }

    @GetMapping("/all/dto")
    public List<ShowingDto> findAllDto() {
        return showingService.getAllShowings();
    }

    @GetMapping("/{id}")
    public Showing findById(@PathVariable Long id) {
        return showingRepository.findById(id).get();
    }

    //update
    @PutMapping("/{id}")
    public Showing update(@PathVariable Long id, @RequestBody Showing updatedShowing) {
        return showingRepository.findById(id).map(showing -> {
                    showing.setPrice(updatedShowing.getPrice());
                    showing.setStartTime(updatedShowing.getStartTime());
                    showing.setEndTime(updatedShowing.getEndTime());
                    showing.setDate(updatedShowing.getDate());
                    showing.setMovie(updatedShowing.getMovie());
                    showing.setScreen(updatedShowing.getScreen());
                    showing.setPeriod(updatedShowing.getPeriod());
                    showing.setTickets(updatedShowing.getTickets());
                    return showingRepository.save(showing);
                } )
                .orElseThrow();
    }


    //delete
    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        showingRepository.deleteById(id);
    }
}
