package cn.cityworks.MessageProvider.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Utils {

    /**
     * 日期转字符串
     * @param date
     * @param formart 格式
     * @return
     */
    public static String DateToString(Date date,String formart){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formart);
        try {
            return simpleDateFormat.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符串转日期
     * @param date
     * @param formart 格式
     * @return
     */
    public static Date StringToDate(String date,String formart){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formart);
        try {
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 判断是否同一天
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);
        return isSameDate;
    }

    /**
     * 判断是否同一个月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        //通过工具类进行年月日时判断
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return isSameMonth;
    }

    /**
     * 判断是否同一个小时
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameHour(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        //通过工具类进行年月日时判断
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2
                .get(Calendar.YEAR);
        boolean isSameMonth = isSameYear
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth
                && cal1.get(Calendar.DAY_OF_MONTH) == cal2
                .get(Calendar.DAY_OF_MONTH);
        boolean isSameHour = isSameDate
                && cal1.get(Calendar.HOUR_OF_DAY) == cal2
                .get(Calendar.HOUR_OF_DAY);
        return isSameHour;
    }

    /**
     * 字符串转数字
     * @param num
     * @return
     */
    public static int StringToInt(String num) {
        int i = 0;
        try {
            i = Integer.parseInt(num);
        } catch (Exception e) {
            return 0;
        }
        return i;
    }

    /**
     * 获取某段时间的开始和结束
     *
     * @param day     大致范围
     * @param starEnd 开始时间后缀
     * @param endEnd  结束时间后缀
     * @return
     */
    public static Date[] getStarAndEndOfThisDate(String day, String starEnd, String endEnd) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dayStart = day + starEnd;
        String dayEnd = day + endEnd;
        Date start = null;
        Date end = null;
        try {
            start = format.parse(dayStart);
            end = format.parse(dayEnd);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Date[] dates = {start, end};
        return dates;
    }

    /**
     * 获取某月的最后一刻
     *
     * @param date
     * @return
     */
    public static Date getLastDateOfMonth(Date date) {
        Calendar ca = Calendar.getInstance();
        ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        return ca.getTime();
    }

    /**
     * 得到中文首字母
     *
     * @param str
     * @return
     */
    public static String getPinYinHeadChar(String str) {

        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }

    public static List<String> getTimeList(String start,String end){
        List<String> result = new ArrayList<>();
        int startInt = Integer.parseInt(start);
        int endInt = 0;
        if(end.equals("now")){
            end = DateToString(new Date(),"yyyy");
            endInt = Integer.parseInt(end)-1;
        }else {
            endInt = Integer.parseInt(end);
        }
        for( int i=endInt;i>=startInt;i-- ){
            result.add(String.valueOf(i));
        }
        Collections.reverse(result);
        return result;
    }

    public static String keepAfterTwo(String val){
        double doubleVal = 0;
        try {
            doubleVal = Double.parseDouble(val);
        } catch (Exception e){
            return val;
        }
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.##");
        return String.valueOf(df.format(doubleVal));
    }

}
