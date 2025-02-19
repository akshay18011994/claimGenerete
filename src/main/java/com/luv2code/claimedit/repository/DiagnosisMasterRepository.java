package com.luv2code.claimedit.repository;

import com.luv2code.claimedit.entity.DiagnosisMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnosisMasterRepository extends JpaRepository<DiagnosisMaster , Integer> {

    public DiagnosisMaster findByDiagnosisCode(String diagnosisCode);
}
