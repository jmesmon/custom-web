package com.chxd.policeDog.vo;

/**
 * Created by cheng on 2017/8/29.
 */
public class ResultVO {
    private boolean success = true;
    private String message;
    private Object result;

    public static ResultVO getInstance(){
        return new ResultVO();
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
