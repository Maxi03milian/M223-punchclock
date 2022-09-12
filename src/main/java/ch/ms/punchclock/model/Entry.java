package ch.ms.punchclock.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Entry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private LocalDateTime checkIn = LocalDateTime.now();

    private LocalDateTime checkOut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

}