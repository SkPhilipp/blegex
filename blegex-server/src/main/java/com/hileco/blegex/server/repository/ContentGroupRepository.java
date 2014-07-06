package com.hileco.blegex.server.repository;

import com.hileco.blegex.server.model.ContentGroup;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContentGroupRepository extends ElasticsearchRepository<ContentGroup, String> {

}