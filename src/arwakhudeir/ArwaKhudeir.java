package arwakhudeir;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class ArwaKhudeir {
    public static void main(String[] args) {
        Clinic clinic = new Clinic();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---- Clinic Management System ----");
            System.out.println("1. Add Doctor");
            System.out.println("2. Remove Doctor");
            System.out.println("3. List All Doctors");
            System.out.println("4. Add Patient");
            System.out.println("5. Remove Patient");
            System.out.println("6. List All Patients");
            System.out.println("7. Add Medication");
            System.out.println("8. Remove Medication");
            System.out.println("9. Schedule Appointment");
            System.out.println("10. Add Diagnosis");
            System.out.println("11. Add Medication to Visit");
            System.out.println("12. Print Prescription");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("---- Add Doctor ----");
                    System.out.print("Enter Doctor ID: ");
                    int doctorId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Doctor Name: ");
                    String doctorName = scanner.nextLine();
                    System.out.print("Enter Doctor Address: ");
                    String doctorAddress = scanner.nextLine();
                    System.out.print("Enter Doctor Phone Number: ");
                    String doctorPhoneNumber = scanner.nextLine();
                    System.out.print("Enter Doctor Specialization: ");
                    String doctorSpecialization = scanner.nextLine();

                    Doctor doctor = new Doctor(doctorId, doctorName, doctorAddress, doctorPhoneNumber,
                            doctorSpecialization);
                    clinic.addDoctor(doctor);
                    System.out.println("Doctor added successfully!");
                    break;
                case 2:
                    System.out.println("---- Remove Doctor ----");
                    System.out.print("Enter Doctor ID: ");
                    int removeDoctorId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Doctor removeDoctor = clinic.searchDoctorById(removeDoctorId);
                    if (removeDoctor != null) {
                        clinic.removeDoctor(removeDoctor);
                        System.out.println("Doctor removed successfully!");
                    } else {
                        System.out.println("Doctor not found!");
                    }
                    break;
                case 3:
                    System.out.println("---- List All Doctors ----");
                    for (Doctor listDoctor : clinic.getAllDoctors()) {
                        System.out.println(listDoctor);
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("---- Add Patient ----");
                    System.out.print("Enter Patient ID: ");
                    int patientId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Patient Name: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Enter Patient Address: ");
                    String patientAddress = scanner.nextLine();
                    System.out.print("Enter Patient Phone Number: ");
                    String patientPhoneNumber = scanner.nextLine();
                    System.out.print("Enter Patient Gender (M/F): ");
                    char patientGender = scanner.nextLine().charAt(0);
                    System.out.print("Enter Patient Age: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Patient Medical History: ");
                    String patientMedicalHistory = scanner.nextLine();

                    Patient patient = new Patient(patientId, patientName, patientAddress, patientPhoneNumber,
                            patientGender, patientAge, patientMedicalHistory);
                    clinic.addPatient(patient);
                    System.out.println("Patient added successfully!");
                    break;
                case 5:
                    System.out.println("---- Remove Patient ----");
                    System.out.print("Enter Patient ID: ");
                    int removePatientId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Patient removePatient = clinic.searchPatientById(removePatientId);
                    if (removePatient != null) {
                        clinic.removePatient(removePatient);
                        System.out.println("Patient removed successfully!");
                    } else {
                        System.out.println("Patient not found!");
                    }
                    break;
                case 6:
                    System.out.println("---- List All Patients ----");
                    for (Patient listPatient : clinic.getAllPatients()) {
                        System.out.println(listPatient);
                        System.out.println();
                    }
                    break;
                case 7:
                    System.out.println("---- Add Medication ----");
                    System.out.print("Enter Medication ID: ");
                    int medicationId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Medication Name: ");
                    String medicationName = scanner.nextLine();
                    System.out.print("Enter Medication Form: ");
                    String medicationForm = scanner.nextLine();
                    System.out.print("Enter Medication Dosage: ");
                    String medicationDosage = scanner.nextLine();

                    Medication medication = new Medication(medicationId, medicationName, medicationForm,
                            medicationDosage);
                    clinic.addMedication(medication);
                    System.out.println("Medication added successfully!");
                    break;
                case 8:
                    System.out.println("---- Remove Medication ----");
                    System.out.print("Enter Medication ID: ");
                    int removeMedicationId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Medication removeMedication = clinic.getAllMedications().stream()
                            .filter(med -> med.getId() == removeMedicationId)
                            .findFirst()
                            .orElse(null);
                    if (removeMedication != null) {
                        clinic.removeMedication(removeMedication);
                        System.out.println("Medication removed successfully!");
                    } else {
                        System.out.println("Medication not found!");
                    }
                    break;
                case 9:
                    System.out.println("---- Schedule Appointment ----");
                    System.out.print("Enter Doctor ID: ");
                    int appointmentDoctorId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Patient ID: ");
                    int appointmentPatientId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Appointment Date (yyyy-mm-dd): ");
                    String appointmentDateStr = scanner.nextLine();
                    LocalDate appointmentDate = LocalDate.parse(appointmentDateStr);
                    System.out.print("Enter Appointment Time (hh:mm): ");
                    String appointmentTimeStr = scanner.nextLine();
                    LocalTime appointmentTime = LocalTime.parse(appointmentTimeStr);

                    Doctor appointmentDoctor = clinic.searchDoctorById(appointmentDoctorId);
                    Patient appointmentPatient = clinic.searchPatientById(appointmentPatientId);
                    if (appointmentDoctor != null && appointmentPatient != null) {
                        clinic.scheduleAppointment(appointmentDoctor, appointmentPatient, appointmentDate,
                                appointmentTime);
                        System.out.println("Appointment scheduled successfully!");
                    } else {
                        System.out.println("Doctor or patient not found!");
                    }
                    break;
                case 10:
                    System.out.println("---- Add Diagnosis ----");
                    System.out.print("Enter Visit ID: ");
                    int visitId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Diagnosis: ");
                    String diagnosis = scanner.nextLine();

                    Visit visit = clinic.getAllVisits().stream()
                            .filter(v -> v.getId() == visitId)
                            .findFirst()
                            .orElse(null);
                    if (visit != null) {
                        clinic.addDiagnosis(visit, diagnosis);
                        System.out.println("Diagnosis added successfully!");
                    } else {
                        System.out.println("Visit not found!");
                    }
                    break;
                case 11:
                    System.out.println("---- Add Medication to Visit ----");
                    System.out.print("Enter Visit ID: ");
                    int medicationVisitId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Medication ID: ");
                    int medicationIdToAdd = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Visit medicationVisit = clinic.getAllVisits().stream()
                            .filter(v -> v.getId() == medicationVisitId)
                            .findFirst()
                            .orElse(null);
                    Medication medicationToAdd = clinic.getAllMedications().stream()
                            .filter(m -> m.getId() == medicationIdToAdd)
                            .findFirst()
                            .orElse(null);
                    if (medicationVisit != null && medicationToAdd != null) {
                        clinic.addMedicationToVisit(medicationVisit, medicationToAdd);
                        System.out.println("Medication added to visit successfully!");
                    } else {
                        System.out.println("Visit or medication not found!");
                    }
                    break;
                case 12:
                    System.out.println("---- Print Prescription ----");
                    System.out.print("Enter Visit ID: ");
                    int prescriptionVisitId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Visit prescriptionVisit = clinic.getAllVisits().stream()
                            .filter(v -> v.getId() == prescriptionVisitId)
                            .findFirst()
                            .orElse(null);
                    if (prescriptionVisit != null) {
                        clinic.printPrescription(prescriptionVisit);
                    } else {
                        System.out.println("Visit not found!");
                    }
                    break;
                case 13:
                    System.out.println("Exiting the program...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        }
    }
}
