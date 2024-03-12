package com.example.PicPagamento.services;

import com.example.PicPagamento.domain.usuario.Usuario;
import com.example.PicPagamento.domain.usuario.UsuarioTipo;
import com.example.PicPagamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validateTransaction(Usuario sender, BigDecimal amount) throws Exception {
        if(sender.getUsuarioTipo() == UsuarioTipo.LOJISTA){
            throw new Exception("Usuário do tipo lojista não está autorizado a realizar transações");
        }
        if(sender.getSaldo().compareTo(amount) < 0){
            throw new Exception("Saldo insuficeinete");
        }
    }

    public Usuario findUsuarioById(Long id) throws Exception {
        return this.usuarioRepository.findById(id).orElseThrow(() -> new Exception("Usuario não encontrado"));
    }

    public void saveUsuario(Usuario usuario){
        this.usuarioRepository.save(usuario);
    }

}
