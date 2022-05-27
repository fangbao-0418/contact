package com.eiot6.Utils;

public class ResultUtil {
    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.setCode(0);
        result.setSuccess(true);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static <T> Result<T> error(Integer code, String msg) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setSuccess(false);
        result.setMsg(msg);
        return result;
    }
}