package com.example.demo.infrastructure.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date Time Util.
 * 2020/5/4 下午 12:16
 *
 * @author Lai
 * @version 1.0.0
 **/
public class DateTimeUtil {

    /**
     * 取得 yyyyMMddHHmmssSSS 日期格式現在時間.
     * @return yyyyMMddHHmmssSSS
     */
    public static String getDateTime() {
        return getFormatDateTime("yyyyMMddHHmmssSSS");
    }

    /**
     * 取得自定義日期格式時間.
     * @param format
     * @return string format date
     */
    public static String getFormatDateTime(final String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date());
    }
}
