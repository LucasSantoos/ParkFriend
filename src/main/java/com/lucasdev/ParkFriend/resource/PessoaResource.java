package com.lucasdev.ParkFriend.resource;

import com.lucasdev.ParkFriend.model.Pessoa;
import com.lucasdev.ParkFriend.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService entity;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Pessoa> findAll(){
        return entity.findAll();
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa findById(@PathVariable("id") Long id){
        return entity.findBYiD(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Pessoa add(@RequestBody Pessoa pessoa){
        return entity.add(pessoa);
    }

    @PutMapping(path = "{id}",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pessoa> update(@PathVariable("id") Long id, @RequestBody Pessoa pessoa){
        if (id.equals(pessoa.getId())){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(entity.update(pessoa));
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable("id") Long id){
        entity.delete(id);
    }
}
