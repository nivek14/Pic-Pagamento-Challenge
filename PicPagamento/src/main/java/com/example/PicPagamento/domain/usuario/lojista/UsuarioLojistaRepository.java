package com.example.PicPagamento.domain.usuario.lojista;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLojistaRepository extends JpaRepository<UsuarioLojista, String> {

    public Iterable<UsuarioLojista> findByName(String nome);
    public Iterable<UsuarioLojista> findByCpfOrCnjp(String cpfOrCnpj);
    public Iterable<UsuarioLojista> findByEmail(String email);

}
