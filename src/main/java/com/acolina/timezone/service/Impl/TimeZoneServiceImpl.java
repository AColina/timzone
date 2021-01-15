package com.acolina.timezone.service.Impl;

import com.acolina.timezone.model.TimeZoneDTO;
import com.acolina.timezone.service.TimeZoneService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

@Service
public class TimeZoneServiceImpl implements TimeZoneService {

    @Override
    public TimeZoneDTO calculateTime(String time, int zone) {
        final TimeZoneDTO dto;
        if (validTime(time)) {
            final TimeZone from = getTimeZone(zone);
            final TimeZone to = TimeZone.getTimeZone("UTC");
            dto = buildDto(from, to, time);
        } else {
            throw new IllegalArgumentException("time not valid");
        }
        return dto;
    }

    private TimeZoneDTO buildDto(TimeZone tzFrom, TimeZone tzTo, String dateToChange) {
        String time = changeTZ(tzFrom, tzTo, dateToChange);
        return TimeZoneDTO.builder()
                .time(time)
                .timezone(tzTo.getID())
                .build();
    }

    public static String changeTZ(TimeZone tzFrom, TimeZone tzTo, String dateToChange) {
        ZonedDateTime zdt = ZonedDateTime.now(tzFrom.toZoneId()).with(LocalTime.parse(dateToChange));
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss").withZone(tzTo.toZoneId());
        return zdt.format(dtf2);
    }

    private boolean validTime(String time) {
        return time.matches("^([0-1]?[0-9]|[2][0-3]):([0-5][0-9])(:[0-5][0-9])?$");
    }

    private TimeZone getTimeZone(int zone) {
        String timezone = "Etc/GMT";
        zone = zone * -1;
        if (zone > -1) {
            timezone += "+";
        }
        return TimeZone.getTimeZone(timezone + zone);
    }

    public static void main(String[] args) {
        for (String id :
                TimeZone.getAvailableIDs()) {
            System.out.println(id);
        }
    }
}
