
package cn.ye2moe.taki.utils.TCbean.recordList;
import java.util.List;

/**
 * Auto-generated: 2018-08-28 15:2:25
 *
 */
public class Domain {

    private String id;
    private String name;
    private String punycode;
    private String grade;
    private String owner;
    private String ext_status;
    private int ttl;
    private int min_ttl;
    private List<String> dnspod_ns;
    private String status;
    private int q_project_id;
    public void setId(String id) {
         this.id = id;
     }
     public String getId() {
         return id;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setPunycode(String punycode) {
         this.punycode = punycode;
     }
     public String getPunycode() {
         return punycode;
     }

    public void setGrade(String grade) {
         this.grade = grade;
     }
     public String getGrade() {
         return grade;
     }

    public void setOwner(String owner) {
         this.owner = owner;
     }
     public String getOwner() {
         return owner;
     }

    public void setExt_status(String ext_status) {
         this.ext_status = ext_status;
     }
     public String getExt_status() {
         return ext_status;
     }

    public void setTtl(int ttl) {
         this.ttl = ttl;
     }
     public int getTtl() {
         return ttl;
     }

    public void setMin_ttl(int min_ttl) {
         this.min_ttl = min_ttl;
     }
     public int getMin_ttl() {
         return min_ttl;
     }

    public void setDnspod_ns(List<String> dnspod_ns) {
         this.dnspod_ns = dnspod_ns;
     }
     public List<String> getDnspod_ns() {
         return dnspod_ns;
     }

    public void setStatus(String status) {
         this.status = status;
     }
     public String getStatus() {
         return status;
     }

    public void setQ_project_id(int q_project_id) {
         this.q_project_id = q_project_id;
     }
     public int getQ_project_id() {
         return q_project_id;
     }

}