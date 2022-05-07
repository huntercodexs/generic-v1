package com.huntercodexs.genericv1.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(
		description = "This object contains the tcn created to a claimshare transaction",
		name = "GenericResponseDto",
		required = true)
public class GenericClientResponseDto {

	@Schema(
			description = "TCN created to identifies a claimshare transaction",
			example = "880a55a7-09eb-4a0d-b36d-dd961be6ab87",
			required = true)
	String tcn;
	
}
