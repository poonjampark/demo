package com.pzp.service.elasticsearch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.stereotype.Service;

import com.pzp.model.Product;

import util.panzhanpeng.response.Response;

@Service
public class ProductIndex {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	/**
	 * 创建索引
	 * @param indexName
	 * @return
	 */
	public Response createIndex() {
		IndexOperations indexOptions = elasticsearchTemplate.indexOps(Product.class);
		if (indexOptions.create()) {
			return Response.buildSuccess();
		} else {
			return Response.buildFail("200001", "创建索引错误");
		}
	}
	
	/**
	 * 删除索引
	 * @return
	 */
	public Response deleteIndex() {
		IndexOperations indexOptions = elasticsearchTemplate.indexOps(Product.class);
		if (indexOptions.delete()) {
			return Response.buildSuccess();
		} else {
			return Response.buildFail("200002", "删除索引错误");
		}
	}
	
}
