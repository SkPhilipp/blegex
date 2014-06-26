package com.hileco.blegex.server.repository;

import com.hileco.blegex.server.model.Draft;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DraftRepository extends JpaRepository<Draft, UUID> {
}