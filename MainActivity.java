package com.example.halper.stringlistlab;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


//  This app manipulates a list of cruise objects into
//  doing different things with different options, including:
//  Removing, displaying, saving, changing, adding, and using other
//  ways of calculating
//
//  My custom option is showing the average of all cruise prices
//  to two decimals. This is really helpful when deciding which
//  cruise someone would want, seeing if they are paying more than
//  the average cruise.
//
///////////////////////////////////////////////////////

public class MainActivity extends AppCompatActivity {

   public static TextView tv;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
       StrictMode.setThreadPolicy(policy);
       setContentView(R.layout.activity_main);
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

       StringList the_list;
       CruiseList newlist;

       // set the reference to the "main" TextView object so
       // we do not have to retrieve it in every method below

       tv = (TextView) findViewById(R.id.text_main);

       // create/access the list of strings
       newlist = CruiseList.getInstance();
       the_list = StringList.getInstance();




   } // end onCreate

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
       // Inflate the menu; this adds items to the action bar if it is present.
       getMenuInflater().inflate(R.menu.menu_main, menu);
       return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
       // Handle action bar item clicks here
       int id = item.getItemId();

       //noinspection SimplifiableIfStatement
       if (id == R.id.action_settings) {
           return true;
       }

       return super.onOptionsItemSelected(item);
   }

   public void onOption1(MenuItem i) //displays cruiseline shipname code # and price in order
   {
       tv.setText("");
       CruiseList newlist;
       Cruise cruise1 = new Cruise();
       newlist = CruiseList.getInstance();
       int j;

       //for loop, this goes through each one and appends the appropriate text
       for(j=0;j<newlist.size();j++)
       {
           tv.append(newlist.get(j).getCruiseline()+", ");
           tv.append(newlist.get(j).getShipname()+", ");
           tv.append(newlist.get(j).getCode()+", ");
           tv.append(Double.toString(newlist.get(j).getPrice()));
           tv.append("\n");
       }


   } // end onOption1

   public void onOption2(MenuItem i) //adds a new cruise to the end of the list
   {
       startActivity(new Intent(this, AddCruiseActivity.class));



   } // end onOption2

   public void onOption3(MenuItem i) //displays the detail of a certain ship given the code#
   {
       startActivity(new Intent(this,DisplayActivity.class));

   } // end onOption3

   public void onOption4(MenuItem i) //change price of a cruise given the code#
   {
       startActivity(new Intent(this,ChangePrice.class));


   } // end onOption4

   public void onOption5(MenuItem i) //remove a cruise whose code# is given
   {
       startActivity(new Intent(this, RemoveCruiseActivity.class));

   } // end onOption5

   public void onOption6(MenuItem i) //most expensive cruise
   {
       //setting variables
       tv.setText("");
       CruiseList new_list;
       Cruise cruise1 = new Cruise();
       new_list = CruiseList.getInstance();
       int highestcostsindex=0;
       int j;

       for(j=0;j<new_list.size();j++)
       {
           //these are used for calculating the double values which will be coompared
           double highest=(new_list.get(highestcostsindex).getPrice())/(new_list.get(highestcostsindex).getCruiselength());
           double current=(new_list.get(j).getPrice())/(new_list.get(j).getCruiselength());

           if(highest<current)
           {
               //current is higher than highest, therefore it will be the new highest
               highestcostsindex=j;
           }
       }

       tv.append(new_list.get(highestcostsindex).getCruiseline()+"\n");
       tv.append(new_list.get(highestcostsindex).getShipname()+"\n");
       tv.append(new_list.get(highestcostsindex).getCode()+"\n");

       double preday = (new_list.get(highestcostsindex).getPrice())/(new_list.get(highestcostsindex).getCruiselength());
       DecimalFormat df = new DecimalFormat("#.00");
       tv.append(df.format(preday)+"\n");

   }

    // end onOption6
   public void onOption7(MenuItem i) //average cruise length to two decimal places
   {
       tv.setText("");
       CruiseList new_list;
       Cruise cruise1 = new Cruise();
       new_list = CruiseList.getInstance();
       int j;
       double total = 0;
       //goes through the list checking
       for(j=0;j<new_list.size();j++)
       {
           //adds the total up
           total += new_list.get(j).getCruiselength();
       }

       double avg = total/new_list.size(); //and this divides it giving the average
       DecimalFormat df = new DecimalFormat("#.00");
       tv.append("Average length is "+ df.format(avg)+"\n");
   }
   //end of option 7

   public void onOption8(MenuItem i) //average price for all the ships two decimal places
   {
       tv.setText("");
       CruiseList new_list;
       Cruise cruise1 = new Cruise();
       new_list = CruiseList.getInstance();
       int j;
       double total = 0;
       //for loop goes through and adds up the prices
       for(j=0;j<new_list.size();j++)
       {
           total += new_list.get(j).getPrice();
       }

       double avg = total/new_list.size(); //here it takes the total and divides
       DecimalFormat df = new DecimalFormat("#.00");
       tv.append("Average price is "+ df.format(avg)+"\n");
       //using the decimal format from above to change it to two decimal places
   }
   //end of option 8
   public void onOption9(MenuItem i)
   {

       startActivity(new Intent(this, LoadList.class));
   }
   //end of option 9
   public void onOption10(MenuItem i)
   {

       startActivity(new Intent(this, SaveList.class));
   }
   //end of option 10

} // end MainActivity
