package com.example.PicPagamento.services;

import com.example.PicPagamento.domain.usuario.Usuario;
import com.example.PicPagamento.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(Usuario usuario, String message) throws Exception {

        String email = usuario.getEmail();

        NotificationDTO notificationDTO = new NotificationDTO(email, message); // vai ir no body da requisição post

        ResponseEntity<String> notificationResponse = restTemplate.
                postForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", notificationDTO, String.class);

        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
            throw new Exception("serviço de notificação fora do ar");
        }
    }


}
