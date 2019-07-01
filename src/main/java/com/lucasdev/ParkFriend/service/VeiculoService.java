package com.lucasdev.ParkFriend.service;

import com.lucasdev.ParkFriend.model.Veiculo;
import com.lucasdev.ParkFriend.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public Veiculo add(Veiculo veiculo){
        return repository.save(veiculo);
    }

    public Veiculo update(Veiculo veiculo){
        return repository.save(veiculo);
    }

    public List<Veiculo> findAll(){
        return repository.findAll();
    }

    public Veiculo findBYiD(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){ repository.deleteById(id); }

}
