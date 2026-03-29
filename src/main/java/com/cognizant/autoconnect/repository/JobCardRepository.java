package com.cognizant.autoconnect.repository;

import com.cognizant.autoconnect.entity.JobCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface JobCardRepository extends JpaRepository<JobCard, Long> {
    Optional<JobCard> findByWoid(Long woid);
    List<JobCard> findByTechnicianId(Long technicianId);
    List<JobCard> findByStatus(String status);
}
