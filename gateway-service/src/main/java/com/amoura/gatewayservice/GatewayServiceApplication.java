package com.amoura.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	/**
	 * Crée un bean pour la découverte dynamique de routes dans Spring Cloud Gateway.
	 *
	 * @param rdc Client ReactiveDiscoveryClient permettant d'interagir avec le registre de services.
	 * @param ldp Propriétés DiscoveryLocatorProperties pour la configuration de la découverte de routes.
	 * @return Un DiscoveryClientRouteDefinitionLocator pour la gestion dynamique des routes.
	 */
	@Bean
	public DiscoveryClientRouteDefinitionLocator locator(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties ldp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, ldp);
	}


}
