package com.epam.dmitriy_abdulin.java.lesson5;

import com.epam.dmitriy_abdulin.java.lesson5.appliances.Appliance;
import com.epam.dmitriy_abdulin.java.lesson5.appliances.Type.TypeAppliances;

import java.util.ArrayList;

/**
 * Created by dima7 on 03.04.2018.
 */
public class Solution {
    public static void main(String[] args) {
        Appliance kettleTefal = createAppliances("Tefal", TypeAppliances.KETTLE, 1000, true);
        Appliance tvSony = createAppliances("Sony", TypeAppliances.TV, 400, true);
        Appliance lampPhilips = createAppliances("Philips", TypeAppliances.LAMP, 200, false);
        Appliance computerHP = createAppliances("HP", TypeAppliances.COMPUTER, 500, false);
        Appliance cookerGefest = createAppliances("Gefest", TypeAppliances.COOKER, 1500, true);

        ArrayList<Appliance> myList = new ArrayList<>();
        myList.add(kettleTefal);
        myList.add(tvSony);
        myList.add(lampPhilips);
        myList.add(computerHP);
        myList.add(cookerGefest);
        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }
        System.out.println("\nAppliances, whose power is in the range of 500 to 1000:");
        ArrayList<Appliance> sortByPower = getAppliancesByPower(myList, 500, 1000);
        for (int i = 0; i < sortByPower.size(); i++) {
            System.out.println(sortByPower.get(i));
        }
        System.out.println("\nAppliances, which are currently included in the outlet:");
        ArrayList<Appliance> sortAppliancesByState = getAppliancesByState(myList, true);
        for (int i = 0; i < sortAppliancesByState.size(); i++) {
            System.out.println(sortAppliancesByState.get(i));
        }

        System.out.print("\nTotal power consumption: ");
        Integer sumPower = 0;
        for (int i = 0; i < myList.size(); i++) {
            if (myList.get(i).isStateOfDevice())
                sumPower += myList.get(i).getPower();
        }
        System.out.println(sumPower);
    }

    public static ArrayList<Appliance> getAppliancesByPower(ArrayList<Appliance> list, int lowerBound, int upperBound) {
        ArrayList<Appliance> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getPower() >= lowerBound && list.get(i).getPower() <= upperBound) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static ArrayList<Appliance> getAppliancesByState(ArrayList<Appliance> list, boolean state) {
        ArrayList<Appliance> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isStateOfDevice() == state) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static Appliance createAppliances(String brand, TypeAppliances type, int power, boolean isOn) {
        return new Appliance(brand, type, power, isOn);
    }
}
