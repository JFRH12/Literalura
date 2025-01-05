package com.aluracursos.Literalura.Repository;

import com.aluracursos.Literalura.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE a.deathYear IS NULL AND a.birthYear <= :year")
    List<Author> findAliveInYear(@Param("year") int year);
}

