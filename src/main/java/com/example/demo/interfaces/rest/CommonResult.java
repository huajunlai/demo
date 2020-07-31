package com.example.demo.interfaces.rest;

import lombok.Data;

/**
 * 統一回傳格式.
 * 2020/1/20 10:17 上午
 *
 * @param <T> 回傳物件
 * @author wei
 * @version 1.0.0
 **/
@Data
public final class CommonResult<T> {

    /**
     * 狀態碼.
     * 1 = 成功
     */
    private int status = 1;

    /**
     * 錯誤代碼.
     */
    private String errorCode = "";

    /**
     * 錯誤訊息.
     */
    private String errorMsg = "";

    /**
     * 回傳物件.
     */
    private T body;

    /**
     * Default Constructor.
     */
    public CommonResult() {

    }

    /**
     * Constructor.
     *
     * @param body 回傳物件
     */
    public CommonResult(final T body) {
        this.body = body;
    }

    /**
     * 產生錯誤.
     *
     * @param errorCode 錯誤代碼
     * @param errorMsg 錯誤代碼訊息
     * @param message 錯誤資訊
     * @return CommonResult
     */
    public static CommonResult fail(
            final String errorCode,
            final String errorMsg,
            final Object message
    ) {
        CommonResult commonResult = new CommonResult(message);
        commonResult.errorCode = errorCode;
        commonResult.errorMsg = errorMsg;
        commonResult.status = 0;
        return commonResult;
    }
}
