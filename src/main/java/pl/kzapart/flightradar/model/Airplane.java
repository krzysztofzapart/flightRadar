package pl.kzapart.flightradar.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class Airplane {
    private String icao24;
    private String callsign;
    private String origin_country;
    private float longitude;
    private float latitude;
}
