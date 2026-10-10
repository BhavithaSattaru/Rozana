package com.bhavitha.rozana;

import java.time.LocalDate;
import java.time.ZoneId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomorrowController {

    private boolean paused;

    @GetMapping("/api/tomorrow")
    public TomorrowTiffin tomorrow() {
        return tiffin();
    }

    @PostMapping("/api/tomorrow/pause")
    public TomorrowTiffin pause() {
        paused = true;
        return tiffin();
    }

    private TomorrowTiffin tiffin() {
        LocalDate serviceDate = LocalDate.now(ZoneId.of("Asia/Kolkata")).plusDays(1);
        int quantity = paused ? 0 : 1;
        return new TomorrowTiffin(serviceDate, "Breakfast tiffin", quantity, "Lakshmi's Breakfast Tiffin, MVP Colony", paused);
    }
}
