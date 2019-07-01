package com.lucasdev.ParkFriend.resource;

import com.lucasdev.ParkFriend.model.Veiculo;
import com.lucasdev.ParkFriend.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("veiculos")
public class VeiculoResource {

    @Autowired
    private VeiculoService entity;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Veiculo> findAll(){
        return entity.findAll();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Veiculo findById(@PathVariable("id") Long id){
        return entity.findBYiD(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Veiculo add(@RequestBody Veiculo veiculo){
        return entity.add(veiculo);
    }

    @PutMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Veiculo> update(@PathVariable("id") Long id, @RequestBody Veiculo veiculo){
        if (id.equals(veiculo.getId())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(entity.update(veiculo));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        entity.delete(id);
    }
}
