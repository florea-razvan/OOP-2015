package com.example.roxana.zoo.models.animals;

import org.w3c.dom.Element;

/**
 * Created by Roxana on 10/25/2015.
 */
public abstract class Bird extends Animal {

    //attributes
    private boolean migrates;
    private int avgFlightAltitude;


    public Bird(double maintenanceCost, double dangerPerc){
        super(maintenanceCost,dangerPerc);
    }

    //getters and setters

    public boolean getMigrates(){
        return migrates;
    }

    public void setMigrates(boolean migrates){
        this.migrates = migrates;
    }

    public int getAvgFlightAltitude(){
        return avgFlightAltitude;
    }

    public void setAvgFlightAltitude(int avgFlightAltitude){
        this.avgFlightAltitude =  avgFlightAltitude;
    }

    //decoding from xml
    public void decodeFromXml(Element element) {

        setMigrates(Boolean.valueOf(element.getElementsByTagName("migrates").item(0).getTextContent()));
        setAvgFlightAltitude(Integer.valueOf(element.getElementsByTagName("avgFlightAltitude").item(0).getTextContent()));
    }

    public void getAnimalAttributes(){
        System.out.println("Species: Bird ");
        System.out.println("Name: "+getName());
        System.out.println("Number of legs: "+getNrOfLegs());
        System.out.println("Maintenance cost: "+super.maintenanceCost);
        System.out.println("Danger: "+(super.dangerPerc*100)+"%");
        System.out.println("Extra details:");
        System.out.println((getMigrates())?"It does migrate":"It does not migrate");
        System.out.println("It has an average flight altitude of "+getAvgFlightAltitude());
        System.out.println();
    }
    @Override
    public String toString() {

        //it's actually a html format :?
        String s="Species: Bird \n";
        s=s+"Number of legs: "+getNrOfLegs()+"\n";
        s=s+"Maintenance cost: "+super.maintenanceCost+"\n";
        s=s+"Danger: "+(super.dangerPerc*100)+"%\n";
        s=s+"Extra details:\n";
        s=s+((getMigrates())?"It does migrate":"It does not migrate")+"\n";
        s=s+"It has an average flight altitude of "+getAvgFlightAltitude()+"\n";
        return s;
    }


}
