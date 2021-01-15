package com.acolina.timezone.service;

import com.acolina.timezone.model.TimeZoneDTO;

public interface TimeZoneService {

    TimeZoneDTO calculateTime(String time, int zone);
}
