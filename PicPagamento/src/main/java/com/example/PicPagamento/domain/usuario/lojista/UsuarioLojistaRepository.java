package com.example.PicPagamento.domain.usuario.lojista;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioLojistaRepository extends JpaRepository<UsuarioLojista, String> {

    public Iterable<UsuarioLojista> findByNome(String nome);
    public Iterable<UsuarioLojista> findByCpf(String cpfOrCnpj);
    public Iterable<UsuarioLojista> findByEmail(String email);

}
