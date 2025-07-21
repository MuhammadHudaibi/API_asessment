package com.enigmacamp.assesment.repository;

import com.enigmacamp.assesment.entity.Tax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaxRepository extends JpaRepository<Tax, String> {
    Optional<Tax> findByName(String name);
}
