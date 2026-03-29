package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.Recall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RecallRepository extends JpaRepository<Recall, Long> {
    Optional<Recall> findByRecallNumber(String recallNumber);
}
