package com.luv2code.claimedit.repository;

import com.luv2code.claimedit.entity.PatientDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<PatientDetails,Integer> {

    @Query("SELECT p FROM PatientDetails p LEFT JOIN FETCH p.claims WHERE p.id = :#{#patientDetails.id} OR p.patientName = :#{#patientDetails.patientName}")
    public PatientDetails getPatientDetailsByIdOrName(PatientDetails patientDetails);

}
