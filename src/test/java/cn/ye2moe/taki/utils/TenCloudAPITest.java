package cn.ye2moe.taki.utils;

import cn.ye2moe.taki.common.SimpleLog;
import cn.ye2moe.taki.utils.TCbean.recordCreate.Record;
import cn.ye2moe.taki.utils.TCbean.recordCreate.RecordCreateBean;
import cn.ye2moe.taki.utils.TCbean.recordList.RecordListBean;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * @author yezwei
 * @version 2018/8/28
 * @date 2018/08/28 16:38
 */

public class TenCloudAPITest {

    @Before
    public void init() {
        SimpleLog.enableDebug();
    }

    @Test
    public void recordListTest() {

        HashMap params = new HashMap<>();
        params.put("domain", "ye2moe.cn");

        String url = new TenCloudAPI(TenCloudAPI.CNS, "RecordList", params).getUrl();

        String Json = "{\"code\":0,\"message\":\"\",\"codeDesc\":\"Success\",\"data\":{\"domain\":{\"id\":\"65006191\",\"name\":\"ye2moe.cn\",\"punycode\":\"ye2moe.cn\",\"grade\":\"DP_Free\",\"owner\":\"qcloud_uin_100004439104@qcloud.com\",\"ext_status\":\"\",\"ttl\":600,\"min_ttl\":600,\"dnspod_ns\":[\"f1g1ns1.dnspod.net\",\"f1g1ns2.dnspod.net\"],\"status\":\"enable\",\"q_project_id\":0},\"info\":{\"sub_domains\":\"13\",\"record_total\":\"13\",\"records_num\":\"13\"},\"records\":[{\"id\":350357102,\"ttl\":86400,\"value\":\"f1g1ns1.dnspod.net.\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-03-16 15:45:55\",\"q_project_id\":0,\"name\":\"@\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"NS\",\"remark\":\"\",\"mx\":0,\"hold\":\"hold\"},{\"id\":350357104,\"ttl\":86400,\"value\":\"f1g1ns2.dnspod.net.\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-03-16 15:45:55\",\"q_project_id\":0,\"name\":\"@\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"NS\",\"remark\":\"\",\"mx\":0,\"hold\":\"hold\"},{\"id\":350365966,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-03-16 16:29:43\",\"q_project_id\":0,\"name\":\"www\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":356074107,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-04-19 19:46:15\",\"q_project_id\":0,\"name\":\"@\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":356074523,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-09 10:24:09\",\"q_project_id\":0,\"name\":\"m\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":373868721,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-06 15:06:47\",\"q_project_id\":0,\"name\":\"down\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":373868871,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-06 15:07:59\",\"q_project_id\":0,\"name\":\"sync\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":373868984,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-06 15:08:38\",\"q_project_id\":0,\"name\":\"bt\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":374075762,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-07 15:06:55\",\"q_project_id\":0,\"name\":\"proxy\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":374140763,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-07 17:53:30\",\"q_project_id\":0,\"name\":\"smb\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":374351972,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-08 12:49:56\",\"q_project_id\":0,\"name\":\"seed\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":374402705,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-08 16:51:50\",\"q_project_id\":0,\"name\":\"cloud\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0},{\"id\":374563430,\"ttl\":600,\"value\":\"111.231.133.158\",\"enabled\":1,\"status\":\"enabled\",\"updated_on\":\"2018-08-09 12:36:56\",\"q_project_id\":0,\"name\":\"blog\",\"line\":\"\\u9ed8\\u8ba4\",\"line_id\":\"0\",\"type\":\"A\",\"remark\":\"\",\"mx\":0}]}}";

        RecordListBean bean = new Gson().fromJson(Json, RecordListBean.class);

    }

    @Test
    public void recordCreateTest() {
        /**
         * domain	是	String	要添加解析记录的域名（主域名，不包括 www，例如：qcloud.com）
         * subDomain	是	String	子域名，例如：www
         * recordType	是	String	记录类型，可选的记录类型为："A", "CNAME", "MX", "TXT", "NS", "AAAA", "SRV"
         * recordLine	是	String	记录的线路名称，如："默认"
         * value	是
         */
        HashMap params = new HashMap<>();

        params.put("domain", "ye2moe.cn");
        params.put("subDomain", "home");
        params.put("length", "5");
        params.put("recordType", "A");
        params.put("ttl", "600");
        params.put("recordLine", "默认");
        params.put("value", "111.231.133.158");

        String url = new TenCloudAPI(TenCloudAPI.CNS, "RecordCreate", params).getUrl();

        String json = "{\"code\":0,\"message\":\"\",\"codeDesc\":\"Success\",\"data\":{\"record\":{\"id\":\"377845523\",\"name\":\"home\",\"status\":\"enabled\",\"weight\":null}}}";

        RecordCreateBean recordCreateBean = new Gson().fromJson(json,RecordCreateBean.class);


    }


    @Test
    public void recordModifyTest() {
        /**
         domain	是	String	要操作的域名（主域名，不包括 www，例如：qcloud.com）
         recordId	是	Int	解析记录的ID，可通过RecordList接口返回值中的 id 获取
         subDomain	是	String	子域名，例如：www
         recordType	是	String	记录类型，可选的记录类型为："A", "CNAME", "MX", "TXT", "NS", "AAAA", "SRV"
         recordLine	是	String	记录的线路名称，如："默认"
         value	是	String	记录值, 如 IP:192.168.10.2, CNAME: cname.dnspod.com., MX: mail.dnspod.com.
         */
        HashMap params = new HashMap<>();
        params.put("domain", "ye2moe.cn");
        params.put("recordId", "377845523");
        params.put("subDomain", "ucar");
        params.put("recordType", "A");
        params.put("recordLine", "默认");
        params.put("value", "111.231.133.158");

        String url = new TenCloudAPI(TenCloudAPI.CNS, "RecordModify", params).getUrl();

        String json = "{\"code\":0,\"message\":\"\",\"codeDesc\":\"Success\",\"data\":{\"record\":{\"id\":377845523,\"name\":\"ucar\",\"value\":\"111.231.133.158\",\"status\":\"enable\",\"weight\":null}}}";

        RecordCreateBean recordCreateBean = new Gson().fromJson(json,RecordCreateBean.class);


    }



    @Test
    public void recordDeleteTest() {
        /**
         参数名称	是否必选	类型	描述
         domain	是	String	解析记录所在的域名
         recordId	是	Int	解析记录ID
         */
        HashMap params = new HashMap<>();
        params.put("domain", "ye2moe.cn");
        params.put("recordId", "377845523");

        String url = new TenCloudAPI(TenCloudAPI.CNS, "RecordModify", params).getUrl();

        String json = "{\"code\":0,\"message\":\"\",\"codeDesc\":\"Success\",\"data\":{\"record\":{\"id\":377845523,\"name\":\"ucar\",\"value\":\"111.231.133.158\",\"status\":\"enable\",\"weight\":null}}}";

        RecordCreateBean recordCreateBean = new Gson().fromJson(json,RecordCreateBean.class);


    }
}