package com.devsuperior.dsmovie.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT obj FROM MovieEntity obj "
			+ "WHERE UPPER(obj.title) LIKE UPPER(CONCAT('%', :title, '%'))")
    Page<Movie> searchByTitle(String title, Pageable pageable);
}
