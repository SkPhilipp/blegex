package com.hileco.blegex.server.repository;

import com.hileco.blegex.server.model.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlockRepository extends JpaRepository<Block, UUID> {
}