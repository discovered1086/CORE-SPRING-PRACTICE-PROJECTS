package com.kingshuk.spring.aspectpractice.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import javax.money.CurrencyUnit;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kingshuk.spring.aspectpractice.serialization.CurrencyDeSerialization;
import com.kingshuk.spring.aspectpractice.serialization.CurrencySerialization;
import com.kingshuk.spring.aspectpractice.serialization.DateTimeDeSerializer;
import com.kingshuk.spring.aspectpractice.serialization.DateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "accountId")
@JsonRootName(value = "customerAccount")
public class AccountDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1540097108451574865L;

	@JsonProperty(required = true, value = "accountId")
	private String accountId;

	@JsonProperty(required = true, value = "accountNumber")
	private String accountNumber;

	@JsonProperty(required = true, value = "currency")
	@JsonSerialize(using = CurrencySerialization.class)
	@JsonDeserialize(using = CurrencyDeSerialization.class)
	private CurrencyUnit currency;

	@JsonProperty(required = true, value = "accountDescription")
	private String accountDescription;


	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = true, value = "accountOpenningDate")
	private ZonedDateTime accountOpenningDate;


	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = false, value = "accountClosingDate")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private ZonedDateTime accountClosingDate;

}
