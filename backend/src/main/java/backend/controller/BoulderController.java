package backend.controller;

import backend.model.Boulder;
import backend.repository.BoulderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/climbingapp/boulder")
public class BoulderController {
    @Autowired
    private BoulderRepository boulderRepository;

    @GetMapping(path="/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewBoulder (@RequestParam String name, @RequestParam String grade) {
        Boulder boulder = new Boulder();
        boulder.setName(name);
        boulder.setGrade(grade);
        boulderRepository.save(boulder);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Boulder> getAllBoulders() {
        return boulderRepository.findAll();
    }


}