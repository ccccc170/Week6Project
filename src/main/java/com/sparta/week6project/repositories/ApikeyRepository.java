package com.sparta.week6project.repositories;

import com.sparta.week6project.entities.Apikey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApikeyRepository extends JpaRepository<Apikey, Integer> {
    Apikey save(String key);

    Optional<Apikey> findByEmail(String email);

    //    List<String> findAllKeysByEmail(String email);
    @Query(value = "SELECT * FROM apikeys WHERE email = :email", nativeQuery = true)
    List<Apikey> findAllByEmail(String email);

    Optional<Apikey> findByApiKey(String key);
}
