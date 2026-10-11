package com.bhavitha.rozana;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class TomorrowPause {

    @Id
    private LocalDate serviceDate;
    private boolean paused;

    protected TomorrowPause() {
    }

    public TomorrowPause(LocalDate serviceDate, boolean paused) {
        this.serviceDate = serviceDate;
        this.paused = paused;
    }

    public boolean isPaused() {
        return paused;
    }
}