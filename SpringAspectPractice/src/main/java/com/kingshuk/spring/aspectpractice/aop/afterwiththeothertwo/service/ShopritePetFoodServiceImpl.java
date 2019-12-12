package com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.service;

import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 4/29/17.
 */
@Component
public class ShopritePetFoodServiceImpl implements PetFoodService {

    @Override
    public String getTigerFood() {
        return "pet tigers love Shoprite's Angus Beef Round Cubes For Fondue";
    }

    @Override
    public String getCheetahFood() {
        return "pet cheetah's love Shoprite's Chicken Boneless/Skinless Breast";
    }

}
