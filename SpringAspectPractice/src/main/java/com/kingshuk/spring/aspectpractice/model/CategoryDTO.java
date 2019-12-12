package com.kingshuk.spring.aspectpractice.model;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

@Builder
/**
 * @param categoryEffectiveDate
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonRootName(value = "transactionCategory")
public class CategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7223290830168812286L;

	@JsonProperty(required = true, value = "categoryId")
	private String categoryId;

	@JsonProperty(required = true, value = "categoryName")
	private String categoryName;

	@JsonProperty(required = false, value = "categoryDescription")
	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	private String categoryDescription;

	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = true, value = "categoryEffectiveDate")
	private ZonedDateTime categoryEffectiveDate;

	@JsonInclude(value = JsonInclude.Include.NON_NULL)
	@JsonSerialize(using = DateTimeSerializer.class)
	@JsonDeserialize(using = DateTimeDeSerializer.class)
	@JsonProperty(required = false, value = "categoryTerminationDate")
	private ZonedDateTime categoryTerminationDate;

	@JsonProperty(required = false, value = "transactionType")
	private TransactionTypeEnum categoryTransactionType;

	@JsonInclude(value = JsonInclude.Include.NON_EMPTY, content = JsonInclude.Include.NON_NULL)
	private Set<SubCategoryDTO> subCategories;

//	public static class CategoryDTOBuilder {
//
//		public CategoryDTOBuilder categoryEffectiveDate(ZonedDateTime categoryEffectiveDate) {
//			this.categoryEffectiveDate = categoryEffectiveDate.with(LocalTime.of(00, 00, 00));
//
//			return this;
//		}
//
//		public CategoryDTOBuilder categoryTerminationDate(ZonedDateTime categoryTerminationDate) {
//			this.categoryTerminationDate = categoryTerminationDate.with(LocalTime.of(00, 00, 00));
//
//			return this;
//		}
//	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder().append(categoryId).append(categoryName).append(categoryDescription)
				.append(categoryEffectiveDate).append(categoryTerminationDate).append(categoryTransactionType)
				.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CategoryDTO) {
			final CategoryDTO categoryEntity = (CategoryDTO) obj;

			boolean categoryEquality = new EqualsBuilder()
					.append(this.categoryName.trim().toUpperCase(), categoryEntity.categoryName.trim().toUpperCase())
					.isEquals() && Objects.deepEquals(this.subCategories, categoryEntity.subCategories);

			return (((Objects.nonNull(this.categoryId) && Objects.nonNull(categoryId))
					&& this.categoryId.equals(categoryEntity.categoryId)) || categoryEquality);

		} else {
			return false;
		}
	}
}
