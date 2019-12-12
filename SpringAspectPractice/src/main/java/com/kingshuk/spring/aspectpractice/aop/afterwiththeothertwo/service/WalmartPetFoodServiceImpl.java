package com.kingshuk.spring.aspectpractice.aop.afterwiththeothertwo.service;

import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 4/29/17.
 */
@Component
public class WalmartPetFoodServiceImpl implements PetFoodService {
    @Override
    public String getTigerFood() {
        return "pet tigers love Walmart's Beef Choice Tri Tip Roast Boneless";
    }

    @Override
    public String getCheetahFood() {
        return "pet cheetahs love Walmart's Tyson® All Natural Boneless Skinless Chicken Breasts";
    }
}
