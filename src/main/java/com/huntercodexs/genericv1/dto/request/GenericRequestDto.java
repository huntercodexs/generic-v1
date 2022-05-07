package com.huntercodexs.genericv1.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(
		description = "Any description",
		name = "AnyName")
public class GenericRequestDto {

	@Schema(
			description = "Any Description.",
			example = "Any example", required = true)
	@NotBlank @NotEmpty @NotNull
	String any1;

	@Schema(
			description = "Any Description.",
			example = "Any example", required = true)
	String any2;
	
}
