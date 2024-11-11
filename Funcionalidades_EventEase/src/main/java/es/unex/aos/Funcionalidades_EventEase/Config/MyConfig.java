package es.unex.aos.Funcionalidades_EventEase.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Clase que configura un wrapper sobre RestTemplate
@Configuration
public class MyConfig {
      
      // Este RestTemplate "LoadBalanced"
      // se conecta automáticamente al balanceador de carga:
      @LoadBalanced
      @Bean
      RestTemplate restTemplate() {
            return new RestTemplate();
      }
}
