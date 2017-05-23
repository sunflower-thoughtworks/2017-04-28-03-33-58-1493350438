package com.meituan.storm.demo.bean;

/**
 * log.orderlog 数据示例：
 * {"GA_IsNewSession":"1","GA_UUID":"","_mt_action":"PAY",
 * "_mt_clientip":"0.0.0.0","_mt_datetime":"2017-03-31 14:53:59",
 * "_mt_level":"INFO","abtesttag":"","amount":"19.8","appid":"0",
 * "cardcode":"0","city":"232","coupontype":"0","credit":"0.0",
 * "dealid":"25068960","dealslug":"25068960","deliveryfee":"0.0",
 * "direct":"19.8","fromordersplit":"1","giftcard":"0.0","hasCookie":"0",
 * "id":"3581226445","magiccard":"0.0","mobile":"18366431220",
 * "modtime":"1490943239","orderattr":"192","orderip":"117.136.94.151",
 * "ordertime":"1490943202","payattr":"4398047035392",
 * "payed":"19.8","payedsum":"0.0","paytime":"1490943239",
 * "quantity":"1","rebate":"0.0","recharge":"0.0","refundstatus":"0",
 * "status":"64","totalfee":"19.8","trace_currentTime":"","trace_initVisitTime":"",
 * "trace_sessionNum":"","unionid":"0","userid":"289643145","utma_currentSessionTime":"",
 * "utma_domainHash":"","utma_initVisitTime":"","utma_previousSessionTime":"",
 * "utma_uniqueID":"","utma_visitTimes":"","utmb_currentSessionTime":"",
 * "utmb_domainHash":"","utmb_pageViewCounter":"","utmb_unknownField":"","utmc":"",
 * "utmv_customVar":"","utmv_domainHash":"","utmz_campaignNum":"","utmz_domainHash":"",
 * "utmz_initVisitTime":"","utmz_sessionNum":"","utmz_utmccn":"","utmz_utmcct":"",
 * "utmz_utmcmd":"","utmz_utmcsr":"","utmz_utmctr":"","version":"2"}
 */
public class PayRecord {
    private String mtAction;
    private String mtLevel;
    private Long id;

    public String getMtAction() {
        return mtAction;
    }

    public void setMtAction(String mtAction) {
        this.mtAction = mtAction;
    }

    public String getMtLevel() {
        return mtLevel;
    }

    public void setMtLevel(String mtLevel) {
        this.mtLevel = mtLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
