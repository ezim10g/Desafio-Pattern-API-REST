package projeto.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//http://127.0.0.1:8080/clientes/home

/* data JPA
 * WEB
 * H2
 * OpenFeign
 * OpenAPI (manualmente)
 */

/*
 * Inserir no arquivo pom.xml
 * 
 * <!-- OpenAPI / Swagger Adicionando de forma manual -->
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.7.0</version>
		</dependency>

 * */


@EnableFeignClients  //Habilita o client Feign
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}


















