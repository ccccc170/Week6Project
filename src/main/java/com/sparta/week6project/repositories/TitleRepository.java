
package com.sparta.week6project.repositories;

import com.sparta.week6project.entities.Title;
import com.sparta.week6project.entities.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface TitleRepository extends JpaRepository<Title, TitleId> {

    @Query(value = "SELECT emp_no FROM titles WHERE from_date>= :givenYear AND title = :title",nativeQuery = true)
    List<Integer> findAllByTitle(String title, LocalDate givenYear);
}