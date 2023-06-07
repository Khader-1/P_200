package arwakhudeir;

public class Medication {
    private int id;
    private String name;
    private String form;
    private String dosage;

    public Medication(int id, String name, String form, String dosage) {
        this.id = id;
        this.name = name;
        this.form = form;
        this.dosage = dosage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getForm() {
        return form;
    }

    public String getDosage() {
        return dosage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Form: " + form + "\n" +
                "Dosage: " + dosage;
    }
}
