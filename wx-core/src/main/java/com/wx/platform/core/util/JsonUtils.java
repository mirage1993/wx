package com.wx.platform.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yongyongwang
 * @date 2018-09-10
 * @description 该类用于转换输出Json数据工具类
 */
public final class JsonUtils {

    private static Logger LOG = LoggerFactory.getLogger(JsonUtils.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void writeValueAsJson(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();

            String s = "{\"status\":\"success\",\"msg\":" + objectMapper.writeValueAsString(null) + "}";
            out.write(s);
        } catch (IOException ex) {
            LOG.error(ex.getMessage(), ex);
        } finally {

        }
    }


}
