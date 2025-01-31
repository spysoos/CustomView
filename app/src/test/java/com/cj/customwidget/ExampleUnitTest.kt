package com.cj.customwidget

import android.media.MediaTimestamp
import android.util.Base64
import androidx.annotation.IntRange
import com.google.gson.Gson
import org.junit.Test

import org.junit.Assert.*
import java.lang.Exception
import java.lang.StringBuilder
import java.math.BigDecimal
import java.net.URLConnection
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private var list:List<String>?=null

    @Test
    fun test3() {
        val s = "{\"errcode\":0,\"errmsg\":\"学生上传提交课后作业成功\",\"returnMap\":\"homework submitted successfully\"}"
        val fromJson = Gson().fromJson(s, TestBean::class.java)
        println(fromJson)
//        println(Math.round(1.123456))
//        val java = ExampleUnitTest::class.java
//        java.declaredFields.forEach {
//           println(Collection::class.java.isAssignableFrom(it.type))
//        }

//        JavaTest.test()
//        println(formatDateTime("2,3,4,5,6,7", "09:30:00", "23:00:00"))
//        val contentTypeFor = URLConnection.getFileNameMap()
//            .getContentTypeFor("video/ment/ツインテールです\uD83D\uDC67\uD83C\uDFFB #ファイブクローン.mp4")
//        println(contentTypeFor)
//        println("1234".subSequence(0,3))
    }

    fun formatDateTime(weeks: String?, startOpenTime: String?, endOpenTime: String?): String {
        val stringBuilder = StringBuilder()
        try {
            val weekStrs = arrayOf("星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日")
            val weekStrs2 = arrayOf("周一", "周二", "周三", "周四", "周五", "周六", "周日")
            val indexs = ArrayList<Int>()
            if (!weeks.isNullOrEmpty()) {
                indexs.addAll(weeks.split(",").map { it.toInt() - 1 })
                stringBuilder.append(weekStrs[indexs.first()]).append("至").append(weekStrs[indexs.last()])
            }
            val simpleDateFormat = SimpleDateFormat.getInstance() as SimpleDateFormat
            if (!startOpenTime.isNullOrEmpty()) {
                simpleDateFormat.applyPattern("HH:mm:ss")
                val startTime = simpleDateFormat.parse(startOpenTime)
                simpleDateFormat.applyPattern("HH:mm")
                stringBuilder.append(" ").append(simpleDateFormat.format(startTime)).append("-")
            }
            if (!endOpenTime.isNullOrEmpty()) {
                simpleDateFormat.applyPattern("HH:mm:ss")
                val endTime = simpleDateFormat.parse(endOpenTime)
                simpleDateFormat.applyPattern("HH:mm")
                stringBuilder.append(simpleDateFormat.format(endTime))
            }
            //获取差集
            val diffIndexs = List(7) { it }.toMutableList()
            diffIndexs.removeAll(indexs)
            if (diffIndexs.isNotEmpty()){
                stringBuilder.append(" ").append("(逢")
                diffIndexs.forEach {
                    stringBuilder.append(weekStrs2[it])
                }
                stringBuilder.append("店休)")
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
        return stringBuilder.toString()
    }

    @Test
    fun test2() {
//        TestParseInnerProValue.main(null)
//        Page().create()
        //#[^#]+?\s|#[^#]+?$
        val pattern = Pattern.compile("#[^#|\\s]{6,}?\\s|#[^#]{6,}?\$")
        pattern.matcher("dsa####dadsa # dasd #bbbbb   fsdfas  dsad#adsada").also {
            while (it.find()) {
                val message = it.group()
                println(message)
                println(message.length)
            }
        }


//        val goods = Goods()
//        println(goods.name)
//        goods.name = "ace"
//        println(goods.name)
    }


    var Goods.name: String
        get() = "lucas"
        set(value) {
//        this.field = value
        }


    interface IStudent {
        fun study()
    }

    interface IStudent2 : IStudent {
        fun changeAge(a: Int)
    }

    open class LucasStudent : IStudent {
        var age = 11
        override fun study() {
            println(age.toString())
        }
    }

    open class Page : IStudent by LucasStudent() {

        fun create() {
            println(this)
            val iStudent = this as? IStudent
            println(iStudent)
            val lucasStudent = this as? LucasStudent
            println(lucasStudent)
        }
    }


    @Test
    fun addition_isCorrect() {
        val content =
            "{\"traceId\":\"0b29d24449754098aef7474788b3e8fb\",\"signature\":\"DC681BF444FB06D5E7A90DC48C20\",\"signKey\":\"6iW0mC5lC8hX2jC5hQ0jT9cT8cB4mV\",\"page\":1,\"rows\":10,\"type\":0,\"timestamp\":\"1594781299769\",\"token\":\"eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMDk2NjUwMTI4MzEwMjM1MTM4IiwiaWF0IjoxNTk0MTk5NTMyfQ.yFXA2tWiISPjOB3bKtOxyrik76-ZcSqmnz3IPDhC2bk\"}"
//        EncryptUtils.doAesEncrypt(content, "zoxgBvQQXOHk2wC8t/Irrw==", "XLeeyndP7zP5B4Mipnpk6Q==")
//        val atoken=" khReyvlxzdIV6cBsxQwM6BnYkSsuaFkCp6MlmGWIMNRga9q5j5CW6VC19JxDoDXmxuKiapVVH/jMUMlOOcue5qEXncEMXqE3NclMbdCrkhj5ylowZAMlJQJVlhUhQKeyUTxN3s/2apEByi21oId480313Z0YzjfBMq4aqIlb7Minl2spv1Y30zCpvwxfqHLLg8ssSJayDOPeynd9afiDd/yJt7W6vXwGkK2XpErVqPa+JIQfDtnruI/QuNcsgnwNNVOQ0kCJstvI9yDy48GvluM7fo7WBd/iOoTor0eYh394F8XjFUSE7BU7HbZQI9E0X4p7GjZQMDMFlI7scDL2DSNKMaZG3/r1afvnrl68AyePCufOHaSOfpcEQKorNP/QYMtTW3c0m7sQ6VYYHhoN47RJiPGF46l91J19r8DP47kR8IWqJWnGI+UMWIlqmhWf"
//        val doAesDecrypt = EncryptUtils.doAesDecrypt(
//            atoken,
//            Base64.decode("zoxgBvQQXOHk2wC8t/Irrw==", Base64.DEFAULT),
//            Base64.decode("XLeeyndP7zP5B4Mipnpk6Q==", Base64.DEFAULT)
//        )
//        System.out.println(doAesDecrypt)
//        System.out.println("XLeeyndP7zP5B4Mipnpk6Q==".length)
//        System.out.println(String(Base64.decode("MDM5MjAzOTIwMzIwMTgxMg==", Base64.DEFAULT)).length)
//        System.out.println("0000000000000000".length)

//        System.out.println("32:37:F7:26:72:D9:6A:B9:1E:FD:95:EB:69:66:D6:10".replace(":","").toLowerCase())
//        System.out.println(3330 transformK 1)
//        time24().forEach {
//            System.out.println(it.key.plus("-").plus(it.value))
//        }
//        System.out.println("tem:${10000L formatDuration ":"}")
//        System.out.println(Date(System.currentTimeMillis()).isYesterday())
//        System.out.println("[\"1596384000000\",\"1596398400000\",\"1596412800000\"]")
//        System.out.println("[\"1596384000000\",\"1596398400000\",\"1596412800000\"]".replace("\\",""))

        val simpleDateFormat = SimpleDateFormat.getInstance() as SimpleDateFormat
        simpleDateFormat.applyPattern("yyyy:MM:dd HH:mm:ss")
        System.out.println(simpleDateFormat.format(Date(1596297600000)))
    }

    fun testRxJava() {
    }

    fun Date.isToday(): Boolean {
        val todayCalendar = Calendar.getInstance()
        val calendar = Calendar.getInstance().apply { time = this@isToday }
        if (todayCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
            return todayCalendar.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR) == 0
        }
        return false
    }

    fun Date.isYesterday(): Boolean {
        val todayCalendar = Calendar.getInstance()
        val calendar = Calendar.getInstance().apply { time = this@isYesterday }
        if (todayCalendar.get(Calendar.YEAR) == calendar.get(Calendar.YEAR)) {
            return todayCalendar.get(Calendar.DAY_OF_YEAR) - calendar.get(Calendar.DAY_OF_YEAR) == 1
        }
        return false
    }

    infix fun Long.formatDuration(appendStr: String): String {
        val h = this / 3600
        val m = this % 3600 / 60
        val s = this % 3600 % 60
        var temp = ""
        if (h != 0L) temp = temp.plus(if (h > 9) h else "0$h").plus(appendStr)
        if (m != 0L) temp = temp.plus(if (m > 9) m else "0$m").plus(appendStr)
        if (s != 0L) temp = temp.plus(if (s > 9) s else "0$s")
        if (h == 0L && m == 0L && s == 0L) return "00:00"
        return temp
    }

    fun time24(): TreeMap<String, Long> {
        val instance = Calendar.getInstance()
        val y = instance.get(Calendar.YEAR)
        val m = instance.get(Calendar.MONTH)
        val d = instance.get(Calendar.DAY_OF_MONTH)
        instance.set(Calendar.MINUTE, 0)
        instance.set(Calendar.SECOND, 0)
        val simpleDateFormat = SimpleDateFormat.getInstance() as SimpleDateFormat
        simpleDateFormat.applyPattern("yyyy-MM-dd HH:mm:ss")
        val hashMap = TreeMap<String, Long>()
        for (i in 0 until 24) {
            instance.set(y, m, d, i, 0, 0)
            System.out.println(simpleDateFormat.format(instance.time))
            hashMap.put(simpleDateFormat.format(instance.time), instance.time.time)
        }
        return hashMap
    }


    infix fun Int.transformK(@IntRange(from = 0, to = 4) accuracy: Int): String {
        var acc = 0f

        when (accuracy) {
            1 -> acc = 0.1f
            2 -> acc = 0.01f
            3 -> acc = 0.001f
            4 -> acc = 0.0001f
        }
        if (this < 1_000) return this.toString()//数值太小不转换
        return BigDecimal((this / 100).toString()).multiply(BigDecimal(acc.toString())).toString()
    }
}