package hotelreservation.customers.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Value("${server.port}")
    int port;

    @Bean
    public OpenAPI productServiceAPI(ServletContext servletContext) {
        var server = new Server().url("http://localhost:" + port);
        return new OpenAPI()
                .servers(List.of(server))
                .info(new Info().title("Customer Service API")
                        .description("This is the REST API for Customer Service")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0")));
    }
}
