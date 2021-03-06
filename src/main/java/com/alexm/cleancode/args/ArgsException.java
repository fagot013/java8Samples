package com.alexm.cleancode.args;

import static com.alexm.cleancode.args.ArgsException.ErrorCode.OK;

/**
 * @author AlexM
 * Date: 3/12/20
 **/
public class ArgsException extends Exception {
    private char errorArgumentId = '\0';
    private String errorParameter = null;
    private ErrorCode errorCode = OK;

    public enum ErrorCode {
        OK,
        INVALID_ARGUMENT_NAME,
        INVALID_ARGUMENT_FORMAT,
        UNEXPECTED_ARGUMENT,
        MISSING_STRING,
        MISSING_INTEGER,
        INVALID_INTEGER,
        INVALID_DOUBLE, MISSING_DOUBLE;
    }

    public ArgsException(String message) {
        super(message);
    }

    public ArgsException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ArgsException(ErrorCode errorCode, String errorParameter) {
        this.errorCode = errorCode;
        this.errorParameter = errorParameter;
    }


    public ArgsException(ErrorCode errorCode, char errorArgumentId, String errorParameter) {
        this.errorCode = errorCode;
        this.errorArgumentId = errorArgumentId;
        this.errorParameter = errorParameter;
    }

    public String getErrorMessage() {
        switch (errorCode) {
            case OK: return "TILT: Should not get here";
            case UNEXPECTED_ARGUMENT:       return String.format("Argument -%c unexpected.", errorArgumentId);
            case MISSING_STRING:            return String.format("Could not find string parameter for -%c", errorArgumentId);
            case INVALID_INTEGER:           return String.format("Argument -%c expects an integer but was %s", errorArgumentId, errorParameter);
            case MISSING_INTEGER:           return String.format("Could not find integer parameter for -%c", errorArgumentId);
            case INVALID_DOUBLE:            return String.format("Argument -%c expects an double but was %s", errorArgumentId, errorParameter);
            case MISSING_DOUBLE:            return String.format("Could not find double parameter for -%c", errorArgumentId);
            case INVALID_ARGUMENT_NAME:     return String.format("'%c' is not a valid argument", errorArgumentId);
            case INVALID_ARGUMENT_FORMAT:   return String.format("'%s' is not a valid argument format", errorParameter);
        }
        return "";
    }

    public char getErrorArgumentId() {
        return errorArgumentId;
    }

    public void setErrorArgumentId(char errorArgumentId) {
        this.errorArgumentId = errorArgumentId;
    }

    public String getErrorParameter() {
        return errorParameter;
    }

    public void setErrorParameter(String errorParameter) {
        this.errorParameter = errorParameter;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
