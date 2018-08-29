package cn.ye2moe.taki.common;

import java.util.*;

public class ParamBuilder {
    private StringBuilder sb;

    public ParamBuilder(String l) {
        sb = new StringBuilder(l);
    }

    public String build() {
        return sb.toString();
    }

    public ParamBuilder put(String key, long value) {
        put(key, String.valueOf(value));
        return this;
    }

    public ParamBuilder put(String key, String value) {
        sb.append(key);
        sb.append("=");
        sb.append(value);
        return this;
    }

    public ParamBuilder and() {
        sb.append("&");
        return this;
    }


    public ParamBuilder putAll(HashMap<String, String> params) {
        if (params == null || params.size() <= 0) return this;
        //userRequest();
        withSort(params);
        //withoutSort(params);
        return this;
    }

    private void userRequest(){
        this.and().put("domain", "ye2moe.cn");
        this.and().put("length", "5");
        this.and().put("recordType", "A");
        this.and().put("recordLine", "默认");
        this.and().put("subDomain", "home");
        this.and().put("ttl", "600");
        this.and().put("value", "111.231.133.158");
    }

    private void withoutSort(HashMap<String, String> params) {
        for (String key : params.keySet()) {
            //System.out.println(key + "\t" + params.get(key));
            this.and().put(key, params.get(key));
        }
    }

    private void withSort(HashMap<String, String> params) {
        String[] array = Arrays.asList(params.keySet().toArray()).toArray(new String[]{});

        Arrays.sort(array);
        for (String key : array) {
            //System.out.println(key + "\t" + params.get(key));
            this.and().put(key, params.get(key));
        }
    }
}