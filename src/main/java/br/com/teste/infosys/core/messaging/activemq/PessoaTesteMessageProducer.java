package br.com.teste.infosys.core.messaging.activemq;

import br.com.teste.infosys.core.messaging.TesteMessageProducer;
import jakarta.jms.*;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PessoaTesteMessageProducer implements TesteMessageProducer {

    private Session session;

    public void enviar(String mensagem) {
        try {
            // Create a ConnectionFactory
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");

            // Create a Connection
            Connection connection = connectionFactory.createConnection();
            connection.start();

            // Create a Session
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Create the destination (Topic or Queue)
            Destination destination = session.createQueue("FILA.TESTE");

            // Create a MessageProducer from the Session to the Topic or Queue
            MessageProducer producer = session.createProducer(destination);
            producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

            // Create a messages
            TextMessage message = session.createTextMessage(mensagem);

            // Tell the producer to send the message
            System.out.println("Sent message: " + message.hashCode() + " : " + Thread.currentThread().getName());
            producer.send(message);

            // Clean up
            session.close();
            connection.close();
        } catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
        }
    }
}
