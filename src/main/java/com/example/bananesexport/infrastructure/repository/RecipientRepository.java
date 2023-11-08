package com.example.bananesexport.infrastructure.repository;

import com.example.bananesexport.infrastructure.entities.RecipientEntity;
import com.example.bananesexport.infrastructure.entities.RecipientId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipientRepository extends JpaRepository<RecipientEntity, RecipientId> {
}
