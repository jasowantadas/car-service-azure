package com.example.demo.cars;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Map;
@CrossOrigin(origins = "*", allowedHeaders = "*",methods = {RequestMethod.GET, RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.PATCH})
@RestController
@RequestMapping(path="api/v1/Cars")
public class CarsController {

@Autowired
private CarsService carsService;

@GetMapping("/{name}/{interval}")
public  ResponseEntity<?> getIntervalDiff(@PathVariable("name") String name,@PathVariable("interval") Float interval){
    return ResponseEntity.ok(carsService.getIntervalDiff(name,interval));
}

    @GetMapping("/{name}")
    public ResponseEntity<?> getCar(@PathVariable("name") String name){
            return ResponseEntity.ok(carsService.getCar(name));

    }
    @GetMapping
    public ResponseEntity<?> getCars(){
            return ResponseEntity.ok(carsService.getCars());
    }
    @PostMapping(produces = "application/json")
    public ResponseEntity<?> insertCar(@RequestBody Cars car){
            carsService.insertCar(car);
            
            return ResponseEntity.ok().body(Map.of("message", "Successfully Inserted"));
    }
    @DeleteMapping(produces = "application/json")
    public ResponseEntity<?> deleteCar(@RequestParam("name") String name){
        carsService.deleteCar(name);
        return ResponseEntity.ok().body(Map.of("message", "Successfully Deleted"));


    }
@PutMapping
    public ResponseEntity<?> updateCar(@RequestParam("id") Long id,@RequestBody
                           Cars car){

        carsService.updateCar(id,car);
        return ResponseEntity.ok("Updated Successfully");
    }

}
