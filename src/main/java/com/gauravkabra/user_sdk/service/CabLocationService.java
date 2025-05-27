package com.gauravkabra.user_sdk.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.gauravkabra.user_sdk.constants.AppConstants.CAB_LOCATION_TOPIC_NAME;

@Service
public class CabLocationService {

    /**
     * CLI equivalent of
     *
     * bin/kafka-console-consumer.sh --topic cab-location --from-beginning --bootstrap-server localhost:9092
     */

    /**
     * No group.id found in consumer config, container properties, or @KafkaListener annotation; a group.id is required when group management is used.
     *
     * group.id:
     * A unique string that identifies the consumer group this consumer belongs to. This property is required if the consumer uses either the group management functionality by using subscribe(topic) or the Kafka-based offset management strategy.
     */
    @KafkaListener(topics = {CAB_LOCATION_TOPIC_NAME}, groupId = "gaurav-grp")
    public void getCabLocation(String location) {
        System.out.println("Uber got the updated location: \n" + location);
    }
}
