package com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.service.PetFoodService;

/**A bean for testing the after advice
 * Created by kingshuk on 4/23/17.
 */
@Component("MyCheetah")
public class Cheetah implements Pet {
    private PetFoodService petFoodService;

    @Value("${cheetahName}")
    private String petName;


    @Override
    public String makeNoise() {
        return "Grrrrrreeeeerrrrr...";
    }

    @Override
    public String getPetFood() {
        throw new RuntimeException("The Cheetah get food feature failed");
        //return petFoodService.getCheetahFood();
    }

    @Override
    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    //This is an example of the setter injection.
    @Autowired  //Autowired is kind of optional post Spring release 4.3 however it's a good
    //practice to have it to make the code more readable
    @Qualifier("shopritePetFoodServiceImpl")
    public void setPetFoodService(PetFoodService petFoodService) {
        //System.out.println("Cheetah: inside the setter method setPetFoodService");
        this.petFoodService = petFoodService;
    }

    /*Let's write some init method
    @PostConstruct
    public void doThisOnStartUp(){
        System.out.println("I have entered the init method of the Cheetah object "+this+".....yahoooo...!!!");
    }*/

    /*Let's write some destroy method code
    @PreDestroy
    public void doThisWhenDestroyed(){
        System.out.println("I have entered the destroy method of the Cheetah object"+this+".....sad but have to leave...!!!");
    }*/
}
