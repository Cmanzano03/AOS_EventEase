
# Tema02k. Microservicios

# Introduction

En esta sesión trabajaremos con los conceptos de microservicios. Concretamente, desplegaremos unos ejemplos desarrollados con la tecnología SpringBoot.

Se incluyen patrones habituales para el desarrollo de microservicios:

- FallBack and Circuit Braker
- Registro de servicios (Eureka)
- Balanceador de carga (Ribbon)

## Hystrix example with SpringBoot.


- **Ejemplo que utiliza Hystrix (Fallback and Circuit Braker), Eureka (Registro de servicios) y Ribbon (balanceador de carga)**:
\url{https://www.javainuse.com/spring/spring_hystrix}

- Descargar el código de los ejemplos

  - **Eureka Service** [Eureka-server](./jdk11_eureka-server-hystrix.zip). Descomprimir y ejecutar `mvn clean package spring-boot:run`  (se ejecuta en el puerto 8090)

  También puedes configurarlo a mano siguiendo los siguientes pasos:

      a. Crear el proyecto SpringBoot identificando las siguientes propiedades:
        
        - gestor config: maven
        - java: 11
        - artifactId: server_eureka

      b. Descargar y descomprimir
      c. Añadir al archivo `EurekaServerApplication.java` la etiqueta `@EnableEurekaServer`
        
```java
package es.unex.aos.eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
	}

}
```


c. Añadir al archivo `/src/main/resources/application.properties` 

``` 
server.port=8090
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
```

d. Compilar, empaquetar y ejecutar el proyecto `mvn clean package spring-boot:run` y acceder a `http://localhost:8090`


  - **Employee producer hystrix**  [Ejemplo employee-producer] (./jdk11_employee_producer-hystrix.zip) Descomprimir y ejecutar `mvn clean package spring-boot:run`


  - **Employee consumer service**  [Ejemplo employee-consumer](./jdk11_employee-consumer-hystrix.zip)  Descomprimir y ejecutar `mvn clean package spring-boot:run`
  
- **Eureka** está disponible en \url{http://localhost:8090} (registro de los servicios desplegados)

- Completar el código siguiendo para ver cómo funciona el Circuit Braker con Hystrix \url{https://www.javainuse.com/spring/spring_hystrix_circuitbreaker}


**Nota**. Ejecutar varias instancias de un servicio: `java -jar target/employee-producer-0.0.1-SNAPSHOT.jar --server.port=8082`  donde se debe cambiar el archivo jar por el servicio deseado y cambiar el puerto para ejecutar varias instancias:

```
java -jar target/employee-producer-0.0.1-SNAPSHOT.jar --server.port=8081
java -jar target/employee-producer-0.0.1-SNAPSHOT.jar --server.port=8082
java -jar target/employee-producer-0.0.1-SNAPSHOT.jar --server.port=8083
```
también sería posible añadir nuevos parámetros al comando `mvn spring-boot:run`:

```
mvn spring-boot:run -Dspring-boot.run.arguments=--port=8091
mvn spring-boot:run -Dspring-boot.run.arguments=--port=8092
mvn spring-boot:run -Dspring-boot.run.arguments=--port=8092
``` 

## Project Starters

Cada tecnología Java para el desarrollo de microservicios suele tener su propio *project starter* o página a partir de la cual configurar un proyecto basado en dicha tecnologías / servidor de aplicaciones:

- Jakarta project starter: \url{https://eclipse-ee4j.github.io/starter/} (générico JEE)

- Microprofile.io project starter: \url{https://start.microprofile.io/} (genérico para Microservicios)

- Throntail project starter: \url{https://thorntail.io/generator/}

- Spring boot project starter: \url{https://start.spring.io/}


## References

- Microservices Paterns. \url{http://microservices.io/patterns/microservices.html}
- **Interesante**. Real world microservices - lessons form the frontline (2014) \url{https://www.youtube.com/watch?v=hsoovFbpAoE}
- Github monolith to microservices. \url{https://www.infoq.com/articles/github-monolith-microservices/}
- Multiple microservices examples: \url {https://github.com/cer/microservices-examples}
- Microservice Registration and Discovery with Spring Cloud and Netflix's Eureka \url{https://spring.io/blog/2015/01/20/microservice-registration-and-discovery-with-spring-cloud-and-netflix-s-eureka}
- SpringCloud and Eureka. \url{https://github.com/spring-cloud-samples/eureka}

## Spring Cloud Netflix example

https://www.baeldung.com/spring-cloud-netflix-eureka