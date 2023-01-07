package com.daily.technical.knowledge.grpcClient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.daily.technical.knowledge.grpcClient.config.ProductProperties;
import com.daily.technical.knowledge.grpcClient.model.Product;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

@RestController("client")
@RequestMapping("/client")
public class ClientController {

	/**
	 * @Value( "${product.server.port}" ) private String productPort;
	 **/

	@Autowired
	ProductProperties productProperties;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/product")
	public List<Product> getProducts() {

		List<Product> products = null;

		long start = System.currentTimeMillis();

		String productResourceUrl = productProperties.url + ":" + productProperties.port + "/server/product";
		ResponseEntity<List> response =null;
		for (int i = 0; i < 10; i++) {
			response = restTemplate.getForEntity(productResourceUrl, List.class);
			products = response.getBody();
		}
		

		long end = System.currentTimeMillis();

		System.out.println("Resttemplate Time " + (end - start));

		return products;
	}

	@GetMapping("/product/{productId}")
	public Product getProductDetail(@PathVariable Integer productId) {
		String productResourceUrl = productProperties.url + ":" + productProperties.port + "/server/product" + "/"
				+ productId;

		ResponseEntity<Product> response = restTemplate.getForEntity(productResourceUrl, Product.class);

		return response.getBody();
	}

}
