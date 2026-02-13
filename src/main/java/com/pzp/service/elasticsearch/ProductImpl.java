//package com.pzp.service.elasticsearch;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.client.elc.NativeQuery;
////import org.springframework.data.elasticsearch.client.elc.QueryBuilders;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.SearchHit;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.query.Criteria;
//import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
//import org.springframework.data.elasticsearch.core.query.IndexQuery;
//import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
//import org.springframework.data.elasticsearch.core.query.Query;
//import org.springframework.stereotype.Service;
//
//import com.pzp.model.Product;
//
//import util.panzhanpeng.response.MutilResponse;
//import util.panzhanpeng.response.Response;
//
//@Service
//public class ProductImpl {
//	
//	private static final Logger LOGGER = LoggerFactory.getLogger(ProductImpl.class);
//
//	@Autowired
//	private ElasticsearchTemplate elasticsearchTemplate;
//	
//	@Autowired
//	private ElasticsearchOperations elasticsearchOperations;
//	
//	/**
//	 * 新增一个商品
//	 * @param product
//	 * @return
//	 */
//	public Response addProduct(Product product) {
//		try {
//			elasticsearchOperations.save(product);
//			return Response.buildSuccess();
//		} catch (Exception e) {
//			LOGGER.info("elasticsearch新增商品报错{}", product);
//			return Response.buildFail("2000002", "新增商品报错");
//		}
//	}
//	
//	/**
//	 * 批量新增商品
//	 * @param product
//	 * @return
//	 */
//	public Response addProducts(List<Product> products) {
//		try {
//	        List<IndexQuery> queries = new ArrayList<IndexQuery>();
//	        for (Product product : products) {
//	        	IndexQuery query = new IndexQueryBuilder()
//	        			.withObject(product)
//	        			.build();
//				queries.add(query);
//			}
//	        elasticsearchTemplate.bulkIndex(queries, Product.class);
//			return Response.buildSuccess();
//		} catch (Exception e) {
//			LOGGER.info("elasticsearch批量新增商品报错{}", products);
//			return Response.buildFail("2000003", "批量新增商品报错");
//		}
//	}
//	
//	/**
//	 * 查询全部
//	 * @return
//	 */
//	public MutilResponse<Product> searchAll() {
//		System.out.println("使用elasticsearch查询所有");
//		MutilResponse<Product> response = new MutilResponse<Product>();
//		Query query = elasticsearchTemplate.matchAllQuery();
//		SearchHits<Product> hits = elasticsearchTemplate.search(query, Product.class);
//		if (hits.getTotalHits() <= 0) {
//			response = MutilResponse.buildSuccess(null, null, new ArrayList<Product>());
//		} else {
//			List<Product> results = hits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
//			response = MutilResponse.buildSuccess(null, null, results);
//		}
//		return response;
//	}
//	
//	/**
//	 * 使用Criteria 根据条件查询商品
//	 * @return
//	 */
//	public MutilResponse<Product> searchProductsByCriteria(Product product) {
//		MutilResponse<Product> response = new MutilResponse<Product>();
//		Criteria criteria = new Criteria("name").is(product.getName()).and("type").is(product.getType());
//		CriteriaQuery query = new CriteriaQuery(criteria);
//		SearchHits<Product> hits = elasticsearchOperations.search(query, Product.class);
//		if (hits.getTotalHits() <= 0) {
//			response = MutilResponse.buildSuccess(null, null, new ArrayList<Product>());
//		} else {
//			List<Product> results = hits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
//			response = MutilResponse.buildSuccess(null, null, results);
//		}
//		return response;
//	}
//	
//	/**
//	 * 根据条件查询商品
//	 * @return
//	 */
//	public MutilResponse<Product> searchProducts(Product product) {
//		MutilResponse<Product> response = new MutilResponse<Product>();
//		//构建布尔完整查询
//		//分页
//		Pageable pageable = PageRequest.of(1, 8);
//		NativeQuery nativeQuery = NativeQuery.builder()
//				.withQuery(QueryBuilders.termQueryAsQuery("name", product.getName()))
//				.withQuery(QueryBuilders.wildcardQueryAsQuery("type", product.getType()))
//				.withPageable(pageable)
//				.build();
//		SearchHits<Product> hits = elasticsearchTemplate.search(nativeQuery, Product.class);
//		if (hits.getTotalHits() <= 0) {
//			response = MutilResponse.buildSuccess(null, null, new ArrayList<Product>());
//		} else {
//			List<Product> results = hits.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());
//			response = MutilResponse.buildSuccess(null, null, results);
//		}
//		return response;
//	}
//	
//}