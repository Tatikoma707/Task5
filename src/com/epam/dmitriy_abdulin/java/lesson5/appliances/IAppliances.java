package com.epam.dmitriy_abdulin.java.lesson5.appliances;

/**
 * Created by dima7 on 03.04.2018.
 */
public interface IAppliances extends Comparable<IAppliances> {
    String getBrandAppliances();

    boolean isStateOfDevice();

    int getPower();

    Appliance clone() throws CloneNotSupportedException;

    @Override
    int compareTo(IAppliances o);
}
