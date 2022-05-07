package com.huntercodexs.genericprojectdemov1.client;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.UUID;

@Slf4j
@Service
public class JwtSigner {

	PrivateKey signingKey;

	@Value("${app-jwt.security.jwt.keystore-location}")
	String keyFile;

	@Value("${app-jwt.security.jwt.key-alias}")
	String keystoreAlias;

	@Value("${app-jwt.security.jwt.keystore-password}")
	String keystorePassword;
	
	@PostConstruct
	private void loadPrivateKey() {
		log.info("loading idc key...");
		try {
			signingKey = getPrivateKeyFromP12(keyFile, keystoreAlias, keystorePassword);
			log.info("loading idc key ok");
		} catch (UnrecoverableKeyException | KeyStoreException | CertificateException | NoSuchAlgorithmException | IOException e) {
			log.error("Error idc loading key: ",e);
		}
	}
	
    private PrivateKey getPrivateKeyFromP12(
			String pkcs12KeyFilePath,
			String signingKeyAlias,
			String signingKeyPassword
	) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException, UnrecoverableKeyException {
  		KeyStore pkcs12KeyStore = KeyStore.getInstance("PKCS12");
   		pkcs12KeyStore.load(Files.newInputStream(Paths.get(pkcs12KeyFilePath)), signingKeyPassword.toCharArray());
   		return (PrivateKey) pkcs12KeyStore.getKey(signingKeyAlias, signingKeyPassword.toCharArray());
    }
	
	public String createSignedJWT(String appId, String type) {

		log.info("creating header");
		long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        long expMillis = nowMillis + 300000; // 5 minutes
        Date exp = new Date(expMillis);
        JWSSigner signer = null;
        signer = new RSASSASigner(signingKey);

        JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(appId)
                .issueTime(now)
                .expirationTime(exp)
                .jwtID(UUID.randomUUID().toString())
                .notBeforeTime(now)
                .claim("type", type)
                .build();

        SignedJWT signedJWT = new SignedJWT(new JWSHeader.Builder(JWSAlgorithm.RS256)
                .type(JOSEObjectType.JWT)
                .contentType("JWS")
                .build(), claims);
        
        try {
			signedJWT.sign(signer);
		} catch (JOSEException e) {
			log.error("error signing jwt",e);
		}
        
        return signedJWT.serialize();
        
	}
	
}
