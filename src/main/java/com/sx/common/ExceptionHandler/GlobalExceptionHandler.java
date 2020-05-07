package com.sx.common.ExceptionHandler;

import com.sx.common.result.Result;
import com.sx.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;


/**
 * @author yinyihang
 * @Description: 捕获全局异常 返回统一信息
 * @date 2020年05月6日
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    /**
     * 捕获空指针异常
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result exceptionNullPointerHandler(HttpServletRequest req, NullPointerException e) {
        logger.error("发生空指针异常！原因是:", e);
        String err = String.format("发生空指针异常！原因是:%s", e);
        return ResultUtil.error(500, req.getRequestURI(), err);
    }

    /**
     * 捕获未找到类异常
     */
    @ExceptionHandler(value = NoClassDefFoundError.class)
    @ResponseBody
    public Result exceptionNoClassHandler(HttpServletRequest req, NoClassDefFoundError e) {
        logger.error("发生未找到类异常！原因是:", e);
        String err = String.format("发生未找到类异常！原因是:%s", e);
        return ResultUtil.error(500, req.getRequestURI(), err);
    }

    /**
     * 捕获反射异常
     */
    @ExceptionHandler(value = ReflectiveOperationException.class)
    @ResponseBody
    public Result exceptionReflectiveHandler(HttpServletRequest req, ReflectiveOperationException e) {
        logger.error("捕获反射异常！原因是:", e);
        String err = String.format("捕获反射异常！原因是:%s", e);
        return ResultUtil.error(500, req.getRequestURI(), err);
    }

    /**
     * 404异常
     */
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseBody
    public Result exception404Handler(HttpServletRequest req, NoHandlerFoundException e) {
        logger.error("url 404 异常！原因是:", e);
        String err = String.format("url 404 异常！原因是:%s", e);
        return ResultUtil.error(500, req.getRequestURI(), err);
    }

    /**
     * 捕获所有总异常
     */
    @ExceptionHandler(value = Throwable.class)
    @ResponseBody
    public Result exceptionDefaultHandler(HttpServletRequest req, Throwable e) {
        logger.error("服务器内部错误！原因是:", e);
        String err = String.format("服务器内部错误！原因是:%s", e);
        return ResultUtil.error(500, req.getRequestURI(), err);
    }

    /**
     * 参数校验异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public Result NotValidExceptionHandler(HttpServletRequest req, MethodArgumentNotValidException e) {
        logger.error("参数校验异常！原因是:", e);
        String err = String.format("参数校验异常！原因是:%s", e);
        return ResultUtil.error(500, req.getRequestURI(), err);
    }

    /**
     * 捕获所有总异常
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionAllHandler(HttpServletRequest req, Exception e) {
        logger.error("运行总异常！原因是:", e);
        String err = String.format("运行总异常！原因是:%s", e);
        return ResultUtil.error(500, req.getRequestURI(), err);
    }
}
