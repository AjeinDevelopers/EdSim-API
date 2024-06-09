package com.educasim.educasim.request.clases;

public class LoginResponse {

    String sessionId;
    String message;
    boolean error;

    public LoginResponse(String sessionId, String message, boolean error) {
        this.sessionId = sessionId;
        this.message = message;
        this.error = error;
    }

    public LoginResponse() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }
}
