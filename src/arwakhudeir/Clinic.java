package arwakhudeir;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Doctor> doctors;
    private List<Patient> patients;
    private List<Medication> medications;
    private List<Visit> visits;

    public Clinic() {
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
        this.medications = new ArrayList<>();
        this.visits = new ArrayList<>();
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public List<Medication> getAllMedications() {
        return medications;
    }

    public List<Visit> getAllVisits() {
        return visits;
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void removeDoctor(Doctor doctor) {
        doctors.remove(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    public void scheduleAppointment(Doctor doctor, Patient patient, LocalDate date, LocalTime time) {
        Reservation reservation = new Reservation(date, time);
        doctor.addReservation(reservation);
    }

    public void addDiagnosis(Visit visit, String diagnosis) {
        visit.addDiagnosis(diagnosis);
    }

    public void addMedicationToVisit(Visit visit, Medication medication) {
        visit.addMedication(medication);
    }

    public void printPrescription(Visit visit) {
        System.out.println("---- Prescription ----");
        System.out.println("Patient Information:");
        System.out.println(visit.getPatient());
        System.out.println("\nMedications:");
        for (Medication medication : visit.getMedications()) {
            System.out.println(medication);
        }
    }

    public Doctor searchDoctorById(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    public Patient searchPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getId() == patientId) {
                return patient;
            }
        }
        return null;
    }
}
