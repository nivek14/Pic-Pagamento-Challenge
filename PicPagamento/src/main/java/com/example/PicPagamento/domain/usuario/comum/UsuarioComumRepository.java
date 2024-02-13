package com.example.PicPagamento.domain.usuario.comum;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioComumRepository extends JpaRepository<UsuarioComum, String> {

    public Iterable<UsuarioComum> findByName(String nome);
    public Iterable<UsuarioComum> findByCpfOrCnjp(String cpfOrCnpj);
    public Iterable<UsuarioComum> findByEmail(String email);

}
