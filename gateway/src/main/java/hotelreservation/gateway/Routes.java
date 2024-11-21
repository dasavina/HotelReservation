package hotelreservation.gateway;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
import static org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http;
@Configuration(proxyBeanMethods = false)
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> customerServiceRoute() {
        return route("customer_service")
                .route(RequestPredicates.path("/api/customer"), http(System.getenv("CUSTOMER_URL")))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> reservationServiceRoute() {
        return route("reservation_service")
                .route(RequestPredicates.path("/api/reservation"), http(System.getenv("RESERVATION_URL")))
                .build();
    }
    @Bean
    public RouterFunction<ServerResponse> roomServiceRoute() {
        return route("room_service")
                .route(RequestPredicates.path("/api/room"), http(System.getenv("ROOM_URL")))
                .build();
    }
}