package com.daily.technical.knowledge.grpcClient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.daily.technical.knowledge.grpcClient.config.ProductProperties;
import com.daily.technical.knowledge.grpcClient.grpc.ProductService;
import com.daily.technical.knowledge.grpcClient.grpc.ProductService.ProductDetailResponse;
import com.daily.technical.knowledge.grpcClient.grpc.ProductService.ProductsResponse;
import com.daily.technical.knowledge.grpcClient.grpc.ProductService.productDetailRequest;
import com.daily.technical.knowledge.grpcClient.grpc.ProductService.productsRequest;
import com.daily.technical.knowledge.grpcClient.grpc.productServiceGrpc;
import com.daily.technical.knowledge.grpcClient.model.Product;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * 
 * @author Amr Abdeldayem
 *
 */

@RestController("grpcClient")
@RequestMapping("/client/grpc")
public class GrpcClientController {


	@Autowired
	ProductProperties productProperties;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ManagedChannel managedChannel;
	
	@GetMapping("/product")
	public List<Product> getProducts() {

		List<Product> products=new ArrayList<>();
		
		long start = System.currentTimeMillis();

		List<ProductService.Product> grpcProducts =null;
		ProductsResponse productResponse =null;
		
		for (int i = 0; i < 10; i++) {
			productServiceGrpc.productServiceBlockingStub stub = productServiceGrpc.newBlockingStub(managedChannel);


			productResponse = stub.getProducts(productsRequest.newBuilder().build());
			grpcProducts =productResponse.getProductsList();
		
		}

		long end = System.currentTimeMillis();
		
		System.out.println("GRPC Time "+ (end-start));
		
		for(ProductService.Product grpcProduct:grpcProducts) {
			products.add(getProduct(grpcProduct));
		}
		
		return products;

	}

	@GetMapping("/product/{productId}")
	public Product getProductDetail(@PathVariable Integer productId) {


		productServiceGrpc.productServiceBlockingStub stub = productServiceGrpc.newBlockingStub(managedChannel);

		ProductDetailResponse productResponse = stub
				.getProductDetail(productDetailRequest.newBuilder().setId(productId).build());

		Product product = getProduct(productResponse.getProduct());

		return product;
	}

	private Product getProduct(ProductService.Product grpcProduct) {
		Product product = new Product();
		product.setId(grpcProduct.getId());
		product.setName(grpcProduct.getName());
		product.setCategory(grpcProduct.getCategory());
		product.setCost(grpcProduct.getCost());
		product.setCount(grpcProduct.getCount());
		product.setDescription(grpcProduct.getDescription());
		// product.setExpire(grpcProduct.getExpire());
		product.setPrice(grpcProduct.getPrice());

		return product;
	}
}
