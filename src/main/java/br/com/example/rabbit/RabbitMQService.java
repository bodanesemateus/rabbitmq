package br.com.example.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Service
public class RabbitMQService {

    private final RabbitTemplate rabbitTemplate;

    private String filaNome = "fila-de-teste";

    @Autowired
    public RabbitMQService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarMensagem(String mensagem) {
        rabbitTemplate.convertAndSend(filaNome, mensagem);
    }

    public String receberMensagem() {
        return (String) rabbitTemplate.receiveAndConvert(filaNome);
    }
}
