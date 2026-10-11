package com.bhavitha.rozana;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomorrowController {

    private final TomorrowPauseRepository tomorrowPauseRepository;

    public TomorrowController(TomorrowPauseRepository tomorrowPauseRepository) {
        this.tomorrowPauseRepository = tomorrowPauseRepository;
    }

    @GetMapping("/api/tomorrow")
    public TomorrowTiffin tomorrow() {
        return tiffin();
    }

    @PostMapping("/api/tomorrow/pause")
    public TomorrowTiffin pause() {
        save(true);
        return tiffin();
    }

    @DeleteMapping("/api/tomorrow/pause")
    public TomorrowTiffin resume() {
        save(false);
        return tiffin();
    }

    private void save(boolean paused) {
        tomorrowPauseRepository.save(new TomorrowPause(serviceDate(), paused));
    }

    private TomorrowTiffin tiffin() {
        boolean paused = tomorrowPauseRepository.findById(serviceDate())
                                                .map(TomorrowPause::isPaused)
                                                .orElse(false);
        int quantity = paused ? 0 : 1;
        return new TomorrowTiffin(serviceDate(), "Breakfast tiffin", quantity, "Lakshmi's Breakfast Tiffin, MVP Colony", paused);
    }

    private LocalDate serviceDate() {
        return LocalDate.now(ZoneId.of("Asia/Kolkata")).plusDays(1);
    }
}
