package cn.com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Column(name = "c_name")
    private String cName;
    @Column(name = "simple_name")
    private String simpleName;
    @Column(name = "trade")
    private String trade;
    @Column(name = "source")
    private String source;
    @Column(name = "address")
    private String address;
    @Column(name = "remark")
    private String remark;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getSimpleName() {
        return simpleName;
    }

    public void setSimpleName(String simpleName) {
        this.simpleName = simpleName;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cName='" + cName + '\'' +
                ", simpleName='" + simpleName + '\'' +
                ", trade='" + trade + '\'' +
                ", source='" + source + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
