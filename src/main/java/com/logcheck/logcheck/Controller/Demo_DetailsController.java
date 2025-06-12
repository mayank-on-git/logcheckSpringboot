package com.logcheck.logcheck.Controller;

import com.logcheck.logcheck.Service.Demo_dataService;
import com.logcheck.logcheck.entity.Demo_Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class Demo_DetailsController {
    @Autowired
    Demo_dataService demoDataService;

    @PostMapping("/save/details")
   public Demo_Details save(@RequestBody Demo_Details demoDetails){
        demoDataService.saveData(demoDetails);
        return  demoDetails;

    }

@GetMapping("/{id}")
    public Demo_Details findById(@PathVariable long id){
    return demoDataService.findById(id);
}

}



