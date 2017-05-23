package com.meituan.storm.demo.conf;

import com.alibaba.fastjson.JSON;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TpAppConfTest {
    @Test
    public void testTpAppConf() {
        InputStream confStream = this.getClass().getClassLoader().getResourceAsStream("AppConfDemo");
        String conf = null;
        try {
            conf = IOUtils.toString(confStream, "utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        TpAppConf appConf = JSON.parseObject(conf, TpAppConf.class);
        System.out.println("count_field: " + appConf.getCountField());
        System.out.println("filter: " + appConf.getFilter());
    }
}