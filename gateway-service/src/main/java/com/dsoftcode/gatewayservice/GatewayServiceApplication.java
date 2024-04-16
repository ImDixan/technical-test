package com.dsoftcode.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	@Bean
	RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
		// Construye las rutas con el fin centralizar y redirigir las peticiones y respuestas de los servicios a disponer
		return builder.routes()
				.route("wasteManagerRoute", routeSpec -> routeSpec
						.path("/api/waste-manager/**")
						.uri("lb://waste-manager-service"))
				.route("wasteCenterAuthorizationRoute", routeSpec -> routeSpec
						.path("/api/waste-center-authorization/**")
						.uri("lb://waste-manager-service"))
				.route("wasteManagerAddressRoute", routeSpec -> routeSpec
						.path("/api/waste-manager-address/**")
						.uri("lb://waste-manager-address-service"))
				.build();
	}
}
