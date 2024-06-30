package edu.alura.literalura.repository;

import edu.alura.literalura.model.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorEntity, Long> {
    boolean existsByName(String name);
    AuthorEntity findByName(String name);
    @Query(value="from AuthorEntity a where :year BETWEEN a.birthYear AND a.deathYear")
    List<AuthorEntity> getAuthorsBetweenDateAlive (@Param("year")int year);
}
