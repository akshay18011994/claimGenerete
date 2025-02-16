package com.luv2code.claimedit.entity;

import com.luv2code.claimedit.validate.StartWithCode;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "patient_details")
public class PatientDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    @SequenceGenerator(name = "patient_seq", sequenceName = "patient_seq", allocationSize = 1)
    private int id;
    @Column(name = "patient_name")
    private String patientName;
    @Column(name = "patient_dob")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate patientDOB;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "state")
    private String state;
    @Column(name = "city")
    private String city;
    @Column(name = "zipcode")
    private String zipcode;
    @Column(name = "contact_extention")
    private int contactExtention;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "insurance_provider_name")
    private String insuranceProviderName;
    @Column(name = "insurance_number")
    //@StartWithCode(value = "INS" , message = "Insurance Number must start with 'INS'")
    private String insuranceNumber;
    @Column(name = "allergies")
    private String allergies;
    @Column(name = "medical_history")
    private String medicalHistory;
    @Column(name = "emergency_contact_name")
    private String emergencyContactName;
    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;

    @OneToMany(mappedBy = "patientDetails", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Claim> claims;


    public PatientDetails()
    {

    }

    public PatientDetails(int id, String patientName, LocalDate patientDOB, String gender) {
        this.id = id;
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.gender = gender;
    }

    public PatientDetails(int id, String patientName, LocalDate patientDOB, String gender, String address, String state, String city, String zipcode, int contactExtention, String contactNumber, String email, String insuranceProviderName, String insuranceNumber, String allergies, String medicalHistory, String emergencyContactName, String emergencyContactNumber) {
        this.id = id;
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.gender = gender;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.contactExtention = contactExtention;
        this.contactNumber = contactNumber;
        this.email = email;
        this.insuranceProviderName = insuranceProviderName;
        this.insuranceNumber = insuranceNumber;
        this.allergies = allergies;
        this.medicalHistory = medicalHistory;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public PatientDetails(String patientName, LocalDate patientDOB, String gender, String address, String state, String city, String zipcode, int contactExtention, String contactNumber, String email, String insuranceProviderName, String insuranceNumber, String allergies, String medicalHistory, String emergencyContactName, String emergencyContactNumber) {
        this.patientName = patientName;
        this.patientDOB = patientDOB;
        this.gender = gender;
        this.address = address;
        this.state = state;
        this.city = city;
        this.zipcode = zipcode;
        this.contactExtention = contactExtention;
        this.contactNumber = contactNumber;
        this.email = email;
        this.insuranceProviderName = insuranceProviderName;
        this.insuranceNumber = insuranceNumber;
        this.allergies = allergies;
        this.medicalHistory = medicalHistory;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public LocalDate getPatientDOB() {
        return patientDOB;
    }

    public void setPatientDOB(LocalDate patientDOB) {
        this.patientDOB = patientDOB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public int getContactExtention() {
        return contactExtention;
    }

    public void setContactExtention(int contactExtention) {
        this.contactExtention = contactExtention;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInsuranceProviderName() {
        return insuranceProviderName;
    }

    public void setInsuranceProviderName(String insuranceProviderName) {
        this.insuranceProviderName = insuranceProviderName;
    }

    public String getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    @Override
    public String toString() {
        return "PatientDetails{" +
                "id=" + id +
                ", patientName='" + patientName + '\'' +
                ", patientDOB=" + patientDOB +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", contactExtention=" + contactExtention +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", insuranceProviderName='" + insuranceProviderName + '\'' +
                ", insuranceNumber='" + insuranceNumber + '\'' +
                ", allergies='" + allergies + '\'' +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", emergencyContactName='" + emergencyContactName + '\'' +
                ", emergencyContactNumber='" + emergencyContactNumber + '\'' +
                '}';
    }
}
