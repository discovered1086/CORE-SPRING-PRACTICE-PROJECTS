package com.kingshuk.spring.aspectpractice.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.kingshuk.spring.aspectpractice.enums.ApplicationStatusType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
@JsonRootName("applicationStatus")
public class ApplicationStatusDTO implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 995642617560236207L;

	private String statusCode;

	@JsonIgnore
	private String httpStatusCode;

	private ApplicationStatusType typeOfStatus;

	private String statusDefinition;

	private String statusMessage;

	@JsonIgnore
	private ZonedDateTime statusTypeEffectiveDate;

	@JsonIgnore
	private ZonedDateTime statusTypeTerminationDate;

}
