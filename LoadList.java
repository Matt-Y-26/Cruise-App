package com.example.halper.stringlistlab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class LoadList extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_load_list);
       Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
       fab.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
           }
       });
   }

   public void LoadList(View view) {
       //setting up all the variables
       CruiseList new_list;
       new_list = CruiseList.getInstance();
       EditText et1;
       String url;
       String new_cruiseline;
       String new_shipname;
       String new_code;
       String new_cruiseregion;
       String string_new_cruiselength;
       String string_new_price;
       String string_new_gratuity;
       int new_cruiselength;
       double new_price;
       double new_gratuity;
       String new_url;

       et1 = (EditText) findViewById(R.id.edit_urllist);
       url = et1.getText().toString();

      try
       {
           URL file_url= new URL(url);
           //two scanners are used, one to find the length and the other to actually
           //scan the content
           Scanner fsc = new Scanner(file_url.openStream());
           Scanner scan = new Scanner(file_url.openStream());
           int length = 0;
           //scans the length
           while(fsc.hasNextLine())
           {
               fsc.nextLine();
               length++;
           }
           //removes the current ones, to make it completely replace
           while(!new_list.isEmpty())
           {
               new_list.remove(0);
           }
           int forlength = length/8;
           int q;
           for(q=0;q<forlength;q++)
           {

               Cruise cruise1 = new Cruise();
               new_cruiseline=scan.nextLine();
               new_shipname=scan.nextLine();
               new_code=scan.nextLine();
               new_cruiseregion=scan.nextLine();
               string_new_cruiselength=scan.nextLine();
               string_new_price=scan.nextLine();
               string_new_gratuity=scan.nextLine();
               new_url=scan.nextLine();
               new_cruiselength=Integer.parseInt(string_new_cruiselength);
               new_price = Double.parseDouble(string_new_price);
               new_gratuity= Double.parseDouble(string_new_gratuity);
               //setting the object to the new variables

               cruise1.setCruiseline(new_cruiseline);
               cruise1.setShipname(new_shipname);
               cruise1.setCode(new_code);
               cruise1.setCruiseregion(new_cruiseregion);
               cruise1.setCruiselength(new_cruiselength);
               cruise1.setPrice(new_price);
               cruise1.setGratuity(new_gratuity);
               cruise1.setURL(new_url);
               new_list.add((new_list.size()),cruise1);

               Toast.makeText(LoadList.this,
                       "Valid URL",
                       Toast.LENGTH_LONG).show();

           }


       }
       catch (Exception e) //if error, tell user with toast
       {
           Toast.makeText(LoadList.this,
                   "Invalid URL, try again",
                   Toast.LENGTH_LONG).show();
       }


   }
}
