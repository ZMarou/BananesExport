package com.example.bananesexport.infrastructure.repository;

import com.example.bananesexport.infrastructure.entities.CommandEntity;
import com.example.bananesexport.infrastructure.entities.RecipientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommandRepository extends JpaRepository<CommandEntity, UUID> {
    List<CommandEntity> findByRecipient(RecipientEntity recipientEntity);
}
