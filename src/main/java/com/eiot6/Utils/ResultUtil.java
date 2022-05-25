package com.eiot6.Utils;

public class ResultUtil {
    public static Result success(Object object) {
        Result<Object> result = new Result<Object>();
        result.setCode(0);
        result.setSuccess(true);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}