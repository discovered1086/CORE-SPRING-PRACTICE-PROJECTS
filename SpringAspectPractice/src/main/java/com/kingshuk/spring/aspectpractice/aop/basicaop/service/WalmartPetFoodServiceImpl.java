package com.kingshuk.spring.aspectpractice.aop.basicaop.service;

import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 4/29/17.
 */
@Component
public class WalmartPetFoodServiceImpl implements PetFoodService {
    @Override
    public String getCatFood() {
        return "Meow Mix Original Choice Cat Food";
    }

    @Override
    public String getDogFood() {
        return "Pedigree Puppy Growth & Protection Chicken & Vegetable Flavor";
    }

    @Override
    public String getGoatFood() {
        return "Walmart's Calf-Manna Farm Animal Feed";
    }

    @Override
    public String getTigerFood() {
        return "pet tigers love Walmart's Beef Choice Tri Tip Roast Boneless";
    }

    @Override
    public String getCheetahFood() {
        return "pet cheetahs love Walmart's Tyson® All Natural Boneless Skinless Chicken Breasts";
    }

    @Override
    public String getLionFood() {
        return "pet lions love Walmart's Whole Muscle Beef, Beef Choice Rump Roast";
    }

    @Override
    public String getGrizzlyBearFood() {
        return "pet Grizzlys love Walmart's Seafood Frozen Tilapia";
    }

    @Override
    public String getGoldFishFood() {
        return "Wardley Pond Pellet Fish Food";
    }
}
