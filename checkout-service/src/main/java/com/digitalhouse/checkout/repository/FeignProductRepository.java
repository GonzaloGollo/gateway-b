package com.digitalhouse.checkout.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalhouse.checkout.model.dto.Product;

//@FeignClient(name = "products-service") //nombre del serv al que queremos comunicarnos
@FeignClient(name = "products", url = "http://localhost:8080") //nombre del serv al que queremos comunicarnos
//Configuración para LoadBalancer Random
//@LoadBalancerClient(value = "products-service", configuration = LoadBalancerConfiguration.class)
public interface FeignProductRepository {
	@RequestMapping(method = RequestMethod.GET, value="/products")
	Product getProductById(@RequestParam String id);
}
