package com.huntercodexs.genericprojectdemov1.service;

import com.huntercodexs.genericprojectdemov1.client.GenericClient;
import com.huntercodexs.genericprojectdemov1.dto.request.GenericRequestDto;
import com.huntercodexs.genericprojectdemov1.dto.response.GenericResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;

import static com.huntercodexs.genericprojectdemov1.mapper.response.GenericResponseMapper.mapperGenericResponse;

@Service
public class GenericService {

	private static final Logger LOG = LoggerFactory.getLogger(GenericService.class);

	@Autowired
	GenericClient genericClient;

	@Autowired
	GenericPersistService genericPersistService;

	private ResponseEntity<GenericResponseDto> checkRequest(
			@Valid GenericRequestDto genericRequestDto
	) {

		LOG.info("checkRequest is calling in GenericService");

		return null;
	}

	@Transactional
	public ResponseEntity<GenericResponseDto> genericService(
			@Valid GenericRequestDto genericRequestDto
	) {

		LOG.info("GenericService is running");

		/*RequestBody check*/
		ResponseEntity<GenericResponseDto> requestBodyCheck = checkRequest(genericRequestDto);
		if (requestBodyCheck != null) {
			return requestBodyCheck;

		}

		GenericResponseDto genericResponseDto = mapperGenericResponse(genericRequestDto);

		genericPersistService.save();

		return ResponseEntity.status(HttpStatus.ACCEPTED).body(genericResponseDto);

	}
	
}
