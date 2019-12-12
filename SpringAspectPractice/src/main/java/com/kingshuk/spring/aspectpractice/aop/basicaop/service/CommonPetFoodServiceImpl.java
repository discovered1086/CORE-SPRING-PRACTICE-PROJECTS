package com.kingshuk.spring.aspectpractice.aop.basicaop.service;

import org.springframework.stereotype.Component;

/**
 * Created by co21321 on 4/10/2017.
 */
@Component
public class CommonPetFoodServiceImpl implements PetFoodService {
    @Override
    public String getCatFood() {
        return "Big Y Great Cat Food";
    }

    @Override
    public String getDogFood() {
        return "ShopRite Great Dog Food";
    }

    @Override
    public String getGoatFood() {
        return "Walmart Great Goat Food";
    }

    @Override
    public String getTigerFood() {
        return "pet tigers love the chicken and beef from Big Y";
    }

    @Override
    public String getCheetahFood() {
        return "pet Cheetahs love the chicken rotesary from Walmart";
    }

    @Override
    public String getLionFood() {
        return "pet lions love the beef available in ShopRite";
    }

    @Override
    public String getGrizzlyBearFood() {
        return "pet Grizzly Bears love the tilapia or Salmon from Big Y";
    }

    @Override
    public String getGoldFishFood() {
        return "pet gold fish food from chewy.com";
    }


}
