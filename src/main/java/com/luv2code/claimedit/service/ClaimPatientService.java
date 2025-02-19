package com.luv2code.claimedit.service;

import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.PatientDetails;

import java.util.List;

public interface ClaimPatientService {

    PatientDetails getPatientClaims(PatientDetails patientDetails);

    Claim fetchClaim(int id);

    PatientDetails savePatientDetails(PatientDetails patientDetails);

    PatientDetails getPatientDetail(int id);

    Claim saveClaim(Claim claim);
}
