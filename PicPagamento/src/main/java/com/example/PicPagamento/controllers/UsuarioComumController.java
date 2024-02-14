package com.example.PicPagamento.controllers;

import com.example.PicPagamento.domain.usuario.comum.UsuarioComum;
import com.example.PicPagamento.domain.usuario.comum.UsuarioComumRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/comum")
public class UsuarioComumController {

    @Autowired
    private UsuarioComumRepository usuarioComumRepository;

    @GetMapping
    public List<UsuarioComum> getAllUsuarioComum(){
        var allComum = usuarioComumRepository.findAll();
        return allComum;
    }

    @GetMapping(path = "/nomes")
    public Iterable<UsuarioComum> getByName(@PathVariable String nome){
        return usuarioComumRepository.findByNome(nome);
    }

    @GetMapping(path = "/cpf")
    public Iterable<UsuarioComum> getByCpf(@PathVariable String cpfOrCnpj){
        return usuarioComumRepository.findByCpf(cpfOrCnpj);
    }

    @GetMapping(path = "/email")
    public Iterable<UsuarioComum> getByEmail(@PathVariable String email){
        return usuarioComumRepository.findByEmail(email);
    }

    @PostMapping
    public ResponseEntity registerUsuarioComum(@Valid UsuarioComum usuarioComum){
        usuarioComumRepository.save(usuarioComum);
        return ResponseEntity.ok("Usuário registrado com sucesso!");
    }

    @PutMapping
    public ResponseEntity updateUsuarioComum(@Valid UsuarioComum usuarioComum){
        Optional<UsuarioComum> optionalUsuarioComum = usuarioComumRepository.findById(String.valueOf(usuarioComum.getId()));
        if(optionalUsuarioComum.isPresent()){
            usuarioComumRepository.save(usuarioComum);
            return ResponseEntity.ok("Usuário atualizado com sucesso!");
        }
        else{
            return ResponseEntity.ok("Usuário não encontrado...");
        }
    }

    @DeleteMapping
    public ResponseEntity deleteUsuarioComum(@Valid UsuarioComum usuarioComum){
        usuarioComumRepository.deleteById(String.valueOf(usuarioComum.getId()));
        return ResponseEntity.ok("Usuário deletado com sucesso!");
    }

}
