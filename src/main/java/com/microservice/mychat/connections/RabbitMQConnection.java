package com.microservice.mychat.connections;

import com.microservice.mychat.constantes.RabbitMQConstantes;
import jakarta.annotation.PostConstruct;
import org.springframework.amqp.core.*;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConnection {
    private static final String NOME_EXCHANGE = "amq.direct";
    private AmqpAdmin amqpAdmin;

    public RabbitMQConnection(AmqpAdmin amqpAdmin){
        this.amqpAdmin = amqpAdmin;
    }

    private Queue fila(String nomeFila){
        return new Queue(nomeFila,true,false,false);
    }

    private DirectExchange trocaDireta(){
        return new DirectExchange(NOME_EXCHANGE);
    }

    private Binding relacionamento(Queue fila, Exchange troca){
        return new Binding(fila.getName(),Binding.DestinationType.QUEUE, troca.getName(),fila.getName(),null);
    }


    @PostConstruct
    private void adiciona(){

        Queue fila1 = this.fila(RabbitMQConstantes.FILA_GRUPO1);
        DirectExchange troca = this.trocaDireta();

        Binding relacao = this.relacionamento(fila1,troca);

        this.amqpAdmin.declareQueue(fila1);
        this.amqpAdmin.declareExchange(troca);
        this.amqpAdmin.declareBinding(relacao);
    }
}
