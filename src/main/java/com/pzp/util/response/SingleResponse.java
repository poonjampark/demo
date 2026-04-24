package com.pzp.util.response;

public class SingleResponse<T> extends Response {
    private T date;

    public SingleResponse() {
    }

    public static <T> SingleResponse<T> buildFail(String errorCode, String errorMsg, T date) {
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.setSuccess(false);
        singleResponse.setErrorCode(errorCode);
        singleResponse.setErrorMsg(errorMsg);
        singleResponse.setDate(date);
        return singleResponse;
    }

    public static <T> SingleResponse<T> buildSuccess(String errorCode, String errorMsg, Object date) {
        SingleResponse singleResponse = new SingleResponse();
        singleResponse.setSuccess(true);
        singleResponse.setErrorCode(errorCode);
        singleResponse.setErrorMsg(errorMsg);
        singleResponse.setDate(date);
        return singleResponse;
    }

    public Object getDate() {
        return this.date;
    }

    public void setDate(T date) {
        this.date = date;
    }
}
