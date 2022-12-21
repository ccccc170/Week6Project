
package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.Title;
import com.sparta.week5project.entities.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TitleRepository extends JpaRepository<Title, TitleId> {

    @Query(value = "SELECT emp_no FROM titles WHERE from_date>= :givenYear AND title = :title",nativeQuery = true)
    List<Integer> findAllByTitle(String title, LocalDate givenYear);
}