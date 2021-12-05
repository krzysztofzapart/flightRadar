package pl.kzapart.flightradar.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.kzapart.flightradar.model.Airplane;
import pl.kzapart.flightradar.webclient.AirplaneDto;

import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class AirplaneService {


    private final RestTemplate restTemplate;
    private static final String url = "https://opensky-network.org/api/states/all";

    public AirplaneService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Airplane> getAirplanes()
    {
        AirplaneDto json = restTemplate.getForObject(url, AirplaneDto.class);

        List<Airplane> airplanes = new LinkedList<>();

        System.out.println(json.getStates().get(1));

//        for (int i=0; i<json.getStates().size(); i++)
//        {
//            airplanes.add(Airplane.builder(
//                    .icao24(json.getStates().get(i)[0])
//            ));
//        }

        System.out.println(json);
    return null;
    }
}
