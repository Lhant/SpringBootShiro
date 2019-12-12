package com.zqk.pojo;

/**
 * 
 * 
 * @author wcyong
 * 
 * @date 2019-11-18
 */
public class Perms {
    private Integer permid;

    private String permname;

    private String permstring;

    public Integer getPermid() {
        return permid;
    }

    public void setPermid(Integer permid) {
        this.permid = permid;
    }

    public String getPermname() {
        return permname;
    }

    public void setPermname(String permname) {
        this.permname = permname == null ? null : permname.trim();
    }

    public String getPermstring() {
        return permstring;
    }

    @Override
    public String toString() {
        return "Perms{" +
                "permid=" + permid +
                ", permname='" + permname + '\'' +
                ", permstring='" + permstring + '\'' +
                '}';
    }

    public void setPermstring(String permstring) {
        this.permstring = permstring == null ? null : permstring.trim();
    }
}