package com.huntercodexs.genericprojectdemov1.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "This object refers to error in the application", name = "GenericErrorResponse")
public class GenericErrorResponseDto {

    @Schema(
            description = "Integer value that indicates the executed module code.",
            example = "1", required = true
    )
    int codeError;
    
    @Schema(
            description = "Integer value that indicates the error type.",
            example = "500", required = true
    )
    int subCodeError;
    
    @Schema(
            description = "Text message describing the error found.",
            example = "Item or resource not found", required = true
    )
    String message;
    
}
