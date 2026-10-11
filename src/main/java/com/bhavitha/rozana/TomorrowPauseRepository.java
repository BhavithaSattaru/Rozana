package com.bhavitha.rozana;

import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TomorrowPauseRepository extends JpaRepository<TomorrowPause, LocalDate> {
}