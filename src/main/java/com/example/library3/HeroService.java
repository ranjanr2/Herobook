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
                new HeroEntity(heroDto.getRealName(),
                        heroDto.getHeroName(),
                        heroDto.getImage(),
                        heroDto.getHeight(),
                        heroDto.getWeight(),
                        heroDto.getSpecialpower(),
                        heroDto.getIntelligence(),
                        heroDto.getStrength(),
                        heroDto.getPower(),
                        heroDto.getSpeed(),
                        heroDto.getAgility(),
                        heroDto.getDescription(),
                        heroDto.getStory()
                        ));
    }

    public List<HeroDto> fetchAll() {
        return heroRepository.findAll()
                .stream()
                .map(heroEntity -> {
                    return new HeroDto(heroEntity.getRealName(),
                            heroEntity.getHeroName(),
                            heroEntity.getImage(),
                            heroEntity.getHeight(),
                            heroEntity.getWeight(),
                            heroEntity.getSpecialpower(),
                            heroEntity.getIntelligence(),
                            heroEntity.getStrength(),
                            heroEntity.getPower(),
                            heroEntity.getSpeed(),
                            heroEntity.getAgility(),
                            heroEntity.getDescription(),
                            heroEntity.getStory());
                })
                .collect(Collectors.toList());
    }

    public List<HeroDto> GetHeroByName(String name) throws Exception {
        List<HeroEntity> heros =  heroRepository.findAll()
                .stream()
                .filter(en ->{
                    return en.realName.equals(name);
                }).collect(Collectors.toList());

         if(!heros.isEmpty())
         {
             return heros.stream().map(heroEntity -> {
                return new HeroDto(heroEntity.getRealName(),
                         heroEntity.getHeroName(),
                         heroEntity.getImage(),
                         heroEntity.getHeight(),
                         heroEntity.getWeight(),
                         heroEntity.getSpecialpower(),
                         heroEntity.getIntelligence(),
                         heroEntity.getStrength(),
                         heroEntity.getPower(),
                         heroEntity.getSpeed(),
                         heroEntity.getAgility(),
                         heroEntity.getDescription(),
                         heroEntity.getStory());
                 }).collect(Collectors.toList());
         }
         else
         {
             throw new Exception("Invalid Hero Name");
         }
    }
}
