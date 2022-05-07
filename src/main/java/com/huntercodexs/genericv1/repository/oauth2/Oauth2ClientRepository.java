package com.huntercodexs.genericv1.repository.oauth2;

import com.huntercodexs.genericv1.model.oauth2.Oauth2ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Oauth2ClientRepository extends JpaRepository<Oauth2ClientEntity, Long> {
	Oauth2ClientEntity findByClient(String client);
}
