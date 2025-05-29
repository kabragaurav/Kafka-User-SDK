# user-sdk

## Description

This project is a Spring Boot application that demonstrates integration with Apache Kafka. It acts as a Kafka consumer, subscribing to a topic named `cab-location` to receive and log cab location updates. This serves as a demo for a user-facing SDK or application that might consume location data in a real-world scenario (e.g., an Uber-like application showing cab movements).

## Project Structure

*   **Group ID:** `com.gauravkabra`
*   **Artifact ID:** `user-sdk`
*   **Version:** `0.0.1-SNAPSHOT`
*   **Java Version:** 21

## Core Functionality

The application performs the following:

1.  **Connects to Apache Kafka:** Using Spring Kafka.
2.  **Subscribes to a Topic:** Listens to the `cab-location` topic.
3.  **Consumes Messages:** The `CabLocationService` uses a `@KafkaListener` to receive messages from the topic.
4.  **Logs Location Data:** Upon receiving a message (assumed to be a string representing a location), it prints the location to the console, prefixed with "Uber got the updated location: \n".

The main components are:
*   `UserSdkApplication.java`: The main Spring Boot application class.
*   `AppConstants.java`: Defines constants, including the Kafka topic name (`cab-location`).
*   `CabLocationService.java`: Contains the Kafka listener logic and message processing.

## Dependencies

This project utilizes the following key dependencies (managed by Maven):

*   **Spring Boot Starter Web (`spring-boot-starter-web`):** Provides capabilities for building web applications, though this project primarily uses it for the Spring Boot application context and auto-configuration.
*   **Spring Kafka (`spring-kafka`):** Enables seamless integration with Apache Kafka for producing and consuming messages.
*   **Spring Boot Starter Test (`spring-boot-starter-test`):** Includes libraries like JUnit Jupiter, Hamcrest, and Mockito for testing Spring Boot applications.
*   **Spring Kafka Test (`spring-kafka-test`):** Provides utilities for testing Spring Kafka applications, such as an embedded Kafka broker.

## Build Process

The project is built using Apache Maven.

*   It inherits common configurations and dependency management from the `spring-boot-starter-parent` POM.
*   The `spring-boot-maven-plugin` is used to package the application as an executable JAR file, bundling all necessary dependencies.

## How to Build

To build the project, ensure you have Apache Maven and JDK 21 installed. Navigate to the root directory of the project and run:

```bash
mvn clean install
```

This command will:
1.  Clean the project (remove previous build artifacts).
2.  Compile the source code.
3.  Run any unit/integration tests.
4.  Package the application into an executable JAR file located in the `target/` directory (e.g., `target/user-sdk-0.0.1-SNAPSHOT.jar`).

## How to Run

Before running the application, ensure you have an Apache Kafka instance running and accessible. You will also need to create the `cab-location` topic if it doesn't already exist.

**1. Create the Kafka Topic (if not already present):**

You can use the Kafka CLI tools:
```bash
# Navigate to your Kafka installation directory
# Example for Kafka installed via Homebrew on macOS or similar for Linux
# KAFKA_HOME/bin/kafka-topics.sh --create --topic cab-location --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1

# To describe the topic and verify:
# KAFKA_HOME/bin/kafka-topics.sh --describe --topic cab-location --bootstrap-server localhost:9092
```
*(Adjust `localhost:9092` if your Kafka broker is running elsewhere. For production, use appropriate partition and replication factor values.)*

**2. Run the Application:**

Once built, the application can be run using:

```bash
java -jar target/user-sdk-0.0.1-SNAPSHOT.jar
```

The application will start, connect to Kafka, and begin listening for messages on the `cab-location` topic.

**3. Producing Messages (Example):**

To see the application in action, you can use the Kafka console producer to send messages to the `cab-location` topic:

```bash
# KAFKA_HOME/bin/kafka-console-producer.sh --topic cab-location --bootstrap-server localhost:9092
```

Then, type any string messages in the console producer (e.g., "Latitude: 12.34, Longitude: 56.78") and press Enter. You should see the `user-sdk` application printing these messages to its console.

## Configuration

The Kafka listener configuration (topic name and group ID) is currently hardcoded in:
*   `AppConstants.java` for the topic name (`cab-location`).
*   `CabLocationService.java` for the consumer group ID (`gaurav-grp`).

For a production application, these would typically be externalized into `application.properties` or `application.yml`.
