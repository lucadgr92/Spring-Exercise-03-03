package com.develhope.Exercise0303.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/create")
    private CarEntity createCar(@RequestBody CarEntity carEntity) {
        CarEntity carSaved = carRepository.saveAndFlush(carEntity);
        return carSaved;
    }

    @GetMapping("/allcars")
    private List<CarEntity> getAll() {
        List<CarEntity> allCars = carRepository.findAll();
        return allCars;
    }

    @GetMapping("/car/{id}")
    private CarEntity getCar(@PathVariable long id) {
        if(carRepository.existsById(id)) {
            CarEntity savedCar = carRepository.getById(id);
            return savedCar;
        } else {
            return new CarEntity();
        }
    }

    @DeleteMapping("/delcar/{id}")
    public ResponseEntity<String> deleteSingle(@PathVariable long id) {
        if(carRepository.existsById(id)) {
            carRepository.deleteById(id);
            return ResponseEntity.ok("Car deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Car with id: " + id + " not found.");
        }
    }

    @DeleteMapping("/delcars")
    private void deleteAll() {
        carRepository.deleteAll();
    }

    @PatchMapping("/typeup/{id}")
    private CarEntity updateType(@PathVariable long id, @RequestParam String newType) {
        if(carRepository.existsById(id)) {
            CarEntity carToPatch = carRepository.getById(id);
            carToPatch.setType(newType);
            carRepository.saveAndFlush(carToPatch);
            return carToPatch;
        } else {
            return new CarEntity();
        }
    }

}
