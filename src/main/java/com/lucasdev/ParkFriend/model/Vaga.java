package com.lucasdev.ParkFriend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "VAGAS")
public class Vaga implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "i_vaga")
    private Long id;

    @Column(name = "descricao")
    @NotNull
    @Size(min = 2, max = 20)
    private String descricao;

}
