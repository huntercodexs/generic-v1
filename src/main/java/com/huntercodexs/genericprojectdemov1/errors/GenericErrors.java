package com.huntercodexs.genericprojectdemov1.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum GenericErrors {

    GENERIC_ERROR_MISSING_DATA(1, 400, "Missing Data"),
    GENERIC_ERROR_NOT_FOUND(2, 404, "Not found"),
    GENERIC_ERROR_EXCEPTION(3, 500, "Occurs an Error");

	public int codeError;
    public int subCodeError;
    public String message;

}
