package cn.ye2moe.taki.common;

/**
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/22
 * @date 2018/08/22 17:49
 */
public class Result <T>{
    private int code;
    private String message;
    T data;
    public static Result SUCCESS = new Result(1,"成功");
    public static final int SUCCESS_CODE = 1;

    public static Result FAIL = new Result(0,"失败");

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result() {
    }

    public int getCode() {
        return code;
    }

    public Result setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }
}
