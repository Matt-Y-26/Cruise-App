package com.example.halper.stringlistlab;

public class Cruise {
   private String cruiseline;
   private String shipname;
   private String code;
   private String cruiseregion;
   private int cruiselength;
   private double price;
   private double gratuity;
   private String URL;

   public Cruise()
   {

   }
   public Cruise(String cruiseline1, String shipname1, String code1, String cruiseregion1, int cruiselength1,double price1, double gratuity1, String URL1)
   {
       cruiseline=cruiseline1;
       shipname=shipname1;
       code=code1;
       cruiseregion=cruiseregion1;
       cruiselength=cruiselength1;
       price=price1;
       gratuity=gratuity1;
       URL=URL1;

   }

   //getters and setters

   public String getCruiseline() {
       return cruiseline;
   }

   public void setCruiseline(String cruiseline) {
       this.cruiseline = cruiseline;
   }

   public String getShipname() {
       return shipname;
   }

   public void setShipname(String shipname) {
       this.shipname = shipname;
   }

   public String getCode() {
       return code;
   }

   public void setCode(String code) {
       this.code = code;
   }

   public String getCruiseregion() {
       return cruiseregion;
   }

   public void setCruiseregion(String cruiseregion) {
       this.cruiseregion = cruiseregion;
   }

   public int getCruiselength() {
       return cruiselength;
   }

   public void setCruiselength(int cruiselength) {
       this.cruiselength = cruiselength;
   }

   public double getPrice() {
       return price;
   }

   public void setPrice(double price) {
       this.price = price;
   }

   public double getGratuity() {
       return gratuity;
   }

   public void setGratuity(double gratuity) {
       this.gratuity = gratuity;
   }

   public String getURL() {
       return URL;
   }

   public void setURL(String URL) {
       this.URL = URL;
   }


}
