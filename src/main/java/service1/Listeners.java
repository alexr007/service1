package service1;

import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class Listeners {

  @KafkaListener(id = "sampleGroup", topics = "in")
  public void listen(ConsumerRecord<String, String> cr) {
    String key = cr.key();
    String value = cr.value();
    log.info("key: {}", key);
    log.info("value: {}", value);
  }

}
