package com.hrious.pojo;

/**
 * @author wgc
 *
 */
public class User {
    private int unum;
    private String uname;
    private int uage;
    public User() {
        super();
    }
    public User(int unum, String uname, int uage) {
        super();
        this.unum = unum;
        this.uname = uname;
        this.uage = uage;
    }
    public int getUnum() {
        return unum;
    }
    public void setUnum(int unum) {
        this.unum = unum;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public int getUage() {
        return uage;
    }
    public void setUage(int uage) {
        this.uage = uage;
    }
    @Override
    public String toString() {
        return "User [unum=" + unum + ", uname=" + uname + ", uage=" + uage + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + uage;
        result = prime * result + ((uname == null) ? 0 : uname.hashCode());
        result = prime * result + unum;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (uage != other.uage)
            return false;
        if (uname == null) {
            if (other.uname != null)
                return false;
        } else if (!uname.equals(other.uname))
            return false;
        if (unum != other.unum)
            return false;
        return true;
    }
}
