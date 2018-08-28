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

        withSort(params);
        //withoutSort(params);
        return this;
    }

    private void withoutSort(HashMap<String, String> params){
        for(String key : params.keySet()){
            System.out.println(params.get(key));
            this.and().put(key, params.get(key));
        }
    }

    private void withSort(HashMap<String, String> params){
        String[] array =  Arrays.asList(params.keySet().toArray()).toArray(new String[]{});

        Arrays.sort(array);
        for(String key : array){
            System.out.println(params.get(key));
            this.and().put(key, params.get(key));
        }
    }
}