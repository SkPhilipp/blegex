package com.hileco.blegex.core.repository.es;

import com.hileco.blegex.core.model.UserDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDocumentRepository extends ElasticsearchRepository<UserDocument, String> {

    public List<UserDocument> findByContent(String content);

}