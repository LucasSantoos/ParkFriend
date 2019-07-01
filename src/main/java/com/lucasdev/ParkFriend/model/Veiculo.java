package com.lucasdev.ParkFriend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VEICULOS")
@Setter
@Getter
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_veiculo")
    private Long id;

    @Column(name = "placa")
    private String placa;

    @ManyToOne
    @JoinColumn(name = "i_pessoa", nullable = false)
    private Pessoa pessoa;

}
