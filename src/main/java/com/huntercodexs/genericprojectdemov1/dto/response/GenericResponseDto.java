package com.huntercodexs.genericprojectdemov1.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(
		description = "Any description",
		name = "AnyName")
public class GenericResponseDto {

	@Schema(
			description = "Any description.",
			example = "Any Example", required = true)
	String any1;

	@Schema(
			description = "Any description.",
			example = "Any Example", required = true)
	String any2;

	@Schema(description = "Any description.", required = false)
	@JsonInclude(JsonInclude.Include.NON_NULL)
    GenericErrorResponseDto errorDetails;

}
