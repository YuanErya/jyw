package cn.jyw.feign.common.api;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

//用于进行格式化的传递数据
@Data
@NoArgsConstructor
public class ApiResult<T> implements Serializable {
    private long code;
    private T data;
    private String message;

    /**
     * 全参
     *
     * @param code    业务状态码
     * @param message 描述
     * @param data    结果集
     */
    public ApiResult(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ApiResult(cn.jyw.feign.common.api.IErrorCode errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(cn.jyw.feign.common.api.ApiErrorCode.FAILED);
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    /**
     * 成功
     *
     * @param
     * @return {code:200,message:操作成功,data:自定义}
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> success() {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.SUCCESS.getCode(), cn.jyw.feign.common.api.ApiErrorCode.SUCCESS.getMessage(), null);
    }

    /**
     * 成功
     *
     * @param data 结果集
     * @return {code:200,message:操作成功,data:自定义}
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> success(T data) {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.SUCCESS.getCode(), cn.jyw.feign.common.api.ApiErrorCode.SUCCESS.getMessage(), data);
    }

    /**
     * 成功
     *成功信息
     * @param
     * @return {code:200,message:自定义,data:自定义}
     */

    public static <T> cn.jyw.feign.common.api.ApiResult<T> success(String message) {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.SUCCESS.getCode(), message, null);
    }

    /**
     * 成功
     *
     * @param data    结果集
     * @param message 自定义提示信息
     * @return {code:200,message:自定义,data:自定义}
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> success(T data, String message) {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> failed() {
        return failed(cn.jyw.feign.common.api.ApiErrorCode.FAILED);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     * @return {code:枚举ApiErrorCode取,message:自定义,data:null}
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> failed(String message) {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.FAILED.getCode(), message, null);
    }

    /**
     * 失败
     *
     * @param errorCode 错误码
     * @return {code:封装接口取,message:封装接口取,data:null}
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> failed(cn.jyw.feign.common.api.IErrorCode errorCode) {
        return new cn.jyw.feign.common.api.ApiResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     * @param message   错误信息
     * @return {code:枚举ApiErrorCode取,message:自定义,data:null}
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> failed(cn.jyw.feign.common.api.IErrorCode errorCode, String message) {
        return new cn.jyw.feign.common.api.ApiResult<T>(errorCode.getCode(), message, null);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> validateFailed() {
        return failed(cn.jyw.feign.common.api.ApiErrorCode.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> validateFailed(String message) {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> unauthorized(T data) {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.UNAUTHORIZED.getCode(), cn.jyw.feign.common.api.ApiErrorCode.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> cn.jyw.feign.common.api.ApiResult<T> forbidden(T data) {
        return new cn.jyw.feign.common.api.ApiResult<T>(cn.jyw.feign.common.api.ApiErrorCode.FORBIDDEN.getCode(), cn.jyw.feign.common.api.ApiErrorCode.FORBIDDEN.getMessage(), data);
    }
}
