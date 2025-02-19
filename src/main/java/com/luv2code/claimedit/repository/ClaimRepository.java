package com.luv2code.claimedit.repository;

import com.luv2code.claimedit.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ClaimRepository extends JpaRepository<Claim,Integer> {

    @Query("SELECT c FROM Claim c where c.patientId = :#{#claim.patientDetails.id} AND c.created > :localDate")
    public List<Claim> fetchClaimOlderThanGivenDate(Claim claim,@Param("localDate") LocalDate localDate);
}
