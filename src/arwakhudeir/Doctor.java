package arwakhudeir;

import java.util.ArrayList;
import java.util.List;

public class Doctor extends Person {
    private String specialization;
    private List<Reservation> reservations;

    public Doctor(int id, String name, String address, String phoneNumber, String specialization) {
        super(id, name, address, phoneNumber);
        this.specialization = specialization;
        this.reservations = new ArrayList<>();
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Specialization: " + specialization + "\n" +
                "Reservations: " + reservations.size();
    }
}
