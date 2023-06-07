package arwakhudeir;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {
    private LocalDate date;
    private LocalTime time;

    public Reservation(LocalDate date, LocalTime time) {
        this.date = date;
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }
}
