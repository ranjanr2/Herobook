package com.example.library3;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class HeroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String realName;
    String heroName;
    String image;
    String height;
    String weight;
    String specialpower;
    String intelligence;
    String strength;
    String power;
    String speed;
    String agility;
    String description;
    String story;

    public HeroEntity(String realName, String heroName, String image,
                      String height, String weight, String specialpower, String intelligence,
                      String strength,String power, String speed, String agility,
                      String description, String story) {
        this.realName = realName;
        this.heroName = heroName;
        this.image = image;
        this.height = height;
        this.weight = weight;
        this.specialpower = specialpower;
        this.intelligence = intelligence;
        this.strength = strength;
        this.power = power;
        this.speed = speed;
        this.agility = agility;
        this.description = description;
        this.story = story;
    }
}
