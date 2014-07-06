package com.hileco.blegex.server.repository;

import com.hileco.blegex.server.model.ContentElement;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContentElementRepository extends ElasticsearchRepository<ContentElement, String> {

}