# Supplier-Processor-Consumer

## Request Reply pattern (rpc)

Request reply pattern using Rabbit template amqp.

How to run:

java -jar target/reqreplyamqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=rpc,server --tutorial.client.duration=60000

java -jar target/reqreplyamqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=rpc,client --server.port=9090

java -jar target/reqreplyamqp-0.0.1-SNAPSHOT.jar --spring.profiles.active=rpc,client --server.port=9091
