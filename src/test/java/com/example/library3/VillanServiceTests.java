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
public class VillanServiceTests {

    @Mock
    VillanRepository mockVillanRepository;

    @InjectMocks
    VillanService subject;

    @Test
    void createAVillan() {
        VillanDto villanDto = new VillanDto("ArchRival1","Zach", "Zachkry Neagley","Dummy Image","6","200","JavaBeans","10","500","60","6","Test Desc","Zach Story","Story2");
        subject.create(villanDto);
        verify(mockVillanRepository).save(
                new VillanEntity("ArchRival1","Zach", "Zachkry Neagley","Dummy Image",
                        "6","200","JavaBeans","10","500","60","6",
                        "Test Desc","Zach Story","Story2")
        );
    }
    //Get All Heros
    @Test
    void GetAllVillan() {
        // S Seat
        VillanEntity villanEntity = new VillanEntity("ArchRival1", "Zach", "Zachkry Neagley", "Dummy Image",
                "6", "200", "JavaBeans", "10", "500", "60", "6",
                "Test Desc", "Zach Story", "Story2");
        when(mockVillanRepository.findAll()).thenReturn(
                List.of(
                        villanEntity,
                        new VillanEntity("ArchRival1", "Rohit", "Rohit Ranjan", "Dummy Image2",
                                "6", "200", ".NET", "10", "500", "60", "6",
                                "Test Desc", "Zach Story", "Story2")
                )
        );


        // E Exercise
        List<VillanDto> actual = subject.fetchAll();

        // A Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new VillanDto("ArchRival1","Zach", "Zachkry Neagley","Dummy Image",
                                "6","200","JavaBeans","10","500","60","6",
                                "Test Desc","Zach Story","Story2"),
                        new VillanDto("ArchRival1","Rohit", "Rohit Ranjan","Dummy Image2",
                                "6","200",".NET","10","500","60","6",
                                "Test Desc","Zach Story","Story2")
                )
        );
    }
//    //Get All Heros
//    @Test
//    void GetVillanByName() throws Exception {
//        // S Seat
//        HeroEntity heroEntity1 = new HeroEntity("Rohit", "Rohit Ranjan","Dummy Image2",
//                "6","200","JavaBeans","10","500","60","6",
//                "Test Desc","Rohit Story","Story3");
//        HeroEntity heroEntity2 = new HeroEntity("Zach", "Zachkry Neagley","Dummy Image",
//                "6","200","JavaBeans","10","500","60","6",
//                "Test Desc","Zach Story","Story2");
//        HeroEntity heroEntity3 = new HeroEntity("David", "David Roy","Dummy Image4",
//                "6","200","Angular","10","500","60","6",
//                "Test Desc","Zach Story3","Story3");
//        when(mockHeroRepository.findAll()).thenReturn(
//                List.of(
//                        heroEntity1,
//                        heroEntity2,
//                        heroEntity3
//                )
//        );
//
//        // E Exercise
//
//        List<HeroDto> actual = subject.GetHeroByName("Zach");
//
//        // A Assert
//        assertThat(actual).isEqualTo(
//                List.of(
//                        new HeroDto("Zach", "Zachkry Neagley","Dummy Image",
//                                "6","200","JavaBeans","10","500","60","6",
//                                "Test Desc","Zach Story","Story2")
//                )
//        );
//    }
//    //GetheroByName Invalid scenario


}
