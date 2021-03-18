package com.example.library3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VillanService {
    private final VillanRepository villanRepository;

    @Autowired
    public VillanService(VillanRepository VillanRepository) {
        this.villanRepository = VillanRepository;
    }

    public void create(VillanDto villanDto) {
        villanRepository.save(
                new VillanEntity(villanDto.getArchRival(),
                        villanDto.getRealName(),
                        villanDto.getHeroName(),
                        villanDto.getImage(),
                        villanDto.getHeight(),
                        villanDto.getWeight(),
                        villanDto.getSpecialpower(),
                        villanDto.getIntelligence(),
                        villanDto.getStrength(),
                        villanDto.getPower(),
                        villanDto.getSpeed(),
                        villanDto.getAgility(),
                        villanDto.getDescription(),
                        villanDto.getStory()
                        ));
    }

    public List<VillanDto> fetchAll() {
        return villanRepository.findAll()
                .stream()
                .map(villanEntity -> {
                    return new VillanDto(villanEntity.getArchRival(),
                            villanEntity.getRealName(),
                            villanEntity.getHeroName(),
                            villanEntity.getImage(),
                            villanEntity.getHeight(),
                            villanEntity.getWeight(),
                            villanEntity.getSpecialpower(),
                            villanEntity.getIntelligence(),
                            villanEntity.getStrength(),
                            villanEntity.getPower(),
                            villanEntity.getSpeed(),
                            villanEntity.getAgility(),
                            villanEntity.getDescription(),
                            villanEntity.getStory());
                })
                .collect(Collectors.toList());
    }

    public List<VillanDto> GetVillanByName(String name) throws Exception {
        List<VillanEntity> villans =  villanRepository.findAll()
                .stream()
                .filter(en ->{
                    return en.realName.equals(name);
                }).collect(Collectors.toList());

         if(!villans.isEmpty())
         {
             return villans.stream().map(villanEntity -> {
                return new VillanDto(villanEntity.getArchRival(),
                        villanEntity.getRealName(),
                        villanEntity.getHeroName(),
                        villanEntity.getImage(),
                        villanEntity.getHeight(),
                        villanEntity.getWeight(),
                        villanEntity.getSpecialpower(),
                        villanEntity.getIntelligence(),
                        villanEntity.getStrength(),
                        villanEntity.getPower(),
                        villanEntity.getSpeed(),
                        villanEntity.getAgility(),
                        villanEntity.getDescription(),
                        villanEntity.getStory());
                 }).collect(Collectors.toList());
         }
         else
         {
             throw new Exception("Invalid Hero Name");
         }
    }
}
