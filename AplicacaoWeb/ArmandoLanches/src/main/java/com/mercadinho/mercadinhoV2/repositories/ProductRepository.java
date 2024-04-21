package com.mercadinho.mercadinhoV2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;
import com.mercadinho.mercadinhoV2.models.ProductModel;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, ID> {

	Optional<ProductModel> findById(Long id);

}
