package com.mj.springAction.enCrypt;

import java.io.PrintStream;
import javax.crypto.spec.IvParameterSpec;

public class BlowfishCrypts
{
  private static final String CIPHER_KEY = "tg12ky31vf";
  private static final String KEY_SPEC_NAME = "Blowfish";
  private static final String CIPHER_NAME = "Blowfish/CFB8/NoPadding";
  private static final String ENCODING_STRING_TO_BYTE = "UTF-8";
  
  public static String decrypt(String cryptWord) throws Exception
  {
    if (cryptWord == null) {
      return null;
    }
    
    javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec("tg12ky31vf".getBytes("UTF-8"), "Blowfish");
    
    IvParameterSpec ivParameterSpec = new IvParameterSpec(DigestUtils.md5Hex("tg12ky31vf").substring(0, 8).getBytes("UTF-8"));
    
    try
    {
      javax.crypto.Cipher deCipher = javax.crypto.Cipher.getInstance("Blowfish/CFB8/NoPadding");
      deCipher.init(2, secretKeySpec, ivParameterSpec);
      byte[] dec = Base64s.decodeBase64(cryptWord.getBytes("UTF-8"));
      
      return new String(deCipher.doFinal(dec));
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
  
  public static String encrypt(String plainWord) throws Exception {
    if (plainWord == null) {
      return plainWord;
    }
    
    javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec("tg21ky31vf".getBytes("UTF-8"), "Blowfish");
    
    IvParameterSpec ivParameterSpec = new IvParameterSpec(DigestUtils.md5Hex("tg21ky31vf").substring(0, 8).getBytes("UTF-8"));
    try
    {
      javax.crypto.Cipher enCipher = javax.crypto.Cipher.getInstance("Blowfish/CFB8/NoPadding");
      enCipher.init(1, secretKeySpec, ivParameterSpec);
      byte[] utf8 = plainWord.getBytes("UTF-8");
      byte[] enc = enCipher.doFinal(utf8);
      return new String(Base64s.encodeBase64(enc));
    }
    catch (Exception e) {
      e.printStackTrace();
      throw e;
    }
  }
  
  public static void main(String[] args) throws Exception {
/*    if (args.length < 1) {
      System.out.println("need input password! please try again");
      return;
    }*/
    System.out.println("after encrypt:" + encrypt("filer_admin"));
  }
}
