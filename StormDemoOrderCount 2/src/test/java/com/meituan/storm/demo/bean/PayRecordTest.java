package com.meituan.storm.demo.bean;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class PayRecordTest {
    @Test
    public void testPayRecord() {
        String jsonStr = "{\"GA_IsNewSession\":\"1\", \"_mt_action\":\"PAY\", \"_mt_level\":\"INFO\", \"id\":\"3577545021\"}";
        PayRecord record = JSON.parseObject(jsonStr, PayRecord.class);
        System.out.println(record.getMtAction());
        System.out.println(record.getMtLevel());
        System.out.println(record.getId());
    }
}