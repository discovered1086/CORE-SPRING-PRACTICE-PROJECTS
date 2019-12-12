package com.kingshuk.spring.aspectpractice.aop.basicaop.service;

import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 4/29/17.
 */
@Component
public class ShopritePetFoodServiceImpl implements PetFoodService {
    @Override
    public String getCatFood() {
        return "Blue Buffalo Wilderness Indoor Chicken Recipe Grain-Free Dry Cat Food";
    }

    @Override
    public String getDogFood() {
        return "Wellness Small Breed Complete Health Turkey & Peas Senior Dog Food";
    }

    @Override
    public String getGoatFood() {
        return "Nutrena Country Feed All Stock 14% Textured Feed";
    }

    @Override
    public String getTigerFood() {
        return "pet tigers love Shoprite's Angus Beef Round Cubes For Fondue";
    }

    @Override
    public String getCheetahFood() {
        return "pet cheetah's love Shoprite's Chicken Boneless/Skinless Breast";
    }

    @Override
    public String getLionFood() {
        return "pet lions love Shoprite's Beef Beef Center Cut Cross Cut Shank";
    }

    @Override
    public String getGrizzlyBearFood() {
        return "pet Grizzly's love Shoprite's Acme - Smoked Salmon - Side Trim";
    }

    @Override
    public String getGoldFishFood() {
        return "Shoprite's original pond gold fish food";
    }
}
