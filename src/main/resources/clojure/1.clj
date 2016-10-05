(ns rule-demo1.rule_coupon
    (:gen-class)
    (:import java.text.SimpleDateFormat
      java.util.Calendar))

(require '[clj-time.coerce :as c])

(defn days-later [n]
      (let [today (Calendar/getInstance)]
           (doto today
                 (.add Calendar/DATE n)
                 .toString)))

(defn formatDate [n]
      (let [date_    (days-later n)  fd  (new SimpleDateFormat "yyyy-MM-dd hh:mm:ss")]
           (.format fd (.getTime date_))
           )
      )

(def begin_time (c/to-long  "2016-10-01 11:02:11"))
(def end_time  (c/to-long  "2016-10-02 11:02:11"))
(def now_time  (c/to-long  "2016-10-01 12:02:11"))

(def levels_coupon
  {;;现在时间
   :now_time now_time
   ;;活动开始时间
   :begin_time begin_time
   ;;活动结束时间
   :end_time end_time
   ;;输入订单的价格
   :in_order_price (bigdec 300.01)
   ;;每个阶梯的优惠金额
   :preferential_level [[(bigdec 100) (bigdec 200)  (bigdec 10)]  ;;100---200之间，优惠10元
                        [(bigdec 200) (bigdec 300)  (bigdec 15)]
                        [(bigdec 300) (bigdec 400)  (bigdec 20)]
                        [(bigdec 400) (bigdec 500)  (bigdec 100)]
                        [(bigdec 500) (bigdec 1000) (bigdec 200)]]

   }
  )

(def discount_coupon
  {;;现在时间
   :now_time now_time
   ;;活动开始时间
   :begin_time begin_time
   ;;活动结束时间
   :end_time end_time
   ;;输入订单的价格
   :in_order_price (bigdec 300.01)
   ;;满多少价格打折。。
   :trigger_price    (bigdec 100.0)
   ;;多少折扣
   :discount (bigdec 0.3)
   }
  )


(def every_subtract_coupon
  {;;现在时间
   :now_time now_time
   ;;活动开始时间
   :begin_time begin_time
   ;;活动结束时间
   :end_time end_time
   ;;输入订单的价格
   :in_order_price (bigdec 300.01)
   ;;满多少价格减。。
   :trigger_price    (bigdec 100.0)
   ;;减的价格［优惠多少］
   :preferential_price (bigdec 10.0)
   }
  )

(def subtract_coupon
  {;;现在时间
   :now_time now_time
   ;;活动开始时间
   :begin_time begin_time
   ;;活动结束时间
   :end_time end_time
   ;;输入订单的价格
   :in_order_price (bigdec 300.01)
   ;;满多少价格减。。
   :trigger_price    (bigdec 100.0)
   ;;减的价格［优惠多少］
   :preferential_price (bigdec 10.0)
   }
  )


(def cash_coupon
  {;;现在时间
   :now_time now_time
   ;;活动开始时间
   :begin_time begin_time
   ;;活动结束时间
   :end_time end_time
   ;;输入订单的价格
   :in_order_price (bigdec 300.01)
   ;;减的价格［优惠多少］
   :preferential_price (bigdec 8.0)
   }
  )

;;(subtract_coupon_apply  subtract_coupon)
;;(subtract_coupon_apply  (merge subtract_coupon {:trigger_price 400}))
;;(subtract_coupon_apply  (merge subtract_coupon {:preferential_price 19}))
;;(subtract_coupon_apply  (merge subtract_coupon {:now_time  (c/to-long "2016-12-01 01:01:01")}))



;;满减券使用，计算最后优惠的价格
(defn subtract_coupon_apply [c]
      (if  (> (:in_order_price c) (:trigger_price c))
        (cash_coupon_apply c)
        (:in_order_price c)
        )
      )


;;现金券使用，计算最后优惠的价格
(defn cash_coupon_apply [c]
      (let [order_price (bigdec  (:in_order_price c))  now (:now_time c)]
           (if (and  (>= now (:begin_time c)) (<= now (:end_time c)))
             (- order_price (:preferential_price c))
             order_price
             )
           )
      )


;;(every_subtract_coupon_apply every_subtract_coupon)
;;(every_subtract_coupon_apply (merge  every_subtract_coupon {:in_order_price 800.0}))
;;(every_subtract_coupon_apply (merge  every_subtract_coupon {:in_order_price 800.001}))
;;(every_subtract_coupon_apply (merge  every_subtract_coupon {:in_order_price 100.001}))
;;(every_subtract_coupon_apply (merge  every_subtract_coupon {:in_order_price 10.001}))
;;每满减券使用，计算最后优惠的价格
(defn every_subtract_coupon_apply [c]
      (let [order_price (bigdec (:in_order_price c))  now  (:now_time c)]
           (if (and  (>= now (:begin_time c)) (<= now (:end_time c)))
             (- order_price
                (let [count_pre
                      (*
                        (int (/ order_price (:trigger_price c)))
                        (:preferential_price c)
                        )]
                     count_pre
                     )
                )
             order_price
             )))


;;折扣券使用，计算最后优惠的价格
(defn discount_coupon_apply [c]
      (let [now (:now_time c)]
           (if (and (>= now (:begin_time c)) (<= now (:end_time c))
                    (> (:in_order_price c) (:trigger_price c)))
             (* (:in_order_price c) (:discount c))
             (:in_order_price c)
             )
           )
      )

;;(discount_coupon_apply (merge  discount_coupon {:in_order_price 800.0  :discount 0.5}))
;;(discount_coupon_apply (merge  discount_coupon {:in_order_price 10.0  :discount 0.51}))


;;阶梯券使用，计算最后优惠的价格
(defn levels_coupon_apply [c]
      (let [now (:now_time c)]
           (if (and (>= now (:begin_time c)) (<= now (:end_time c))
                    (> (:in_order_price c) (:trigger_price c)))


             )
           )
      )







(defn -main
      "I don't do a whole lot ... yet."
      [& args]
      (println "Hello, World!"))










