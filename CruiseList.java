package com.example.halper.stringlistlab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class CruiseList extends LinkedList<Cruise>
{

   private static CruiseList instance = null; // list does not exist initially.

   private CruiseList()
   {
       // Exists only to defeat additional instantiations.
   }

   public static CruiseList getInstance()
   {
       if(instance == null)
           instance = new CruiseList(); // create list here.

       return instance;
   }

} // end StringList
