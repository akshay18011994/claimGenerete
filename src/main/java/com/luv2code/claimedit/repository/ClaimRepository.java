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

     @Query(value = "SELECT * FROM Claim c WHERE c.id <> COALESCE(:#{#claim.id}, (SELECT MAX(cl.id) + 1 FROM Claim cl)) AND c.patient_id = :#{#claim.patientDetails.id} AND c.created > :localDate", nativeQuery = true)
    public List<Claim> fetchClaimOlderThanGivenDate(Claim claim,@Param("localDate") LocalDate localDate);

    //@Query("SELECT DISTINCT c FROM Claim c LEFT JOIN c.charges ch ON ch.claimId = c.id AND ch.status ='A' WHERE c.id = :id")
    //@Query("SELECT DISTINCT c FROM Claim c LEFT JOIN FETCH c.charges ch ON ch.claimId = c.id AND ch.status = 'A' WHERE c.id = :id")
      @Query("SELECT DISTINCT c FROM Claim c LEFT JOIN FETCH c.charges ch WHERE c.id = :id AND (ch.status = 'A')")
    Claim findAllClaimsWithChargesByStatus(@Param("id")int id);
}
