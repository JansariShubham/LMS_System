package com.spring.lms.repository;

import com.spring.lms.model.NewsLetter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewsLetterRepository extends JpaRepository<NewsLetter, Long> {
    Optional<NewsLetter> findByEmail(String email);

    void deleteByEmail(String email);

    @Query(
            "SELECT n.email FROM NewsLetter as n"
    )
    List<String> getAllEmailAddressFromNewsLetter();
}
