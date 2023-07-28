package com.grandmen123.xtutorial.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ModAdvancedModelUtils {
    private static JsonArray getBowDisplayArray(String key) {
        JsonArray returnVal = new JsonArray();
        switch (key) {
            case "rotationThirdRight" -> {
                returnVal.add(-80);
                returnVal.add(260);
                returnVal.add(-40);
            }
            case "rotationThirdLeft" -> {
                returnVal.add(-80);
                returnVal.add(-280);
                returnVal.add(40);
            }
            case "rotationFirstRight" -> {
                returnVal.add(0);
                returnVal.add(-90);
                returnVal.add(25);
            }
            case "rotationFirstLeft" -> {
                returnVal.add(0);
                returnVal.add(90);
                returnVal.add(-25);
            }
            case "translationThird" -> {
                returnVal.add(-1);
                returnVal.add(-2);
                returnVal.add(2.5);
            }
            case "translationFirst" -> {
                returnVal.add(1.13);
                returnVal.add(3.2);
                returnVal.add(1.13);
            }
            case "scaleThird" -> {
                returnVal.add(0.9);
                returnVal.add(0.9);
                returnVal.add(0.9);
            }
            case "scaleFirst" -> {
                returnVal.add(0.68);
                returnVal.add(0.68);
                returnVal.add(0.68);
            }
        }

        return returnVal;
    }

    public static JsonObject genBowDisplayObject() {
        JsonObject returnVal = new JsonObject();

        JsonObject thirdperson_righthand = new JsonObject();
        JsonObject thirdperson_lefthand = new JsonObject();
        JsonObject firstperson_righthand = new JsonObject();
        JsonObject firstperson_lefthand = new JsonObject();

        thirdperson_righthand.add("rotation", getBowDisplayArray("rotationThirdRight"));
        thirdperson_lefthand.add("rotation", getBowDisplayArray("rotationThirdLeft"));
        firstperson_righthand.add("rotation", getBowDisplayArray("rotationFirstRight"));
        firstperson_lefthand.add("rotation", getBowDisplayArray("rotationFirstLeft"));

        thirdperson_righthand.add("translation", getBowDisplayArray("translationThird"));
        thirdperson_lefthand.add("translation", getBowDisplayArray("translationThird"));
        firstperson_righthand.add("translation", getBowDisplayArray("translationFirst"));
        firstperson_lefthand.add("translation", getBowDisplayArray("translationFirst"));

        thirdperson_righthand.add("scale", getBowDisplayArray("scaleThird"));
        thirdperson_lefthand.add("scale", getBowDisplayArray("scaleThird"));
        firstperson_righthand.add("scale", getBowDisplayArray("scaleFirst"));
        firstperson_lefthand.add("scale", getBowDisplayArray("scaleFirst"));

        returnVal.add("thirdperson_righthand", thirdperson_righthand);
        returnVal.add("thirdperson_lefthand", thirdperson_lefthand);
        returnVal.add("firstperson_righthand", firstperson_righthand);
        returnVal.add("firstperson_lefthand", firstperson_lefthand);

        return returnVal;
    }
}
