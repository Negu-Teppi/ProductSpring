package com.manhle.repository;

import com.manhle.entities.ColorEntity;
import com.manhle.entities.SizeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeRepository extends CrudRepository<SizeEntity, Integer> {
}
