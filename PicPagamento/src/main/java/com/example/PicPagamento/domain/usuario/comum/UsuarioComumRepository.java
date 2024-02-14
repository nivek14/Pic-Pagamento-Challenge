package com.example.PicPagamento.domain.usuario.comum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, String> {

    public Iterable<UsuarioComum> findByNome(String nome);
    public Iterable<UsuarioComum> findByCpf(String cpfOrCnpj);
    public Iterable<UsuarioComum> findByEmail(String email);

}
