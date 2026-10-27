package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.services.exceptions.ResourceNotFoundException;
import com.devsuperior.dsmovie.tests.ScoreFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ScoreServiceTests {

    @InjectMocks
    private ScoreService service;

    @Mock
    private ScoreRepository repository;

    @Mock
    private MovieRepository movieRepository;

    @Mock
    private UserService userService;

    private Movie movie;
    private User user;
    private ScoreDTO scoreDTO;
    private Score score;

    @BeforeEach
    public void setUp() {
        score = ScoreFactory.createScoreEntity();

        movie = score.getId().getMovie();
        user = score.getId().getUser();

        scoreDTO = new ScoreDTO(
                movie.getId(),
                score.getValue()
        );
    }

    @Test
    public void saveScoreShouldReturnMovieDTO() {

        Mockito.when(userService.authenticated()).thenReturn(user);
        Mockito.when(movieRepository.findById(scoreDTO.getMovieId())).thenReturn(Optional.of(movie));
        Mockito.when(repository.saveAndFlush(Mockito.any())).thenReturn(score);
        Mockito.when(movieRepository.save(Mockito.any())).thenReturn(movie);

        MovieDTO result = service.saveScore(scoreDTO);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(movie.getId(), result.getId());
        Assertions.assertEquals(movie.getTitle(), result.getTitle());
    }

    @Test
    public void saveScoreShouldThrowResourceNotFoundExceptionWhenNonExistingMovieId() {

        Mockito.when(movieRepository.findById(scoreDTO.getMovieId())).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.saveScore(scoreDTO);
        });
    }
}
