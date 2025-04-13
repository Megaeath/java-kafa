1. mvn wrapper:wrapper
2. ./mvnv package
3. java -jar target/helloworld-0.0.1-SNAPSHOT.jar 

docker build -t springio/gs-spring-boot-docker .

docker run -p 8080:8080 springio/gs-spring-boot-docker