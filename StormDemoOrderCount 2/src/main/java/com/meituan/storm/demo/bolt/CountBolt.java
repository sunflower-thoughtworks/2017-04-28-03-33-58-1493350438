package com.meituan.storm.demo.bolt;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountBolt extends BaseBasicBolt {
    private static final Logger logger = LoggerFactory.getLogger(CountBolt.class);
    private int count;

    public void execute(Tuple input, BasicOutputCollector collector) {
        Long id = input.getLong(0);
        count++;
        logger.info("Demo order count: " + count);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}
