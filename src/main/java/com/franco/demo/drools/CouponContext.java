package com.franco.demo.drools;

import com.franco.demo.drools.coupon.Coupon;
import com.franco.demo.drools.coupon.SubtractCoupon;
import com.franco.demo.drools.facts.SubtractCouponFact;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * Created by malaka on 16/9/30.
 */
public class CouponContext {

    private CouponContext()
    {
        try {
            long begin_time = parseTime("2016-09-29 23:23:23");
            long end_time = parseTime("2016-10-01 23:23:23");
            SubtractCoupon sc = new SubtractCoupon(begin_time,
                    end_time,
                    "coupon_1",
                    new BigDecimal(300),
                    new BigDecimal(30));


            MAP_COUPON.put("c1",sc);

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    private static CouponContext instance = null ;

    public static CouponContext getIntance()
    {
        if(null == instance)
        {
            instance = new CouponContext();
        }
        return instance;
    }


    public static  String formatDate(Date date)throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public static Date parse(String strDate) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.parse(strDate);
    }

    public static long parseTime(String strDate) throws ParseException{
        return  parse(strDate).getTime();
    }

    private static HashMap<String,SubtractCoupon>  MAP_COUPON =  new HashMap<String,SubtractCoupon>() ;



    public static SubtractCoupon getCoupon(String c_name)
    {
        return MAP_COUPON.get(c_name);
    }


    public static void main(String[] args) {
        System.out.print("hw");
    }

}
