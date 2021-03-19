package com.example.library3;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
public class HeroAndVillanController {

    @Autowired
    HeroService heroService;
    VillanService villanServie;

    public HeroAndVillanController(HeroService heroService){
        this.heroService = heroService;
    }
    public HeroAndVillanController(VillanService villanServie){
        this.villanServie = villanServie;
    }

    @PostMapping("hero")
    @ResponseStatus(HttpStatus.CREATED)
    public void createaHero(@RequestBody HeroDto heroDto){
        this.heroService.create(heroDto);
    }

    @PutMapping("hero")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateaHero(@RequestBody HeroDto heroDto){
        this.heroService.update(heroDto);
    }

    @GetMapping("hero")
    public List<HeroDto> getAllHeros(){
        return this.heroService.fetchAll();
    }

    @GetMapping("hero/{name}")
    public List<HeroDto> GetHeroByName(@PathVariable String name) throws Exception {
        return this.heroService.GetHeroByName(name);
    }

}
