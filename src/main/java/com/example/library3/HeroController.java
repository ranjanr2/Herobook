package com.example.library3;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HeroController {

    HeroService heroService;

    public HeroController(HeroService heroService){
        this.heroService = heroService;
    }

    @PostMapping("books")
    @ResponseStatus(HttpStatus.CREATED)
    public void addBooks(@RequestBody HeroDto heroDto){
        this.heroService.create(heroDto);
    }

    @GetMapping("books")
    public List<HeroDto> getBooks(){
        return this.heroService.fetchAll();
    }
}
