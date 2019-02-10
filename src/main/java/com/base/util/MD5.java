package com.base.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author 黄润宣
 * @version 创建时间：2018年3月16日 下午11:25:14 
 * 类说明	MD5算法加密解密
 */
public class MD5 {
	/**
	 * 采用MD5加密
	 */
	public static String string2MD5(String inStr) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// 获取MD5 加密对象,还可以获取SHA加密对象
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		// 将输入的信息使用指定的编码方式获取字节
		byte[] bytes = inStr.getBytes("UTF-8");
		// 使用md5 类来获取摘要，也就是加密后的字节
		md5.update(bytes);
		byte[] md5encode = md5.digest();
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < md5encode.length; i++) {
			// 使用&0xff 不足24高位，因为只占了8低位
			int val = ((int) md5encode[i]) & 0xff;
			if (val < 16) {
				buffer.append("0");
			}
			// 以十六进制（基数 16）无符号整数形式返回一个整数参数的字符串表示形式。
			buffer.append(Integer.toHexString(val));
		}
		return buffer.toString();
	}

	 /** 
     * 加密解密算法 执行一次加密，执行两次解密 
     */   

	public static String convertMD5(String inStr) {

		char[] a = inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] ^ 't');
		}
		String s = new String(a);
		return s;

	}
}
