package com.huntercodexs.genericprojectdemov1.restcontroller;

import com.huntercodexs.genericprojectdemov1.dto.request.GenericRequestDto;
import com.huntercodexs.genericprojectdemov1.dto.response.GenericErrorResponseDto;
import com.huntercodexs.genericprojectdemov1.dto.response.GenericResponseDto;
import com.huntercodexs.genericprojectdemov1.service.GenericService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@Transactional
@CrossOrigin(origins = "*")
@RequestMapping("${api.prefix}")
@Tag(name = "Generic Documentation")
public class GenericController {

	private static final Logger LOG = LoggerFactory.getLogger(GenericController.class);

	@Autowired
	GenericService genericService;

	@Operation(hidden = true)
	@GetMapping(value={"/alive"})
	public String hidden() {
		return "API is alive";
	}

	@Operation(
			hidden = false,
			summary = "Skeleton V1",
			description = "Any Description"
	)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = GenericRequestDto.class))
			}),
			@ApiResponse(responseCode = "202", description = "Accepted Successfully", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = GenericRequestDto.class))
			}),
			@ApiResponse(responseCode = "400", description = "Bad Request", content = {
					@Content(mediaType = "")
			}),
			@ApiResponse(responseCode = "401", description = "Unauthorized", content = {
					@Content(mediaType = "text")
			}),
			@ApiResponse(responseCode = "404", description = "Resource Transaction Not Found", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = GenericErrorResponseDto.class))
			}),
			@ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = GenericErrorResponseDto.class))
			})
	})
	@PostMapping(value={"/skeleton-v1"})
	@ResponseBody
	public ResponseEntity<GenericResponseDto> generic(
			@Valid @RequestBody GenericRequestDto genericRequestDto
	) {
		LOG.info("Generic API is calling...");
		return genericService.genericService(genericRequestDto);
	}

}
