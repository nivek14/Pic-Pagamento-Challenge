package com.example.PicPagamento.domain.usuario.lojista;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Table(name = "lojista")
@Entity(name = "lojista")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class UsuarioLojista {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    private String nome;

    @NotBlank
    @Column(unique = true)
    private String cpf;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String password;

    @Column(columnDefinition = "float default 0")
    private float saldo;

}
