package com.luv2code.claimedit.service;

import com.luv2code.claimedit.entity.Claim;
import com.luv2code.claimedit.entity.PatientDetails;

import java.util.List;

public interface ClaimPatientService {

    List<Claim> getPatientClaims(PatientDetails patientDetails);

    Claim fetchClaim(int id);
}
