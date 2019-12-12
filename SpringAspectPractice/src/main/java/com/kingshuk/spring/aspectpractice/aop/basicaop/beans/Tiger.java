package com.kingshuk.spring.aspectpractice.aop.basicaop.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.basicaop.service.PetFoodService;

/**
 * Created by kingshuk on 4/26/17.
 */
@Component   //Practicing the usage of the default Bean ID
public class Tiger implements Pet {
    private PetFoodService petFoodService;

    @Value("${tigerName}")
    private String petName;

    //This is to test what happens when the target bean has more than one
    //constructor. Does that make the @Autowired annotation mandatory? It should.
    public Tiger() {

    }

    //This is an example of constructor injection
    @Autowired  //Autowired is kind of optional post Spring release 4.3 given that the target Bean
    // which is tiger here has only one constructor. however it's a good practice to have it to make the code more readable.
    public Tiger(@Qualifier("walmartPetFoodServiceImpl") PetFoodService petFoodService) {
        System.out.println("Tiger: inside the dependency injection constructor");
        this.petFoodService = petFoodService;
    }

    @Override
    public String makeNoise() {
        return "Roaring....Grrrrrrrrrr";
    }

    @Override
    public String getPetFood() {
        return petFoodService.getTigerFood();
    }

    @Override
    public String getPetName() {
        return this.petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }
}
