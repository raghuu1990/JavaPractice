/* Copyright 2016 Yatra.com */
package com.file;

import com.yatra.express.cards.service.v3.*;
import com.yatra.express.service.v3.impl.ExpressCheckoutServiceImplService;
import org.apache.geronimo.mail.util.Base64Encoder;
import org.apache.geronimo.mail.util.StringBufferOutputStream;

import javax.crypto.Cipher;
import java.io.*;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.List;

public class QuickBookUtils {

	private final static String ALGORITHM = "RSA";
	private final static String CHARSET = "UTF-8";
	private final static String AppName = "PaymentPortal";
	private final static Long TenantId = 12l;
	private final static String SSOToken = "a3a6e20a-f0a4-4515-93ce-2a8ff249f682";
	// dfbda2e0-e5e5-44e4-ba28-b5071dbde87a
	private final static PrivateKey privatekey;
	private final static PublicKey publickey;
	public static final String PATH = "home/krishanr/workspace/TestJavaBasics/src/com/file/";
	private final static String PRIVATE_KEY_FILE_NAME = PATH + "PaymentPortalPrivate.key";
	private final static String PUBLIC_KEY_FILE_NAME = PATH + "ExpressCardsPublic.key";

	static {
		privatekey = readPrivateKeyFromFile();
		publickey = readPublicKeyFromFile();
	}

	public static void saveCard() {
		UserCardInfo cardInfo = new UserCardInfo();
		cardInfo.setCardName("TGTechTeamTestCard");
		cardInfo.setCardNumber1("4111");
		cardInfo.setCardNumber2("1111");
		cardInfo.setCardNumber3("1111");
		cardInfo.setCardNumber4("1111");
		cardInfo.setExpiryMonth("09");
		cardInfo.setExpiryYear("2016");
		cardInfo.setTitle("Mr");
		cardInfo.setFirstName("Test");
		cardInfo.setLastname("Card");
		cardInfo.setCardAccessType("INT");
		cardInfo.setCardBrand("VISA");
		cardInfo.setCardType("CREDIT");

		AdaptedProperties cardProperties = new AdaptedProperties();
		Property address1 = new Property();
		address1.setKey("address1");
		address1.setValue("Home");
		cardProperties.getEntry().add(address1);

		Property address2 = new Property();
		address2.setKey("address2");
		address2.setValue("Street");
		cardProperties.getEntry().add(address2);

		Property city = new Property();
		city.setKey("city");
		city.setValue("MyCity");
		cardProperties.getEntry().add(city);

		Property state = new Property();
		state.setKey("state");
		state.setValue("MyState");
		cardProperties.getEntry().add(state);

		Property country = new Property();
		country.setKey("country");
		country.setValue("MyCountry");
		cardProperties.getEntry().add(country);

		Property isdcode = new Property();
		isdcode.setKey("isdCode");
		isdcode.setValue("+879");
		cardProperties.getEntry().add(isdcode);

		Property pincode = new Property();
		pincode.setKey("pincode");
		pincode.setValue("123456");
		cardProperties.getEntry().add(pincode);

		Property mobileNumber = new Property();
		mobileNumber.setKey("mobileNumber");
		mobileNumber.setValue("9999999999");
		cardProperties.getEntry().add(mobileNumber);
		cardInfo.setCardProperties(cardProperties);
		cardInfo = getEncryptedCardInfo(cardInfo);
		ResponseStatus response = new ExpressCheckoutServiceImplService().getExpressCheckoutServiceImplPort()
				.addCard(TenantId, SSOToken, cardInfo);
	}

	public static void getCardByID(String CardId) {
		UserCardInfoResponse cardDetails = new ExpressCheckoutServiceImplService().getExpressCheckoutServiceImplPort()
				.getCardForPayment(AppName, SSOToken, CardId);
		if (cardDetails != null && cardDetails.getCardInfo() != null) {
			UserCardInfo cardInfo = cardDetails.getCardInfo();
			cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber1()));
			cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber2()));
			cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber3()));
			cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber4()));
			cardInfo.setExpiryMonth(rsaDecrypt(cardInfo.getExpiryMonth()));
			cardInfo.setExpiryYear(rsaDecrypt(cardInfo.getExpiryYear()));
			String cardType = cardInfo.getCardBrand();
		}
	}

	public static void getCards() {
		String SSOToken = "cf5bd456-013b-4af3-b945-544c57772acc";
		Long tenantId = 12l;
		List<UserCardInfo> cardInfoList = null;
		UserCardsDisplayResponse response = new ExpressCheckoutServiceImplService().getExpressCheckoutServiceImplPort()
				.getCardsForDisplay(tenantId, SSOToken);
		if (response.getResponse().getStatus().equalsIgnoreCase("SUCCESS")) {
			cardInfoList = response.getCardInfo();
			for (UserCardInfo cardInfo : cardInfoList) {
				cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber1()));
				cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber2()));
				cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber3()));
				cardInfo.setCardNumber1(rsaDecrypt(cardInfo.getCardNumber4()));
				cardInfo.setExpiryMonth(rsaDecrypt(cardInfo.getExpiryMonth()));
				cardInfo.setExpiryYear(rsaDecrypt(cardInfo.getExpiryYear()));
				String cardType = cardInfo.getCardBrand();
			}
		}
	}

	public static void deleteCard() {
		String SSOToken = "a3a6e20a-f0a4-4515-93ce-2a8ff249f682";
		String cardId = "fjfgkg";
		cardId = "8433a372-e48f-4494-95e5-01de9944b34e";
		Long tenantId = 12l;
		ResponseStatus response = new ExpressCheckoutServiceImplService().getExpressCheckoutServiceImplPort()
				.removeCard(tenantId, SSOToken, cardId);
	}

	public static void main(String[] args) {
		// savecard();
		getCards();
	}

	private static PrivateKey readPrivateKeyFromFile() {
	    //InputStream is = QuickBookUtils.class.getClassLoader().getResourceAsStream(PRIVATE_KEY_FILE_NAME);
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream(PRIVATE_KEY_FILE_NAME);
		ObjectInputStream oin = null;
		try {
			oin = new ObjectInputStream(new BufferedInputStream(is));
			BigInteger m = (BigInteger) oin.readObject();
			BigInteger e = (BigInteger) oin.readObject();
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(m, e);
			KeyFactory fact = KeyFactory.getInstance(ALGORITHM);
			PrivateKey privateKey = fact.generatePrivate(keySpec);
			return privateKey;
		} catch (Exception e) {
			throw new RuntimeException("Exception occurred during readPrivateKeyFromFile");
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
			}
		}
	}

	private static PublicKey readPublicKeyFromFile() {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream(PUBLIC_KEY_FILE_NAME);
		ObjectInputStream oin = null;
		try {
			oin = new ObjectInputStream(new BufferedInputStream(is));
			BigInteger m = (BigInteger) oin.readObject();
			BigInteger e = (BigInteger) oin.readObject();
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(m, e);
			KeyFactory fact = KeyFactory.getInstance(ALGORITHM);
			PublicKey publicKey = fact.generatePublic(keySpec);
			return publicKey;
		} catch (Exception e) {
			throw new RuntimeException("Exception occurred during readPrivateKeyFromFile");
		} finally {
			try {
				oin.close();
			} catch (IOException e) {
			}
		}
	}

	private static UserCardInfo getEncryptedCardInfo(UserCardInfo userCard) {
		if (userCard != null) {
			userCard.setCardNumber1(rsaEncrypt(userCard.getCardNumber1()));
			userCard.setCardNumber2(rsaEncrypt(userCard.getCardNumber2()));
			userCard.setCardNumber3(rsaEncrypt(userCard.getCardNumber3()));
			if (userCard.getCardNumber4() != null)
				userCard.setCardNumber4(rsaEncrypt(userCard.getCardNumber4()));
			userCard.setExpiryMonth(rsaEncrypt(userCard.getExpiryMonth()));
			userCard.setExpiryYear(rsaEncrypt(userCard.getExpiryYear()));
		}
		return userCard;
	}

	public static String rsaEncrypt(String data) {
		if (data == null || data.isEmpty()) {
			return data;
		}
		try {
			byte[] encryptedData = rsaEncrypt(data.getBytes(CHARSET));
			StringBuffer encryptedString = new StringBuffer();
			StringBufferOutputStream sbos = new StringBufferOutputStream(encryptedString);
			new Base64Encoder().encode(encryptedData, 0, encryptedData.length, sbos);
			return encryptedString.toString();
		} catch (Exception e) {
			throw new RuntimeException("Error while encrypting card details");
		}
	}

	private static byte[] rsaEncrypt(byte[] data) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, publickey);
		byte[] cipherData = cipher.doFinal(data);
		return cipherData;
	}

	public static String rsaDecrypt(String data) {
		if (data == null || data.isEmpty()) {
			return data;
		}
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			new Base64Encoder().decode(data, baos);
			byte[] decodedData = baos.toByteArray();
			byte[] decryptedData = rsaDecrypt(decodedData);
			String decryptedString = new String(decryptedData, CHARSET);
			return decryptedString;
		} catch (Exception e) {
			throw new RuntimeException("Error while decrypting card details");
		}
	}

	private static byte[] rsaDecrypt(byte[] data) throws Exception {
		Cipher cipher = Cipher.getInstance(ALGORITHM);
		cipher.init(Cipher.DECRYPT_MODE, privatekey);
		byte[] cipherData = cipher.doFinal(data);
		return cipherData;
	}
}