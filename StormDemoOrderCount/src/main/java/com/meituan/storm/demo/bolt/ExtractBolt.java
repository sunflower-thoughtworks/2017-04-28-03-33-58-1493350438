package com.meituan.storm.demo.bolt;

import backtype.storm.task.TopologyContext;
import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;
import com.alibaba.fastjson.JSON;
import com.meituan.storm.demo.bean.PayRecord;
import com.meituan.storm.demo.conf.TpAppConf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ExtractBolt extends BaseBasicBolt {
    String countField;
    Map<String, String> filter;
    private static final Logger logger = LoggerFactory.getLogger(ExtractBolt.class);

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        // 获取平台注册拓扑应用配置信息，如未使用可忽略
        String appConfigJson = (String)stormConf.get("topology.meituan.appConfig");

        TpAppConf appConf = JSON.parseObject(appConfigJson, TpAppConf.class);
        countField = appConf.getCountField();
        filter = appConf.getFilter();
    }

    public void execute(Tuple input, BasicOutputCollector collector) {
        String recordJson = input.getString(0);

        if (recordJson == null || recordJson.isEmpty()) {
            return;
        }

        PayRecord record = JSON.parseObject(recordJson, PayRecord.class);
        if (!isKeep(record)) {
            return;
        }

        collector.emit(new Values(record.getId()));
    }

    private boolean isKeep(PayRecord payRecord) {
        if (!filter.get("_mt_action").equals(payRecord.getMtAction())) {
            return false;
        }

        if (!filter.get("_mt_level").equals(payRecord.getMtLevel())) {
            return false;
        }

        return true;
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("id"));
    }
}
