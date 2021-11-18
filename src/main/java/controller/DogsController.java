package controller;

import model.Dog;
import service.DogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/dogs")
@RequiredArgsConstructor
public class DogsController {
    @Autowired
    private final DogsService service;

    @GetMapping
    public ResponseEntity<List<Dog>> getDogs(){
        return new ResponseEntity<>(service.getDogs(), HttpStatus.OK);
    }

    @PostMapping
    public Dog postDogs(@RequestBody Dog dto){
        service.add(dto);
        return dto;
    }

    @GetMapping("/{id}")
    public Dog getById(@PathVariable(required = true) long id){
        return service.getDogById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable(required = true) long id){
        service.delete(id);
        return "Dog deletado: " + id + "!";
    }
}