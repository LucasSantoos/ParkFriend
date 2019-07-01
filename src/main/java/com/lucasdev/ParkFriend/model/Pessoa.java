package com.lucasdev.ParkFriend.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "PESSOAS")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_pessoa")
    private Long id;

    @Column(name = "NOME")
    @NotNull
    @Size(min = 2, max = 255, message = "O campo nome deve conter no minimo (min) e no máximo (max) caracteres.")
    private String nome;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Vaga> vaga;

    @OneToMany(mappedBy = "pessoa", orphanRemoval = true)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Veiculo> veiculo;

}