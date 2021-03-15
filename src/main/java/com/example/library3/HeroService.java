package com.example.library3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HeroService {
    private final HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public void create(HeroDto heroDto) {
        heroRepository.save(
                new HeroEntity(heroDto.getTitle(),
                                heroDto.getHeroName()));
    }

    public List<HeroDto> fetchAll() {
        return heroRepository.findAll()
                .stream()
                .map(heroEntity -> {
                    return new HeroDto(heroEntity.getTitle(), heroEntity.getHeroName());
                })
                .collect(Collectors.toList());
    }
}
