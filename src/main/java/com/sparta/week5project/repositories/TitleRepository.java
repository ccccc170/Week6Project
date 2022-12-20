
package com.sparta.week5project.repositories;

import com.sparta.week5project.entities.Title;
import com.sparta.week5project.entities.TitleId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, TitleId> {
}