package backend.controller;

import backend.model.Route;
import backend.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/climbingapp/route")
public class RouteController {
    @Autowired
    private RouteRepository routeRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewRoute (@RequestParam String name, @RequestParam String grade) {
        Route route = new Route();
        route.setName(name);
        route.setGrade(grade);
        routeRepository.save(route);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @GetMapping(path="/get")
    public @ResponseBody Route findRouteById(@RequestParam Long id) {
        return routeRepository.findOne(id);
    }
}