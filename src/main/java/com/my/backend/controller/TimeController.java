package com.my.backend.controller;

import com.my.backend.entity.Time;
import com.my.backend.repository.TimeRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TimeController {
    private final TimeRepository timeRepository;

    public TimeController(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }


    @GetMapping("/time")
    public String get(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM-dd HH:mm:ss");
        return currentTime.format(formatter);
    }

    @GetMapping("/time/add")
    public String addTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        Time time = new Time(currentTime);
        timeRepository.save(time);
        return "현재시각인 데이터베이스에 저장됨";
    }
    @GetMapping("/time/list")
    public List<Time> getTimeList(){
        return (List<Time>) timeRepository.findAll();
    }
}
