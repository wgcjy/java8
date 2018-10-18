package secret;//package secret;
//
//
//import com.sun.xml.internal.messaging.saaj.util.Base64;
//
//import javax.crypto.Cipher;
//import javax.crypto.spec.IvParameterSpec;
//import javax.crypto.spec.SecretKeySpec;
//import java.security.MessageDigest;
//
//public class AESUtils {
//
//	public static final byte[] KEY = { (byte) 175, 82, (byte) 222, 69, 15, 88, (byte) 205, 16, 35, (byte) 139, 69, 106, 16,
//			(byte) 144, (byte) 175, (byte) 189, (byte) 173, (byte) 219, (byte) 174, (byte) 141, (byte) 172, (byte) 128,
//			82, (byte) 255, 69, (byte) 144, (byte) 133, (byte) 202, (byte) 203, (byte) 159, (byte) 175, (byte) 189 };
//	public final static byte[] IV = { 2, (byte) 175, (byte) 188, (byte) 171, (byte) 204, (byte) 144, 57, (byte) 144,
//			(byte) 188, (byte) 175, (byte) 134, (byte) 153, (byte) 173, (byte) 170, (byte) 251, 96 };
//
//
//	public static final byte[] KEY2 = new byte[] { (byte) 175, 82, (byte) 222, 69, 15, 88, (byte) 205, 16, 35, (byte) 139, 69,
//			106, 16, (byte) 144, (byte) 175, (byte) 189 };
//	public static final byte[] IV2 = new byte[] { 2, (byte) 175, (byte) 188, (byte) 171, (byte) 204, (byte) 144, 57,
//			(byte) 144, (byte) 188, (byte) 175, (byte) 134, (byte) 153, (byte) 173, (byte) 170, (byte) 251, 96 };
//
//	/**
//	 * 提供密钥和向量进行加密
//	 *
//	 * @param sSrc
//	 * @param key
//	 * @param iv
//	 * @return
//	 * @throws Exception
//	 */
//	public static String Encrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
//		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
//		IvParameterSpec _iv = new IvParameterSpec(iv);// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
//		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, _iv);
//		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
//		return Base64.encodeBase64String(encrypted);
//	}
//
//	/**
//	 * 提供密钥和向量进行解密
//	 *
//	 * @param sSrc
//	 * @param key
//	 * @param iv
//	 * @return
//	 * @throws Exception
//	 */
//	public static String Decrypt(String sSrc, byte[] key, byte[] iv) throws Exception {
//		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//		IvParameterSpec _iv = new IvParameterSpec(iv);
//		cipher.init(Cipher.DECRYPT_MODE, skeySpec, _iv);
//		byte[] encrypted = Base64.decodeBase64(sSrc);
//		byte[] original = cipher.doFinal(encrypted);
//		return new String(original, "utf-8");
//	}
//
//	/**
//	 * 使用密钥进行加密
//	 *
//	 * @param sSrc
//	 * @param keyStr
//	 * @return
//	 * @throws Exception
//	 */
//	public static String Encrypt(String sSrc, String keyStr) throws Exception {
//		byte[] key = GeneralKey(keyStr);
//		byte[] iv = GeneralIv(keyStr);
//		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
//		IvParameterSpec _iv = new IvParameterSpec(iv);
//		cipher.init(Cipher.ENCRYPT_MODE, skeySpec, _iv);
//		byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
//		return Base64.encodeBase64String(encrypted);
//	}
//
//	/**
//	 * 使用密钥进行解密
//	 *
//	 * @param sSrc
//	 * @param keyStr
//	 * @return
//	 * @throws Exception
//	 */
//	public static String Decrypt(String sSrc, String keyStr) throws Exception {
//		byte[] key = GeneralKey(keyStr);
//		byte[] iv = GeneralIv(keyStr);
//		SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
//		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
//		IvParameterSpec _iv = new IvParameterSpec(iv);
//		cipher.init(Cipher.DECRYPT_MODE, skeySpec, _iv);
//		byte[] encrypted = Base64.decodeBase64(sSrc);// 先用base64解码
//		byte[] original = cipher.doFinal(encrypted);
//		return new String(original, "utf-8");
//	}
//
//	/**
//	 * 构建密钥字节码
//	 *
//	 * @param keyStr
//	 * @return
//	 * @throws Exception
//	 */
//	private static byte[] GeneralKey(String keyStr) throws Exception {
//		byte[] bytes = keyStr.getBytes("utf-8");
//		MessageDigest md = MessageDigest.getInstance("SHA-256");
//		md.update(bytes);
//		return md.digest();
//	}
//
//
//
//	/**
//	 * 构建加解密向量字节码
//	 *
//	 * @param keyStr
//	 * @return
//	 * @throws Exception
//	 */
//	private static byte[] GeneralIv(String keyStr) throws Exception {
//		byte[] bytes = keyStr.getBytes("utf-8");
//		MessageDigest md = MessageDigest.getInstance("MD5");
//		md.update(bytes);
//		return md.digest();
//	}
//
////	public static void main(String[] args) {
////		byte[] key = { (byte) 175, 82, (byte) 222, 69, 15, 88, (byte) 205, 16, 35, (byte) 139, 69, 106, 16, (byte) 144,
////				(byte) 175, (byte) 189, (byte) 173, (byte) 219, (byte) 174, (byte) 141, (byte) 172, (byte) 128, 82,
////				(byte) 255, 69, (byte) 144, (byte) 133, (byte) 202, (byte) 203, (byte) 159, (byte) 175, (byte) 189 };
////		byte[] iv = { 2, (byte) 175, (byte) 188, (byte) 171, (byte) 204, (byte) 144, 57, (byte) 144, (byte) 188,
////				(byte) 175, (byte) 134, (byte) 153, (byte) 173, (byte) 170, (byte) 251, 96 };
////		String sSrc = "Pmx3Mvwfs1F3ZGPuSdj+IEF684fP1hqXnXtAni5FwX1dseYXHvuO7M1fNBMQYhyMIJqM5aI1LiQeZRrwmLh9cQaCMQVk7YgTvkK/CQa7amQdyoaj7AXecXFUTVY5wRtQrmXWyVaNDqcz7xMMY7QRew==";
////		String a = "";
////		try {
////			a = AESUtils.Decrypt(sSrc, key, iv);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		logger.info(a);
////	}
//}
