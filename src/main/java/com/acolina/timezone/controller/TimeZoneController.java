package com.acolina.timezone.controller;

import com.acolina.timezone.model.ResponseDTO;
import com.acolina.timezone.model.TimeZoneDTO;
import com.acolina.timezone.service.TimeZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeZoneController {

    @Autowired
    private TimeZoneService timeZoneService;

    @PostMapping("/convert")
    public @ResponseBody
    ResponseEntity<ResponseDTO<TimeZoneDTO>> calculateTime(@RequestParam(value = "time") String time,
                                                           @RequestParam(value = "zone") int zone) {
        return ResponseDTO.ok(timeZoneService.calculateTime(time, zone));
    }
}
