package com.example.library3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HeroServiceTests {

    @Mock
    HeroRepository mockHeroRepository;

    @InjectMocks
    HeroService subject;

//    @Test
//    void create() {
//       HeroDto heroDto = new HeroDto("Mr", "John Smith");
//       subject.create(heroDto);
//       verify(mockHeroRepository).save(
//               new HeroEntity("Mr", "John Smith")
//       );
//    }
    //Get All Heros
    @Test
    void GetAllHeros() {
        // S Seat
        HeroEntity heroEntity = new HeroEntity("Zach", "Zachkry Neagley","Dummy Image",
                "6","200","JavaBeans","10","500","60","6",
                "Test Desc","Zach Story","Story2");
        when(mockHeroRepository.findAll()).thenReturn(
                List.of(
                        heroEntity,
                   new HeroEntity("Rohit", "Rohit Ranjan","Dummy Image2",
                           "6","200",".NET","10","500","60","6",
                           "Test Desc","Zach Story","Story2")
                )
        );

        // E Exercise
        List<HeroDto> actual = subject.fetchAll();

        // A Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new HeroDto("Zach", "Zachkry Neagley","Dummy Image",
                                "6","200","JavaBeans","10","500","60","6",
                                "Test Desc","Zach Story","Story2"),
                        new HeroDto("Rohit", "Rohit Ranjan","Dummy Image2",
                                "6","200",".NET","10","500","60","6",
                                "Test Desc","Zach Story","Story2")
                )
        );
    }

    //Get All Heros
    @Test
    void GetHeroByName() {
        // S Seat
        HeroEntity heroEntity1 = new HeroEntity("Rohit", "Rohit Ranjan","Dummy Image2",
                "6","200","JavaBeans","10","500","60","6",
                "Test Desc","Rohit Story","Story3");
        HeroEntity heroEntity2 = new HeroEntity("Zach", "Zachkry Neagley","Dummy Image",
                "6","200","JavaBeans","10","500","60","6",
                "Test Desc","Zach Story","Story2");
        HeroEntity heroEntity3 = new HeroEntity("David", "David Roy","Dummy Image4",
                "6","200","Angular","10","500","60","6",
                "Test Desc","Zach Story3","Story3");
        when(mockHeroRepository.findAll()).thenReturn(
                List.of(
                        heroEntity1,
                        heroEntity2,
                        heroEntity3
                )
        );

        // E Exercise
        List<HeroDto> actual = subject.GetHeroByName("Zach");

        // A Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new HeroDto("Zach", "Zachkry Neagley","Dummy Image",
                                "6","200","JavaBeans","10","500","60","6",
                                "Test Desc","Zach Story","Story2")
                )
        );
    }

}
