package com.rs.demo.promotion.fact.coupon;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wengxiaojun on 16/10/6.
 * 阶梯满减
 */
public class LevelCoupon extends  Coupon{


    public LevelCoupon(long now_time, long begin_time, long end_time, long id, BigDecimal input_price) {
        super(now_time, begin_time, end_time, id, input_price);
    }


    public int getMax_level() {
        return max_level;
    }

    public void setMax_level(int max_level) {
        this.max_level = max_level;
    }

    //最多阶梯层数
    private  int max_level = 5;


    //规则文件循环次数统计
    private int  looped_count = 0;


    //key   ==> 满多少金额
    //value ==> 减多少金额
    private TreeMap<BigDecimal,BigDecimal> map_level = new TreeMap<BigDecimal,BigDecimal>();




    public  void setLevel(BigDecimal triger_price , BigDecimal preferential_price)
    {
        if(map_level.size() < max_level)
        {
            map_level.put(triger_price,preferential_price);
        }

    }


    public BigDecimal getPreferentialPrice(int position)
    {
        int count = 0;
        BigDecimal b = BigDecimal.ZERO;
       // System.out.println("[V]position:"+position);
        for(Map.Entry<BigDecimal,BigDecimal> entry : map_level.entrySet()) {

           // System.out.println("[V]count:"+count);
            if(count == position)
            {
                b  =  entry.getValue();
            //    System.out.println("[V]:"+b);
                break;
            }
            count += 1;
        }
        return b;
    }

    public BigDecimal getTrigerPrice(int position)
    {
        int count = 0;
        BigDecimal b = BigDecimal.ZERO;
       // System.out.println("[K]position:"+position);
        for(Map.Entry<BigDecimal,BigDecimal> entry : map_level.entrySet()) {

         //   System.out.println("[K]count:"+count);
            if(count == position)
            {
                b  =  entry.getKey();
          //      System.out.println("[K]:"+b);
                break;
            }
            count += 1;
        }
        return b;
    }

    public TreeMap<BigDecimal, BigDecimal> getMap_level() {
        return map_level;
    }


    public int getLooped_count() {
        return looped_count;
    }

    public void setLooped_count(int looped_count) {
        this.looped_count = looped_count;
    }

    public static void main(String[] args) {
         TreeMap<Integer,String>  tm = new TreeMap<Integer,String>();
        tm.put(1,"v1");
        tm.put(2,"v2");
        tm.put(3,"v3");
        tm.put(4,"v4");
        int j = 3;
        int count = 0;
        for(Integer i : tm.keySet())
        {
            count += 1;
            if(count == j)
            {
                System.out.println(tm.get(i));
                System.out.println(i);
            }

        }




    }

}
