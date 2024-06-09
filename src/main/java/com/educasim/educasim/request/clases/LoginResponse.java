package com.educasim.educasim.request.clases;

public class LoginResponse {

    int sessionId;
    String message;
    boolean error;

    public LoginResponse(int sessionId, String message, boolean error) {
        this.sessionId = sessionId;
        this.message = message;
        this.error = error;
    }

    public LoginResponse() {
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
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
