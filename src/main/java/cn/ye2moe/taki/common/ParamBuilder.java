package cn.ye2moe.taki.common;

import java.util.HashMap;

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
        for (String key : params.keySet()) {
            this.and().put(key, params.get(key));
        }
        //sb.deleteCharAt(sb.length() - 1);
        return this;
    }
}