package com.example.demo.cars;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @PostMapping
    public ResponseEntity<?> insertCar(@RequestBody Cars car){
            carsService.insertCar(car);
            return ResponseEntity.ok("Successfully Inserted");
    }
    @DeleteMapping
    public ResponseEntity<?> deleteCar(@RequestParam("name") String name){
        carsService.deleteCar(name);
        return ResponseEntity.ok("Successfully Deleted");


    }
@PutMapping
    public ResponseEntity<?> updateCar(@RequestParam("id") Long id,@RequestBody
                           Cars car){

        carsService.updateCar(id,car);
        return ResponseEntity.ok("Updated Successfully");
    }

}
