package com.example.PicPagamento.services;

import com.example.PicPagamento.domain.transaction.Transaction;
import com.example.PicPagamento.domain.usuario.Usuario;
import com.example.PicPagamento.dtos.TransactionDTO;
import com.example.PicPagamento.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class TransactionService {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private RestTemplate restTemplate;

    public void crateTransaction(TransactionDTO transaction) throws Exception {

        Usuario sender   = this.usuarioService.findUsuarioById(transaction.senderId);
        Usuario receiver = this.usuarioService.findUsuarioById(transaction.receiverId);

        usuarioService.validateTransaction(sender, transaction.value);

        boolean isAuthorized = this.authorizeTransaction(sender, transaction.value);

        if(!isAuthorized){
            throw new Exception("Transação não autorizada");
        }

        // criando a transação de fato
        Transaction newTransaction = new Transaction();
        newTransaction.setAmount(transaction.value);
        newTransaction.setSender(sender);
        newTransaction.setReceiver(receiver);
        newTransaction.setTimestamp(LocalDateTime.now());

        // atualizando saldos do sender e do receiver
        sender.setSaldo(sender.getSaldo().subtract(transaction.value));
        receiver.setSaldo(receiver.getSaldo().add(transaction.value));

        // persistindo os dados no banco de dados
        this.transactionRepository.save(newTransaction);
        usuarioService.saveUsuario(sender);
        usuarioService.saveUsuario(receiver);

    }

    // chama o endpoint externo e valida se está autorizado a realizar a transação
    public boolean authorizeTransaction(Usuario sender, BigDecimal value){
        ResponseEntity<Map> authorizationResponse = restTemplate.getForEntity("https://run.mocky.io/v3/5794d450-d2e2-4412-8131-73d0293ac1cc", Map.class);
        if(authorizationResponse.getStatusCode() == HttpStatus.OK &&
                authorizationResponse.getBody().get("message") == "Autorizado") return true;
        else return false;
    }


}
