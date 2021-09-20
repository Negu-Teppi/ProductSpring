package com.manhle.repository;

import com.manhle.entities.ColorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ColorRepository extends CrudRepository<ColorEntity, Integer> {
}
