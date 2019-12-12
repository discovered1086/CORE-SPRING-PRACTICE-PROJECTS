package com.kingshuk.spring.aspectpractice.aop.basicaop.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.basicaop.service.PetFoodService;

/**
 * Created by kingshuk on 4/29/17.
 */
@Component
public class Lion implements Pet {

    private PetFoodService petFoodService;

    public Lion() {
        System.out.println("Lion: inside the no argument default constructor");
    }

    @Override
    public String makeNoise() {
        return "Roaring like a lion....Grrrrrrrrrrrrrr";
    }

    @Override
    public String getPetFood() {
        return petFoodService.getLionFood();
    }

    @Override
    public String getPetName() {
        return null;
    }


    //This is an example of the method injection, where any method can be used to inject dependencies as long as
    //The Autowired annotation is used
    @Autowired
    @Qualifier("bigYPetFoodServiceImpl")
    public void setTheFoodServiceUp(PetFoodService thePetFoodService){
        System.out.println("Lion: inside the setter method setTheFoodServiceUp");
        petFoodService=thePetFoodService;
    }
}
