package com.mj.springAction.enCrypt;

public abstract interface BinaryDecoder extends Decoder
{
	  public abstract byte[] decode(byte[] paramArrayOfByte)
	    throws DecoderException;
	}