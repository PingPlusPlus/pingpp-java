package example;

import java.io.FileInputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by sunkai on 15/5/19. webhooks 验证签名示例
 * 
 * 该实例演示如何对 ping++ webhooks 通知进行验证。
 * 验证是为了让开发者确认该通知来自 ping++ ，防止恶意伪造通知。用户如果有别的验证机制，可以不进行验证签名。
 * 
 * 验证签名需要 签名、公钥、验证信息，该实例采用文件存储方式进行演示。
 * 实际项目中，需要用户从异步通知的 HTTP header 中读取签名，从 HTTP body 中读取验证信息。公钥的存储方式也需要用户自行设定。
 * 
 *  该实例仅供演示如何验证签名，请务必不要直接 copy 到实际项目中使用。
 * 
 */
public class WebHooksVerifyExample {
	private static String filePath = "src/my-server.pub";
	private static String eventPath = "src/charge";
	private static String signPath = "src/sign";

	/**
	 * 验证webhooks 签名，仅供参考
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		boolean result = verifyData(getByteFromFile(eventPath, false), getByteFromFile(signPath, true), getPubKey());
		System.out.println("验签结果："+result);
	}

	/**
	 * 读取文件,部署web程序的时候，签名和验签内容需要从request中获得
	 * @param file
	 * @param base64
	 * @return
	 * @throws Exception
	 */
	public static byte[] getByteFromFile(String file, boolean base64) throws Exception {
		FileInputStream in = new FileInputStream(file);
		byte[] fileBytes = new byte[in.available()];
		in.read(fileBytes);
		in.close();
		String pubKey = new String(fileBytes, "UTF-8");
		if (base64) {
			fileBytes = Base64.decodeBase64(pubKey);
		}
		return fileBytes;
	}

	/**
	 * 获得公钥
	 * @return
	 * @throws Exception
	 */
	public static PublicKey getPubKey() throws Exception {
		// read key bytes
		FileInputStream in = new FileInputStream(filePath);
		byte[] keyBytes = new byte[in.available()];
		in.read(keyBytes);
		in.close();

		String pubKey = new String(keyBytes, "UTF-8");
		pubKey = pubKey.replaceAll("(-+BEGIN PUBLIC KEY-+\\r?\\n|-+END PUBLIC KEY-+\\r?\\n?)", "");

		keyBytes = Base64.decodeBase64(pubKey);

		// generate public key
		X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(spec);
		return publicKey;
	}

	/**
	 * 验证签名
	 * @param data
	 * @param sigBytes
	 * @param publicKey
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws SignatureException
	 */
	public static boolean verifyData(byte[] data, byte[] sigBytes, PublicKey publicKey) throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initVerify(publicKey);
		signature.update(data);
		return signature.verify(sigBytes);
	}

}
