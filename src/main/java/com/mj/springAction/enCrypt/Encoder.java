package com.mj.springAction.enCrypt;

public abstract interface Encoder
{
	  public abstract Object encode(Object paramObject)
	    throws EncoderException;
	}
