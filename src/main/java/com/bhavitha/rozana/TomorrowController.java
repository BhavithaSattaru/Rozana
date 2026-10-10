package com.bhavitha.rozana;

import java.time.LocalDate;
import java.time.ZoneId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TomorrowController {

    @GetMapping("/api/tomorrow")
    public TomorrowTiffin tomorrow() {
        LocalDate serviceDate = LocalDate.now(ZoneId.of("Asia/Kolkata")).plusDays(1);
        return new TomorrowTiffin(serviceDate, "Breakfast tiffin", 1, "Lakshmi's Breakfast Tiffin, MVP Colony");
    }
}
