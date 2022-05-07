package com.huntercodexs.genericv1.client;

import com.huntercodexs.genericv1.client.dto.GenericClientResponseDto;
import com.huntercodexs.genericv1.dto.response.GenericResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class GenericClient {

	@Value("${remote.basic-auth}")
	String remoteBasicAuth;
	@Value("${remote.base-url}")
	String baseUrl;
	@Value("${remote.base-uri-find-one}")
	String uriFindOne;
	@Value("${remote.base-uri-find-all}")
	String uriFindAll;
	@Value("${remote.base-uri-create-user}")
	String uriCreate;
	@Value("${remote.base-uri-delete-user}")
	String uriDelete;
	@Value("${remote.base-uri-update-user}")
	String uriUpdate;
	@Value("${remote.base-uri-patch-user}")
	String uriPatch;

	private final RestTemplate restTemplate = new RestTemplate();

	protected HttpHeaders httpRequestHeaders() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Authorization", remoteBasicAuth);
		return httpHeaders;
	}

	protected HttpComponentsClientHttpRequestFactory httpClientFactory() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}

	public ResponseEntity<GenericClientResponseDto> findOne(String userid) {

		String urlFindUser = this.baseUrl+this.uriFindOne.replaceFirst("@userid", userid);
		HttpEntity<GenericResponseDto> httpEntity = new HttpEntity<>(httpRequestHeaders());

		try {
			return restTemplate.exchange(urlFindUser, HttpMethod.GET, httpEntity, GenericClientResponseDto.class);
		} catch (RuntimeException re) {
			throw new RuntimeException("Error on findOne user");
		}

	}

	public ResponseEntity<GenericClientResponseDto> findAll() {

		String urlFindUser = this.baseUrl+this.uriFindAll;
		HttpEntity<GenericResponseDto> httpEntity = new HttpEntity<>(httpRequestHeaders());

		try {
			return restTemplate.exchange(urlFindUser, HttpMethod.GET, httpEntity, GenericClientResponseDto.class);
		} catch (RuntimeException re) {
			throw new RuntimeException("Error on findAll user");
		}

	}

	public ResponseEntity<GenericClientResponseDto> create(GenericResponseDto user) {

		String urlCreateUser = this.baseUrl+this.uriCreate;
		HttpEntity<GenericResponseDto> httpEntity = new HttpEntity<>(user, httpRequestHeaders());

		try {
			return restTemplate.postForEntity(urlCreateUser, httpEntity, GenericClientResponseDto.class);
		} catch (RuntimeException re) {
			throw new RuntimeException("Error on create user");
		}

	}

	public ResponseEntity<GenericClientResponseDto> delete(String userid) {

		String urlDeleteDevice = this.baseUrl + this.uriDelete.replaceFirst("@userid", userid);
		HttpEntity<GenericResponseDto> httpEntity = new HttpEntity<>(httpRequestHeaders());

		try {
			return restTemplate.exchange(urlDeleteDevice, HttpMethod.DELETE, httpEntity, GenericClientResponseDto.class);
		} catch (RuntimeException re) {
			throw new RuntimeException("Error on delete user");
		}

	}

	public ResponseEntity<GenericClientResponseDto> update(String userid, GenericResponseDto user) {

		String urlUpdateUser = this.baseUrl + this.uriUpdate.replaceFirst("@userid", userid);
		HttpEntity<GenericResponseDto> httpEntity = new HttpEntity<>(user, httpRequestHeaders());

		try {
			return restTemplate.exchange(urlUpdateUser, HttpMethod.PUT, httpEntity, GenericClientResponseDto.class);
		} catch (RuntimeException re) {
			throw new RuntimeException("Error on update user");
		}
	}

	public ResponseEntity<GenericClientResponseDto> patch(String userid, GenericResponseDto user) {

		String urlPatchUser = this.baseUrl + this.uriPatch.replaceFirst("@userid", userid);
		HttpEntity<GenericResponseDto> httpEntity = new HttpEntity<>(user, httpRequestHeaders());

		try {
			restTemplate.setRequestFactory(httpClientFactory());
			return restTemplate.exchange(urlPatchUser, HttpMethod.PATCH, httpEntity, GenericClientResponseDto.class);
		} catch (RuntimeException re) {
			throw new RuntimeException("Error on patch user");
		}
	}
	
}
