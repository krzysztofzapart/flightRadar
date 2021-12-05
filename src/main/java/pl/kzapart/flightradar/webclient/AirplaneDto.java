package pl.kzapart.flightradar.webclient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
public class AirplaneDto {

    private List<String> states;

}
