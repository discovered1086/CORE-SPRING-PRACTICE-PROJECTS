package com.kingshuk.spring.aspectpractice.serialization;

import java.io.IOException;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MonetaryAmountDeSerialization extends StdDeserializer<MonetaryAmount> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1430763330127392890L;

	protected MonetaryAmountDeSerialization(Class<?> vc) {
		super(vc);
	}

	@SuppressWarnings("unused")
	private MonetaryAmountDeSerialization() {
		this(null);
	}

	@Override
	public MonetaryAmount deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
		JsonNode node = p.getCodec().readTree(p);

		double amount = 0.00;

		if (node.get("amount") != null) {
			amount = node.get("amount").asDouble();
		}

		CurrencyUnit currencyUnit = Monetary.getCurrency("USD");

		if (node.get("currency") != null) {
			JsonNode jsonNode = node.get("currency");

			if (jsonNode.get("currencyCode") != null) {
				Monetary.getCurrency(jsonNode.get("currencyCode").asText());
			}

		}

		return Monetary.getDefaultAmountFactory().setNumber(amount).setCurrency(currencyUnit).create();
	}

}
