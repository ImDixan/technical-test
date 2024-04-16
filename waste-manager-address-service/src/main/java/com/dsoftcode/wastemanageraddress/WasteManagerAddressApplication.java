package com.dsoftcode.wastemanageraddress;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WasteManagerAddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(WasteManagerAddressApplication.class, args);
	}

}
