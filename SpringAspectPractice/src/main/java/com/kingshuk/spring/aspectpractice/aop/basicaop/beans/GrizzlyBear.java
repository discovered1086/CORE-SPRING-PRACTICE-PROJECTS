package com.kingshuk.spring.aspectpractice.aop.basicaop.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.basicaop.service.PetFoodService;

/**
 * Created by kingshuk on 4/29/17.
 */
@Component("MyBear")
@Scope("prototype")
public class GrizzlyBear implements Pet {

    @Value("${bear1Name}")
    private String petName;

    //This is an example of the field injection, where the dependency is injected on the
    //Field directly. Usage of the autowired annotation is absolutely necessary here
    @Autowired
    @Qualifier("walmartPetFoodServiceImpl")
    private PetFoodService petFoodService;

    //Just placing a default constructor for some debugging.


    public GrizzlyBear() {
        System.out.println("GrizzlyBear: inside the no argument default constructor");
    }

    @Override
    public String makeNoise() {
        return "Roaring like how only a Grizzly can....Grrrrrrrrrrr";
    }

    @Override
    public String getPetFood() {
        return petFoodService.getGrizzlyBearFood();
    }

    @Override
    public String getPetName() {
        return this.petName;
    }
}
