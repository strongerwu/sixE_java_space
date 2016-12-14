package com.shserver.base.utils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import com.alibaba.dubbo.container.Main;

public class SignUtil {
	public static final String MD5_KEY = "D41D8CD98F00B204E9800998ECF8427E";
	
	public static String cryptMd5(String source) {
//	    try {
//            source = new String(source.getBytes("UTF-8"),"GBK");
//        } catch (UnsupportedEncodingException e1) {
//            e1.printStackTrace();
//        }
		String s = null;
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");

			md.update(source.getBytes());
			byte[] tmp = md.digest();

			char[] str = new char[32];

			int k = 0;
			for (int i = 0; i < 16; ++i) {
				byte byte0 = tmp[i];
				str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];

				str[(k++)] = hexDigits[(byte0 & 0xF)];
			}
			s = new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public static String cryptMd5(String source, String key) {
		byte[] keyb;
		byte[] value;
		byte[] k_ipad = new byte[64];
		byte[] k_opad = new byte[64];
		try {
			keyb = key.getBytes("UTF-8");
			value = source.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			keyb = key.getBytes();
			value = source.getBytes();
		}
		Arrays.fill(k_ipad, keyb.length, 64, new Integer(54).byteValue());
		Arrays.fill(k_opad, keyb.length, 64, new Integer(92).byteValue());
		for (int i = 0; i < keyb.length; ++i) {
			k_ipad[i] = (byte) (keyb[i] ^ 0x36);
			k_opad[i] = (byte) (keyb[i] ^ 0x5C);
		}
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
		md.update(k_ipad);
		md.update(value);
		byte[] dg = md.digest();
		md.reset();
		md.update(k_opad);
		md.update(dg, 0, 16);
		dg = md.digest();
		return toHex(dg);
	}

	public static String toHex(byte[] input) {
		if (input == null)
			return null;

		StringBuffer output = new StringBuffer(input.length * 2);
		for (int i = 0; i < input.length; ++i) {
			int current = input[i] & 0xFF;
			if (current < 16)
				output.append("0");
			output.append(Integer.toString(current, 16));
		}

		return output.toString();
	}
  
	public static synchronized  boolean  getSign(Object obj){
		Class c=obj.getClass(); //获取当前类
		Class father=c.getSuperclass();//获取当前类的父类
		// Field[] fs = c.getDeclaredFields (); //获取当前类中的所有属性
		 StringBuffer buffer = new StringBuffer();
		 String sign="";
		  Field[] fr =father.getDeclaredFields(); //获取父类中所有属性
		  for ( int i = 0 ; i < fr. length ; i++){
			   Field f = fr[i];
	           f.setAccessible( true ); // 设置些属性是可以访问的
	           Object val;
			try {
				 if(f.getName().equals("loginPhone")||f.getName().equals("reqTime")){
					 val = f.get(obj);
					// System. out .println( "name:" +f.getName()+ "/t value = " +val);
					 buffer.append(val);
				 }
				 if(f.getName().equals("sign")){
				
					 sign = (String) f.get(obj);
					 System.out.println("签名："+sign);
				 }
		       /*    String type = f.getType().toString(); // 得到此属性的类型 
		           if (type.endsWith( "String" )) {
		               System. out .println(f.getType()+ "/t 是 String" );
		               f.set(obj, "12" ) ;        // 给属性设值
		            } else if (type.endsWith( "int" ) || type.endsWith( "Integer" )){
		               System. out .println(f.getType()+ "/t 是 int" );
		               f.set(obj,12) ;       // 给属性设值
		            } else {
		               System. out .println(f.getType()+ "/t" );
		            } */
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // 得到此属性的值    
	          
		  }
		  System.out.println("参与签名的数据："+buffer);
		  //对参数进行签名校验
		  System.out.println("校验签名："+cryptMd5(buffer.toString())); 
		  if(cryptMd5(buffer.toString()).equals(sign)){
			  return true;
		  }else{
			  return false;
		  }
	}
	public static void main(String[] args) {
		System.out.println(SignUtil.cryptMd5("Lfi@9f"));
	}
}
