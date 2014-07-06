package com.hileco.blegex.server.repository;

import com.hileco.blegex.server.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository  extends ElasticsearchRepository<User, String> {

	public User findByUsername(String username);

}