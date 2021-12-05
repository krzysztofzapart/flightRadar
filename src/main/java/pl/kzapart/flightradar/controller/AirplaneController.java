package pl.kzapart.flightradar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AirplaneController {

    @GetMapping("/index")
    public String getIndex()
    {
        return "map";
    }
}
