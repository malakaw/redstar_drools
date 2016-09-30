package com.franco.demo.drools.coupon;

import java.util.Date;

/**
 * Created by malaka on 16/9/30.
 */
public class Coupon {

    private long date_effective;
    private long date_expires;
    private String name;

    public Coupon(long date_effective, long date_expires, String name) {
        this.date_effective = date_effective;
        this.date_expires = date_expires;
        this.name = name;
    }


    public long getDate_effective() {
        return date_effective;
    }

    public void setDate_effective(long date_effective) {
        this.date_effective = date_effective;
    }

    public long getDate_expires() {
        return date_expires;
    }

    public void setDate_expires(long date_expires) {
        this.date_expires = date_expires;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
