package com.lucasdev.ParkFriend.service;

import com.lucasdev.ParkFriend.model.Vaga;
import com.lucasdev.ParkFriend.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VagaService {

    @Autowired
    private VagaRepository repository;

    public Vaga add(Vaga vaga){
        return repository.save(vaga);
    }

    public Vaga update(Vaga vaga){
        return repository.save(vaga);
    }

    public List<Vaga> findAll(){
        return repository.findAll();
    }

    public Vaga findBYiD(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){ repository.deleteById(id); }

}
