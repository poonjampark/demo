//package com.pzp.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.pzp.model.Product;
//import com.pzp.service.elasticsearch.ProductImpl;
//import com.pzp.service.elasticsearch.ProductIndex;
//
//import util.panzhanpeng.response.Response;
//
//@RestController
//@RequestMapping("/product/es")
//public class ProductContorller {
//
//	@Autowired
//	private ProductImpl productImpl;
//	
//	@Autowired
//	private ProductIndex productIndex;
//	
//	/**
//	 * 创建商品索引
//	 * @return
//	 */
//	@PostMapping("/index")
//	public Response createIndex() {
//		return productIndex.createIndex();
//	}
//	
//	/**
//	 * 删除商品索引
//	 * @return
//	 */
//	@DeleteMapping("/index")
//	public Response deleteIndex() {
//		return productIndex.deleteIndex();
//	}
//	
//	/**
//	 * 新增单个商品
//	 * @return
//	 */
//	@PostMapping("/product")
//	public Response addProduct(@RequestBody Product product) {
//		return productImpl.addProduct(product);
//	}
//	
//	/**
//	 * 批量新增商品
//	 * @return
//	 */
//	@PostMapping("/products")
//	public Response addProducts(@RequestBody List<Product> products) {
//		return productImpl.addProducts(products);
//	}
//	
//	/**
//	 * 获取全部商品
//	 * @return
//	 */
//	@GetMapping("/product")
//	public Response getProductAll() {
//		return productImpl.searchAll();
//	}
//	
//	/**
//	 * 根据条件查询商品
//	 * @param product
//	 * @return
//	 */
//	@GetMapping("/products")
//	public Response getProductOnCondition(@RequestBody Product product) {
//		return productImpl.searchProducts(product);
//	}
//	
//	/**
//	 * 使用Criteria根据条件查询商品
//	 * @param product
//	 * @return
//	 */
//	@GetMapping("/criteria/products")
//	public Response getProductByCriteria(@RequestBody Product product) {
//		return productImpl.searchProductsByCriteria(product);
//	}
//	
//}
