package pl.kzapart.flightradar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kzapart.flightradar.service.AirplaneService;

@Controller
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping("/index")
    public String getIndex()
    {
        airplaneService.getAirplanes();
        return "map";
    }
}
