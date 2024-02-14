package com.example.PicPagamento.controllers;

import com.example.PicPagamento.domain.usuario.lojista.UsuarioLojista;
import com.example.PicPagamento.domain.usuario.lojista.UsuarioLojistaRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/lojista")
public class UsuarioLojistaController {

    @Autowired
    private UsuarioLojistaRepository usuarioLojistaRepository;

    @GetMapping
    public List<UsuarioLojista> getAllUsuarioComum(){
        var allLojista = usuarioLojistaRepository.findAll();
        return allLojista;
    }

    @GetMapping(path = "/nome")
    public Iterable<UsuarioLojista> getByName(@PathVariable String nome){
        return usuarioLojistaRepository.findByNome(nome);
    }

    @GetMapping(path = "/cpf")
    public Iterable<UsuarioLojista> getByCpf(@PathVariable String cpfOrCnpj){
        return usuarioLojistaRepository.findByCpf(cpfOrCnpj);
    }

    @GetMapping(path = "/email")
    public Iterable<UsuarioLojista> getByEmail(@PathVariable String email){
        return usuarioLojistaRepository.findByEmail(email);
    }

    @PostMapping
    public ResponseEntity registerUsuarioComum(@Valid UsuarioLojista usuarioLojista){
        usuarioLojistaRepository.save(usuarioLojista);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    @PutMapping
    public ResponseEntity updateUsuarioComum(@Valid UsuarioLojista usuarioLojista){
        Optional<UsuarioLojista> optionalUsuarioLojista = usuarioLojistaRepository.findById(String.valueOf(usuarioLojista.getId()));
        if(optionalUsuarioLojista.isPresent()){
            usuarioLojistaRepository.save(usuarioLojista);
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        }
        else{
            return ResponseEntity.ok("Usuário não encontrado...");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUsuarioComum(@Valid UsuarioLojista usuarioLojista){
        usuarioLojistaRepository.deleteById(String.valueOf(usuarioLojista.getId()));
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

}
