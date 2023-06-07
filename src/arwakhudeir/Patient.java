package arwakhudeir;

public class Patient extends Person {
    private char gender;
    private int age;
    private String medicalHistory;

    public Patient(int id, String name, String address, String phoneNumber, char gender, int age, String medicalHistory) {
        super(id, name, address, phoneNumber);
        this.gender = gender;
        this.age = age;
        this.medicalHistory = medicalHistory;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Gender: " + gender + "\n" +
                "Age: " + age + "\n" +
                "Medical History: " + medicalHistory;
    }
}
