package com.kingshuk.spring.aspectpractice.serialization;

import java.io.IOException;

import javax.money.MonetaryAmount;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MonetaryAmountSerialization extends StdSerializer<MonetaryAmount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -961913440269385507L;

	protected MonetaryAmountSerialization(Class<MonetaryAmount> t) {
		super(t);
	}

	@SuppressWarnings("unused")
	private MonetaryAmountSerialization() {
		this(null);
	}

	@Override
	public void serialize(MonetaryAmount value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
		gen.writeStartObject();
		gen.writeStringField("amount", String.valueOf(value.getNumber().doubleValue()));
		gen.writeObjectFieldStart("currency");
		gen.writeStringField("currencyCode", String.valueOf(value.getCurrency().getCurrencyCode()));
		gen.writeStringField("numericCode", String.valueOf(value.getCurrency().getNumericCode()));
		gen.writeEndObject();
		gen.writeEndObject();
	}

}
