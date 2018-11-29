import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class KafkaProducer {
    public static void main(String[] args){
        Properties properties = new Properties();

        //Kafka bootstrap server
        properties.setProperty("bootstrap.servers","192.168.99.100:3030");
        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer",StringSerializer.class.getName());
        //producer acks
        properties.setProperty("acks","1");
        properties.setProperty("retries","3");

        Producer<String, String> producer = new org.apache.kafka.clients.producer.KafkaProducer<String, String>(properties);

        ProducerRecord<String, String> record = new ProducerRecord<String, String>("my topic","3","test message");

        producer.send(record);
        producer.close();


        //topic


    }

}

