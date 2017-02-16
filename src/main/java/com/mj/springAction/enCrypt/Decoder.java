package com.mj.springAction.enCrypt;

public abstract interface Decoder {
	 public abstract Object decode(Object paramObject)
			    throws DecoderException;
}
