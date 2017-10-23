package server.example.server.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
      .allowedOrigins("http://localhost:4200", "http://localhost:5200")
      .allowedMethods("POST", "GET",  "PUT", "OPTIONS", "DELETE")
      .allowedHeaders("X-Auth-Token", "Content-Type")
      .exposedHeaders("custom-header1", "custom-header2")
      .allowCredentials(false)
      .maxAge(4800);
  }
}
