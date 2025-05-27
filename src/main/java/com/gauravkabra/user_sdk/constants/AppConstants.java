package com.gauravkabra.user_sdk.constants;

public interface AppConstants {
    /**
     * Once app starts, we can describe topic using CLI
     *
     * bin/kafka-topics.sh --describe --topic cab-location --bootstrap-server localhost:9092
     */
    String CAB_LOCATION_TOPIC_NAME = "cab-location";
}
