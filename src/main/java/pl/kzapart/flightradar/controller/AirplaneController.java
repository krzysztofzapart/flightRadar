package pl.kzapart.flightradar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kzapart.flightradar.service.AirplaneService;

import java.io.IOException;

@Controller
public class AirplaneController {

    private final AirplaneService airplaneService;

    public AirplaneController(AirplaneService airplaneService) {
        this.airplaneService = airplaneService;
    }

    @GetMapping("/index")
    public String getIndex(Model model) throws IOException {
        //airplaneService.getAirplanes();
        model.addAttribute("airplanes", airplaneService.getAirplanes());
        return "map";
    }
}
