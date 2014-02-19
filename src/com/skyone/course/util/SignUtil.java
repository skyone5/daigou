package com.skyone.course.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * ����Ч�鹤����
 *
 * @author ybk
 * @date 2014-2-19
 */
public class SignUtil {

	// ��ӿ�������Ϣ�е�tokenҪһ��
	private static String token = "wxdaigo";
	
	/**
	 * ��֤ǩ��
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @return
	 */
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		String[] arr = new String[]{token,timestamp,nonce};
		// ��token��timestamp��nonce�������������ֵ�����
		Arrays.sort(arr);
		StringBuilder content = new StringBuilder(arr.length);
		for(String str : arr){
			content.append(str);
		}
		
		MessageDigest md = null;
		String tmpStr = null;
		
		try {
			md = MessageDigest.getInstance("SHA-1");
			// �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
			byte[] digest = md.digest(content.toString().getBytes());
			tmpStr = byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		content = null;
		// ��sha1���ܺ���ַ�������signature�Աȣ���ʾ��������Դ��΢��
		return tmpStr != null ? tmpStr.equals(signature.toUpperCase()):false;
	}
	
	/**
	 * ���ֽ�����ת��Ϊʮ�������ַ���
	 * @param beteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray){
		if(byteArray == null || byteArray.length == 0)
			return null;
		
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	
	/**
	 * ���ֽ�ת��Ϊʮ�������ַ���
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte){
		 char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };  
	     char[] tempArr = new char[2];
	     tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
	     tempArr[1] = Digit[(mByte & 0X0F)];
	     
	     return new String(tempArr);
	}
	
}
