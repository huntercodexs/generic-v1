package com.huntercodexs.genericprojectdemov1.repository;

import com.huntercodexs.genericprojectdemov1.model.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository extends JpaRepository<GenericEntity, Long> {
}
