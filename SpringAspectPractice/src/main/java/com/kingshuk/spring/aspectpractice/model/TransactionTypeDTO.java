package com.kingshuk.spring.aspectpractice.model;

import java.io.Serializable;
import java.time.LocalTime;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.kingshuk.spring.aspectpractice.enums.TransactionTypeEnum;
import com.kingshuk.spring.aspectpractice.serialization.DateTimeDeSerializer;
import com.kingshuk.spring.aspectpractice.serialization.DateTimeSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "transactionType")
public class TransactionTypeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3478300589711095031L;

	@JsonProperty(required = true, value = "transactionTypeCode")
	private String transactionTypeCode;

	@JsonProperty(required = true, value = "typeOfTransaction")
	private TransactionTypeEnum typeOfTransaction;

	@JsonProperty(required = true, value = "transactionTypeDefinition")
	private String transactionTypeDefinition;

	@JsonProperty(required = true, value = "transactionTypeEffectiveDate")
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	private ZonedDateTime transactionTypeEffectiveDate;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@JsonProperty(required = false, value = "transactionTypeTerminationDate")
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	private ZonedDateTime transactionTypeTerminationDate;

	public static class TransactionTypeDTOBuilder {

		public TransactionTypeDTOBuilder transactionTypeEffectiveDate(ZonedDateTime transactionTypeEffectiveDate) {
			this.transactionTypeEffectiveDate = transactionTypeEffectiveDate.with(LocalTime.of(00, 00, 00));

			return this;
		}

		public TransactionTypeDTOBuilder transactionTypeTerminationDate(ZonedDateTime transactionTypeTerminationDate) {
			this.transactionTypeTerminationDate = transactionTypeTerminationDate.with(LocalTime.of(00, 00, 00));

			return this;
		}
	}

}
