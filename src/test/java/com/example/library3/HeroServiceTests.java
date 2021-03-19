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


    @Test
    void createAHero() {
       HeroDto heroDto = new HeroDto("Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans","10","500","60","6","Test Desc","Zach Story","Story2");
       subject.create(heroDto);
       verify(mockHeroRepository).save(
               new HeroEntity("Zach", "Zachkry Neagley","Dummy Image",
                       "6","200","JavaBeans","10","500","60","6",
                       "Test Desc","Zach Story","Story2")
       );
    }

    @Test
    void updateAHero() throws Exception {
        when(mockHeroRepository.findAll()).thenReturn(
                List.of(
                        new HeroEntity("Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans","10","500","60","6","Test Desc","Zach Story","Story2")
                )
        );
        HeroDto heroDto1 = new HeroDto("Zach", "Zachkry Neagley","Dummy Image3","6","200","JavaBeans","10","500","60","6","Test Desc","Zach Story","Story2");
        subject.update(heroDto1);
        List<HeroDto> actual = subject.GetHeroByName("Zach");
        // A Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new HeroDto("Zach", "Zachkry Neagley","Dummy Image3",
                                "6","200","JavaBeans","10","500","60","6",
                                "Test Desc","Zach Story","Story2")
                )
        );

    }
    //Get All Heros
//
//    @Test
//    void updateAHero() {
//        HeroDto heroDto = new HeroDto("Zach", "Zachkry Neagley","Dummy Image3","6","200","JavaBeans","10","500","60","6","Test Desc","Zach Story","Story2");
//        subject.update(heroDto);
//        verify(mockHeroRepository).save(
//                new HeroEntity("Zach", "Zachkry Neagley","Dummy Image3",
//                        "6","200","JavaBeans","10","500","60","6",
//                        "Test Desc","Zach Story","Story2")
//        );
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
    void GetHeroByName() throws Exception {
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
    //GetheroByName Invalid scenario
    @Test
    void TryInvalidName() throws Exception {
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
        try{
            subject.GetHeroByName("Wes");
        }
        catch (Exception ex)
        {
            assertThat(ex.getMessage()).contains("Invalid Hero Name");
        }
    }



}
