package com.example.PicPagamento.repositories;

import com.example.PicPagamento.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    public Optional<Usuario> findByNome(String nome);
    public Optional<Usuario> findByDocumento(String documento);
    public Optional<Usuario> findByEmail(String email);
    public Optional<Usuario> findById(Long id);

}
