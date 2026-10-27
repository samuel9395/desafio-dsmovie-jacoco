package com.devsuperior.dsmovie.tests;

import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;

public class ScoreFactory {

    public static Double scoreValue = 4.5;

    public static Score createScoreEntity() {
        Movie movie = MovieFactory.createMovieEntity();
        User user = UserFactory.createUserEntity();
        Score score = new Score();

        score.setMovie(movie);
        score.setUser(user);
        score.setValue(scoreValue);
        movie.getScores().add(score);
        return score;
    }

    public static ScoreDTO createScoreDTO() {
        Score score = createScoreEntity();
        return new ScoreDTO(score.getId().getMovie().getId(), score.getValue());
    }
}
