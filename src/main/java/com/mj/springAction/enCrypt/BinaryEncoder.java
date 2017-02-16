package com.mj.springAction.enCrypt;

public  abstract interface BinaryEncoder extends Encoder
{
public abstract byte[] encode(byte[] paramArrayOfByte)
  throws EncoderException;
}
