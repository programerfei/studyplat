package com.study.studyplatform.pojo;

public class InitResult<T> {
    //返回信息
    private String msg;
    //数据是否正常请求
    private boolean success;
    //符合要求的具体数据页数
    private long pageNumber;
    //具体返回的数据
    private T detail;
    //getter and setter

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getDetail() {
        return detail;
    }

    public void setDetail(T detail) {
        this.detail = detail;
    }

    public long getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(long pageNumber) {
        this.pageNumber = pageNumber;
    }
}
