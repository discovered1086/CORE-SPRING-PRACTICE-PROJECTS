package com.kingshuk.spring.aspectpractice.aop.basicaop.service;

import org.springframework.stereotype.Component;

/**
 * Created by kingshuk on 4/29/17.
 */
@Component
public class BigYPetFoodServiceImpl implements PetFoodService {
    @Override
    public String getCatFood() {
        return "Orijen Cat & Kitten Grain-Free Dry Cat Food";
    }

    @Override
    public String getDogFood() {
        return "Natural Balance Fat Dogs Chicken & Salmon Formula Low Calorie Dry Dog Food";
    }

    @Override
    public String getGoatFood() {
        return "Purina Mills Goat Developer 50 Lb";
    }

    @Override
    public String getTigerFood() {
        return "pet tigers love Big Y's All Natural Angus Beef";
    }

    @Override
    public String getCheetahFood() {
        return "pet cheetah's love Big Y's SuperBird Rotisserie Chicken";
    }

    @Override
    public String getLionFood() {
        return "pet lions love Big Y's Strauss Grass Fed Beef";
    }

    @Override
    public String getGrizzlyBearFood() {
        return "pet Grizzly's love trademark Big Y Tilapia";
    }

    @Override
    public String getGoldFishFood() {
        return "Big Y Great value Gold Fish Food";
    }
}
