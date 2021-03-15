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
    void create() {
       HeroDto heroDto = new HeroDto("Mr", "John Smith");
       subject.create(heroDto);
       verify(mockHeroRepository).save(
               new HeroEntity("Mr", "John Smith")
       );
    }

    @Test
    void fetchAll() {
        // S Seat
        HeroEntity heroEntity = new HeroEntity("Mr", "George Orwell");
        when(mockHeroRepository.findAll()).thenReturn(
                List.of(
                        heroEntity,
                   new HeroEntity("Mr", "Blake Master")
                )
        );

        // E Exercise
        List<HeroDto> actual = subject.fetchAll();

        // A Assert
        assertThat(actual).isEqualTo(
                List.of(
                        new HeroDto("Mr", "George Orwell"),
                        new HeroDto("Mr", "Blake Master")
                )
        );
    }
}
