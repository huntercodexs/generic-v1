package com.huntercodexs.genericv1.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        description = "Return the error details in the response body if an error occurs",
        name = "ClientErrorResponseDto")
public class GenericClientErrorResponseDto {

    @Schema(description = "Integer value that indicates the error type.",
            example = "1", required = true, allowableValues = {"1","2","3","99"})
    int codeError;

    @Schema(description = "Text message describing the error found.",
            example = "Image is null or empty", required = true,
            allowableValues = {"1 Image is null or empty",
                    "2 Error loading face profile",
                    "3 Face image not found",
                    "99 Check contract details"})
    String message;

}


