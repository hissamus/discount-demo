package com.hissamus.store.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hissamus.store.demo.model.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Long> {
	List<Items> findByType(@Param("type") String type);

}
