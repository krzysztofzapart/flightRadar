package pl.kzapart.flightradar.service;

import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kzapart.flightradar.model.Airplane;
import pl.kzapart.flightradar.webclient.AirplaneDto;
import pl.kzapart.flightradar.webclient.api.OpenSkyApi;
import pl.kzapart.flightradar.webclient.model.OpenSkyStates;
import pl.kzapart.flightradar.webclient.model.StateVector;

import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AirplaneService {


    private final RestTemplate restTemplate;
    //private static final String url = "https://opensky-network.org/api/states/all";

    public AirplaneService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Airplane> getAirplanes() throws IOException {
        OpenSkyApi api = new OpenSkyApi();
        OpenSkyStates os = api.getStates(0,null, null);
        Collection<StateVector> states = os.getStates();
        List<Airplane> airplanes = new LinkedList<>();
        int count =0;
        for(StateVector state : states)
        {
            if (state.getLongitude()==null|| state.getLatitude()==null || state.getIcao24()==null)
                continue;
            else
            {
                airplanes.add(Airplane.builder()
                        .icao24(state.getIcao24())
                        .callsign(state.getCallsign())
                        .latitude(state.getLatitude())
                        .longitude(state.getLongitude())
                        .origin_country(state.getOriginCountry())
                        .heading(state.getHeading())
                        .build()
                );
                count++;
            }


        }
        System.out.println(count);
    return airplanes;
    }
}
