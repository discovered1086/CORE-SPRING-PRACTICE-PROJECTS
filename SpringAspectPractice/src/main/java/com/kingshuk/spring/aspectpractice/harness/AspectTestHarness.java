package com.kingshuk.spring.aspectpractice.harness;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kingshuk.spring.aspectpractice.config.BasicAspectConfiguration;
import com.kingshuk.spring.aspectpractice.enums.TransactionTypeEnum;
import com.kingshuk.spring.aspectpractice.model.CategoryDTO;
import com.kingshuk.spring.aspectpractice.model.SubCategoryDTO;

public class AspectTestHarness {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(
				BasicAspectConfiguration.class);

		ZonedDateTime effectiveDate = ZonedDateTime.parse("2019-11-25T00:00:00+05:30",
				DateTimeFormatter.ISO_OFFSET_DATE_TIME);

		SubCategoryDTO subCategoryReferenceDTO = SubCategoryDTO.builder().subCategoryId("SBCTGRY1")
				.subCategoryDescription("Credit card bill payment").subCategoryName("Credit card bill payment")
				.subCategoryEffectiveDate(effectiveDate).build();

		Set<SubCategoryDTO> subCategoryDTOs = new HashSet<>();
		subCategoryDTOs.add(subCategoryReferenceDTO);

		CategoryDTO categoryReferenceDTO = CategoryDTO.builder().categoryId("CTGRY12")
				.categoryDescription("Bill Payment for various types of bills").categoryName("Bill Payment")
				.categoryEffectiveDate(ZonedDateTime.now()).categoryTransactionType(TransactionTypeEnum.EXPENSE)
				.subCategories(subCategoryDTOs).build();

		System.out.println(categoryReferenceDTO.getCategoryEffectiveDate());

		annotationConfigApplicationContext.close();
	}
}
