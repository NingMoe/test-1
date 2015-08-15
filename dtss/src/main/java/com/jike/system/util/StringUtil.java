package com.jike.system.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * @ClassName: StringUtils
 * @Description: 字符串操作工具类
 */
public final class StringUtil {
    
    /**
     * <p>Title: </p>.
     * <p>Description: </p>
     */
    private StringUtil() {
        
    }
    /**
     * @Title: isBlank
     * @Description: 判断字符串是否为空(此处代表null、空格或"")
     * @param str   待判断字符串
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    /**
     * @Title: isEmpty
     * @Description: 判断字符串是否为空(此处代表null或"")
     * @param str   待判断字符串
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    /**
     * @Title: isNotEmpty
     * @Description: 判断字符串是否为空(此处代表null或"")
     * @param str   待判断字符串
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * @Title: isAllLowerCase
     * @Description: 判断字符串是否全为小写字母
     * @param str   待判断字符串
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isAllLowerCase(String str) {
        return StringUtils.isAllLowerCase(str);
    }

    /**
     * @Title: isAllUpperCase
     * @Description: 判断字符串是否全为大写字母
     * @param str   待判断字符串
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isAllUpperCase(String str) {
        return StringUtils.isAllUpperCase(str);
    }

    /**
     * @Title: isAlpha
     * @Description: 判断字符串是否全为unicode字母
     * @param str   待判断字符串
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isAlpha(String str) {
        return StringUtils.isAlpha(str);
    }

    /**
     * @Title: isNumeric
     * @Description: 判断字符串是否全为数字
     * @param str   待判断字符串
     * @return boolean    返回类型
     * @throws
     */
    public static boolean isNumeric(String str) {
        return StringUtils.isNumeric(str);
    }

    /**
     * @Title: join
     * @Description: 把数组中的元素连接为字符串
     * @param array     待操作数组
     * @return String    返回类型
     * @throws
     */
    public static String join(Object[] array) {
        return StringUtils.join(array);
    }

    /**
     * @Title: join
     * @Description: 把数组中的元素连接为字符串
     * @param array     待操作数组
     * @param separator 连接符
     * @return String    返回类型
     * @throws
     */
    public static String join(Object[] array, String separator) {
        return StringUtils.join(array, separator);
    }
    /**
     * @Title: join
     * @Description: 把集合中的元素连接为字符串
     * @param col     待操作集合
     * @return String    
     * @throws
     */
    @SuppressWarnings("rawtypes")
	public static String join(Collection col) {
        return StringUtils.join(col, ",");
    }
    /**
     * @Title: join
     * @Description: 把集合中的元素连接为字符串
     * @param col     待操作集合
     * @param separator 连接符
     * @return String    
     * @throws
     */
    @SuppressWarnings("rawtypes")
	public static String join(Collection col, String separator) {
        return StringUtils.join(col, separator);
    }

    /**
     * @Title: replace
     * @Description: 用新值代替字符串中指定的旧值
     * @param text  待替换字符串
     * @param searchText    旧值
     * @param replaceText   新值
     * @return String    返回类型
     * @throws
     */
    public static String replace(String text, String searchText, String replaceText) {
        return StringUtils.replace(text, searchText, replaceText);
    }

    /**
     * @Title: split
     * @Description: 分解字符串为数组(分解符为空格)
     * @param str   待操作字符串
     * @return String[]    返回类型
     * @throws
     */
    public static String[] split(String str) {
        return StringUtils.split(str);
    }

    /**
     * @Title: split
     * @Description: 分解字符串为数组
     * @param str   待操作字符串
     * @param separator 分解符
     * @return String[]    返回类型
     * @throws
     */
    public static String[] split(String str, String separator) {
        return StringUtils.split(str, separator);
    }

    /**
     * @Title: trim
     * @Description: 去除字符串两端空格
     * @param str   待操作字符串
     * @return String    返回类型
     * @throws
     */
    public static String trim(String str) {
        return StringUtils.trim(str);
    }

    /**
     * @Title: defaultString
     * @Description: 避免返回null值，若str为null返回"".
     * @param str   待操作字符串
     * @return String    返回类型
     * @throws
     */
    public static String defaultString(String str) {
        return StringUtils.defaultString(str);
    }
    
    /**
     * @Title: p    
     * @Description: 全排列
     * @param str   
     * @return String[]   
     * @throws
     * @since 0.2
     */
    public static String[] p(String str) {
        String[] r = { str.substring(0, 1) };
        String[] strs = bindP(r, str.substring(1));

        return strs;
    }
    /**
     * @Title: bindP
     * @Description: 对指定元素和集合进行排列
     * @param r     已排列
     * @param l     未排列
     * @return String[]    
     * @throws
     * @since 0.2
     */
    private static String[] bindP(String[] r, String l) {
        List<String> lst = new ArrayList<String>();
        if (isBlank(l)) {
            return r;
        } else if (l.length() == 1) {
            for (int i = 0; i < r.length; i++) {
                Collections.addAll(lst, insertP(r[i], l.charAt(0)));
            }
        } else if (l.length() > 1) {
            for (int i = 0; i < r.length; i++) {
                String[] strs = bindP(insertP(r[i], l.charAt(0)), l.substring(1));
                Collections.addAll(lst, strs);
            }
        }
        String[] strs = {};
        return lst.toArray(strs);
    }
    /**
     * @Title: insertP
     * @Description: 
     * @param r 
     * @param l 
     * @return String[]    
     * @throws
     * @since 0.2
     */
    private static String[] insertP(String r, char l) {
        String[] strs = new String[r.length() + 1];
        for (int i = 0; i <= r.length(); i++) {
            strs[i] = insert(r, i, l);
        } 
        return strs;
    }
    /**
     * @Title: insert
     * @Description: 字符串中插入字符
     * @param r 
     * @param i 
     * @param l 
     * @return String    返回类型
     * @throws
     * @since 0.2
     */
    public static String insert(String r, int i, char l) {
        return r.substring(0, i) + l + r.substring(i);
    }
    /**
     * @Title: remove
     * @Description: 移出字符串中指定位置的字符
     * @param str   
     * @param i 
     * @return String    返回类型
     * @throws
     * @since 0.2
     */
    public static String remove(String str, int i) {
        return str.substring(0, i) + str.substring(i + 1);
    }
    
    /**
     * @Title: toArray
     * @Description:    字符串按字符转换为数组
     * @param str   
     * @return Object[]    返回类型
     * @throws
     * @since 0.2
     */
    public static String[] toArray(String str) {
        if (isBlank(str)) {
            return null;
        }
        String[] strs = new String[str.length()];
        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(str.charAt(i));
        }
        
        return strs;
    }
    
    /**
     * @Title: containsAny
     * @Description: 判断字符串中是否包含字符数组中的字符
     * @param str   字符串
     * @param arr   字符数组
     * @return boolean    
     * @throws
     */
    
    public static boolean containsAny(String str, char[] arr) {
        return StringUtils.containsAny(str, arr);
    }
    /**
     * 判断手机号
     */
    public static boolean isMobileNO(String mobiles){     
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");     
        Matcher m = p.matcher(mobiles);     
        return m.matches();     
    } 
    /**
     * 判断邮箱
     */
    public static boolean isEmail(String email){     
     String str="^([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)*@([a-zA-Z0-9]*[-_]?[a-zA-Z0-9]+)+[\\.][A-Za-z]{2,3}([\\.][A-Za-z]{2})?$";
        Pattern p = Pattern.compile(str);     
        Matcher m = p.matcher(email);     
        return m.matches();     
    } 
    /**
     * 判断身份证
     */
    public static boolean isId(String Id){
    	 String str="^\\d{15}$|^\\d{17}(?:\\d|x|X)$";
    	 Pattern p = Pattern.compile(str);  
    	   Matcher m = p.matcher(Id);     
		return m.matches(); 
    }
    /**
     * 判断固定电话
     */
    public static boolean isTelephone(String telephone){
    	String str = "(\\(\\d{3,4}\\)|\\d{3,4}-|\\s)?\\d{8}";
    	Pattern p = Pattern.compile(str);     
        Matcher m = p.matcher(telephone);   
    	return m.matches();    
    }
    public static List<String> StringToList(String hpzl){
    	List<String> listHpzl=new ArrayList<String>();
    	String[] hpzls=hpzl.split(",");
    	for(String b : hpzls){
    		listHpzl.add(b);
    	}
    	return listHpzl;
    }
    /**
     * @Title: encode
     * @Description: 对字符串中的中文进行编码
     * @param str   待编码字符串
     * @param enc   encode
     * @return String    返回类型
     * @throws UnsupportedEncodingException 不支持的编码异常
     * @throws
     */
    public static String encode(final String str, final String enc)
        throws UnsupportedEncodingException {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, URLEncoder.encode(m.group(), enc));
        }
        m.appendTail(sb);
        return sb.toString();
    }
    /**
     * @Title: getType
     * @Description: 报警服务器端给发送的message 中 找出 type 类型
     * @param String message
     * @return String    返回类型
     * @throws
     */
    public static String getType(String message){
		String type =null;
    	if(message != null && !message.equals("")){
			int start = (message.indexOf("\"type\":\""));
			int end = (message.indexOf("}"));
			type = (String) (message.subSequence(start, end));
			if(type != null && !type.equals("")){
			type = type.substring("\"type\":\"".length(),type.length()-1 );
			}
		}
    	return type;
    }
    
    /**
     * @Title: getType
     * @Description: 报警服务器端给发送的message 中 找出 type 类型
     * @param String message
     * @return String    返回类型
     * @throws
     */
    public static String getKeyValue(String message,String key){
		String value =null;
    	if(message != null && !message.equals("")){
    		
    		String[] sep =  message.split("\""+key+"\":");
    		if(sep.length >1){
    			String s = sep[1];
    			value=s.substring(0, s.indexOf(",")).trim();
    		}
    	}
    	return value;
    }
    
    /**
     * 15位身份证号码转18位
     * @param personIDCode
     * @return
     */
    public static String idCard15To18(String personIDCode){
        if ((personIDCode == null) || (personIDCode.trim().length() != 15)) {
          return personIDCode;
        }
        String id17 = personIDCode.substring(0, 6) + "19" + personIDCode.substring(6, 15);

        char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
        int[] factor = { 0, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 };
        int[] idcd = new int[18];

        for (int i = 1; i < 18; i++)
        {
          int j = 17 - i;
          idcd[i] = Integer.parseInt(id17.substring(j, j + 1));
        }

        int sum = 0;
        for (int i = 1; i < 18; i++)
        {
          sum += idcd[i] * factor[i];
        }
        int remainder = sum % 11;
        String lastCheckBit = String.valueOf(code[remainder]);
        return id17 + lastCheckBit;
    }
    
    /**
     * subStr 截取定长字符串
     * @param str
     * @param num
     * @param enc 
     * @return
     * @throws Exception
     */
    public static String subStrb(String str,int num, String enc)throws Exception{
        int changdu = str.getBytes(enc).length;
        if(changdu > num){
        	str = str.substring(0, str.length() - 1);
        	str = subStrb(str,num,enc);
        }
        return str;
    }
}