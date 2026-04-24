package com.pzp.util.response;

import java.util.Collection;

public class MutilResponse<T> extends Response {
    private Collection<T> dates;

    public MutilResponse() {
    }

    public static <T> MutilResponse<T> buildFail(String errorCode, String errorMsg, Collection<T> dates) {
        MutilResponse mutilResponse = new MutilResponse();
        mutilResponse.setSuccess(false);
        mutilResponse.setErrorCode(errorCode);
        mutilResponse.setErrorMsg(errorMsg);
        mutilResponse.setDates(dates);
        return mutilResponse;
    }

    public static <T> MutilResponse<T> buildSuccess(String errorCode, String errorMsg, Collection<T> dates) {
        MutilResponse mutilResponse = new MutilResponse();
        mutilResponse.setSuccess(true);
        mutilResponse.setErrorCode(errorCode);
        mutilResponse.setErrorMsg(errorMsg);
        mutilResponse.setDates(dates);
        return mutilResponse;
    }

    public Collection<T> getDates() {
        return this.dates;
    }

    public void setDates(Collection<T> dates) {
        this.dates = dates;
    }
}
