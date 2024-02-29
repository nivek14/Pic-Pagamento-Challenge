package com.example.PicPagamento.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    public Iterable<Usuario> findByNome(String nome);
    public Iterable<Usuario> findByCpf(String cpfOrCnpj);
    public Iterable<Usuario> findByEmail(String email);

}
