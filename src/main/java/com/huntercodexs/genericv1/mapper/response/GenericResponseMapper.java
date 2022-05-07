package com.huntercodexs.genericv1.mapper.response;

import com.huntercodexs.genericv1.dto.request.GenericRequestDto;
import com.huntercodexs.genericv1.dto.response.GenericResponseDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;

@Data
@Setter
@Getter
@NoArgsConstructor
public class GenericResponseMapper {

    public static GenericResponseDto mapperGenericResponse(@Valid GenericRequestDto genericRequestDto) {
        GenericResponseDto response = new GenericResponseDto();
        response.setAny1(genericRequestDto.getAny1());
        response.setAny2(genericRequestDto.getAny2());
        return response;
    }

}
