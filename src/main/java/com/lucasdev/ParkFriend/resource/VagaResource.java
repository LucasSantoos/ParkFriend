package com.lucasdev.ParkFriend.resource;

import com.lucasdev.ParkFriend.model.Vaga;
import com.lucasdev.ParkFriend.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vagas")
public class VagaResource {

    @Autowired
    private VagaService entity;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vaga> findAll(){
        return entity.findAll();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vaga findById(@PathVariable("id") Long id){
        return entity.findBYiD(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Vaga add(@RequestBody Vaga vaga){
        return entity.add(vaga);
    }

    @PutMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Vaga> update(@PathVariable("id") Long id, @RequestBody Vaga vaga){
        if (id.equals(vaga.getId())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(entity.update(vaga));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        entity.delete(id);
    }
}
