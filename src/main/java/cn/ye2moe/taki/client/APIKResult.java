package cn.ye2moe.taki.client;

/**
 * @author yezwei（ye2moe@gmail.com）
 * @version 2018/8/23
 * @date 2018/08/23 14:23
 */
public class APIKResult {
    //{"success":"1","result":{"ip":"222.76.251.162","proxy":"1","att":"中国,福建,厦门","operators":"电信"}}
    private Integer success;
    private Data result;

    public Integer getSuccess() {
        return success;
    }

    public APIKResult setSuccess(Integer success) {
        this.success = success;
        return this;
    }

    public Data getResult() {
        return result;
    }

    public APIKResult setResult(Data result) {
        this.result = result;
        return this;
    }

    @Override
    public String toString() {
        return "APIKResult{" +
                "success=" + success +
                ", result=" + result +
                '}';
    }

    class Data{
        private String ip;
        private Integer proxy;
        private String att;
        private String operators;

        public String getIp() {
            return ip;
        }

        public Data setIp(String ip) {
            this.ip = ip;
            return this;
        }

        public Integer getProxy() {
            return proxy;
        }

        public Data setProxy(Integer proxy) {
            this.proxy = proxy;
            return this;
        }

        public String getAtt() {
            return att;
        }

        public Data setAtt(String att) {
            this.att = att;
            return this;
        }

        public String getOperators() {
            return operators;
        }

        public Data setOperators(String operators) {
            this.operators = operators;
            return this;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "ip='" + ip + '\'' +
                    ", proxy=" + proxy +
                    ", att='" + att + '\'' +
                    ", operators='" + operators + '\'' +
                    '}';
        }
    }
}
