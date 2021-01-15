package com.acolina.timezone.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class TimeZoneDTO implements Serializable {

    private String time;
    private String timezone;
}
