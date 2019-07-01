package com.lucasdev.ParkFriend.service;

import com.lucasdev.ParkFriend.model.Pessoa;
import com.lucasdev.ParkFriend.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public Pessoa add(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public Pessoa update(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Pessoa findBYiD(Long id){
        return repository.findById(id).get();
    }

    public void delete(Long id){ repository.deleteById(id); }

}
