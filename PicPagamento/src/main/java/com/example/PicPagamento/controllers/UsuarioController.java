package com.example.PicPagamento.controllers;

import com.example.PicPagamento.domain.usuario.Usuario;
import com.example.PicPagamento.repositories.UsuarioRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getAllUsuarioComum(){
        var allComum = usuarioRepository.findAll();
        return allComum;
    }

    @GetMapping(path = "/nomes")
    public Optional<Usuario> getByName(@PathVariable String nome){
        return usuarioRepository.findByNome(nome);
    }

    @GetMapping(path = "/cpf")
    public Optional<Usuario> getByDocumento(@PathVariable String documento){
        return usuarioRepository.findByDocumento(documento);
    }

    @GetMapping(path = "/email")
    public Optional<Usuario> getByEmail(@PathVariable String email){
        return usuarioRepository.findByEmail(email);
    }

    @PostMapping
    public ResponseEntity registerUsuarioComum(@Valid Usuario usuario){
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    @PutMapping
    public ResponseEntity updateUsuarioComum(@Valid Usuario usuario){
        Optional<Usuario> optionalUsuarioComum = usuarioRepository.findById(String.valueOf(usuario.getId()));
        if(optionalUsuarioComum.isPresent()){
            usuarioRepository.save(usuario);
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        }
        else{
            return ResponseEntity.ok("Usuário não encontrado...");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUsuarioComum(@Valid Usuario usuario){
        usuarioRepository.deleteById(String.valueOf(usuario.getId()));
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

}
