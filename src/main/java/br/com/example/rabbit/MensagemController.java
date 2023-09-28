package br.com.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MensagemController {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MensagemController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping("/enviar-mensagem")
    public String enviarMensagem(@RequestBody String mensagem) {
        rabbitTemplate.convertAndSend("fila-de-teste", mensagem);
        return "Mensagem enviada com sucesso!";
    }
}
