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
		return builder.routes()
				.route("wasteManagerRoute", routeSpec -> routeSpec
						.path("/api/waste-manager/**")
						.uri("lb://waste-manager"))
				.route("wasteCenterAuthorizationRoute", routeSpec -> routeSpec
						.path("/api/waste-center-authorization/**")
						.uri("lb://waste-manager"))
				.route("wasteManagerAddressRoute", routeSpec -> routeSpec
						.path("/api/waste-manager-address/**")
						.uri("lb://waste-manager-address"))
				.build();
	}
}
