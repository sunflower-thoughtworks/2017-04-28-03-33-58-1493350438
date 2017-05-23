package com.meituan.storm.demo.conf;

import java.util.Map;

public class TpAppConf {
    private String countField;

    private Map<String, String> filter;

    public String getCountField() {
        return countField;
    }

    public void setCountField(String countField) {
        this.countField = countField;
    }

    public Map<String, String> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, String> filter) {
        this.filter = filter;
    }
}
