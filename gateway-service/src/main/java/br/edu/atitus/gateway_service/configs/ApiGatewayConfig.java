package br.edu.atitus.gateway_service.configs;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {
	
	@Bean
	RouteLocator getGatewayRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes() 
				.route(p -> p
						.path("/get")
						.filters(f -> f
								.addRequestHeader("X-USER-NAME", "username")
								.addRequestParameter("name", "fulano"))
						.uri("http://httpbin.org:80"))
				.build();
	}
}
