package arwakhudeir;

import java.util.ArrayList;
import java.util.List;

public class Visit {
    private static int counter = 1;

    private int id;
    private Patient patient;
    private List<String> diagnoses;
    private List<Medication> medications;

    public Visit(Patient patient) {
        this.id = counter++;
        this.patient = patient;
        this.diagnoses = new ArrayList<>();
        this.medications = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public List<String> getDiagnoses() {
        return diagnoses;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void addDiagnosis(String diagnosis) {
        diagnoses.add(diagnosis);
    }

    public void addMedication(Medication medication) {
        medications.add(medication);
    }
}
