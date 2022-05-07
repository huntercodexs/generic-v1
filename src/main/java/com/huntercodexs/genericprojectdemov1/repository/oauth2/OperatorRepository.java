package com.huntercodexs.genericprojectdemov1.repository.oauth2;

import com.huntercodexs.genericprojectdemov1.model.oauth2.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperatorRepository extends JpaRepository<OperatorEntity, Long> {
    OperatorEntity findByUsername(String name);
}
