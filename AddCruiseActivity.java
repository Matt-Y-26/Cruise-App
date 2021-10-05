package com.example.halper.stringlistlab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCruiseActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_add_cruise);
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
   public void addCruise(View view)
   {
       try {
           //create variables
           CruiseList new_list;
           Cruise cruise1 = new Cruise();
           EditText et1;
           EditText et2;
           EditText et3;
           EditText et4;
           EditText et5;
           EditText et6;
           EditText et7;
           EditText et8;
           String new_cruiseline;
           String new_shipname;
           String new_code;
           String new_cruiseregion;
           int new_cruiselength;
           double new_price;
           double new_gratuity;
           String new_url;

           //getting edit texts to new strings
           et1 = (EditText) findViewById(R.id.edit_cruiseline);
           new_cruiseline = et1.getText().toString();
           et2 = (EditText) findViewById(R.id.edit_shipname);
           new_shipname = et2.getText().toString();
           et3 = (EditText) findViewById(R.id.edit_code);
           new_code = et3.getText().toString();
           et4 = (EditText) findViewById(R.id.edit_region);
           new_cruiseregion = et4.getText().toString();
           et5 = (EditText) findViewById(R.id.edit_length);
           new_cruiselength = Integer.parseInt(et5.getText().toString());
           et6 = (EditText) findViewById(R.id.edit_price);
           new_price = Double.parseDouble(et6.getText().toString());
           et7 = (EditText) findViewById(R.id.edit_gratuity);
           new_gratuity = Double.parseDouble(et7.getText().toString());
           et8 = (EditText) findViewById(R.id.edit_URL);
           new_url = et8.getText().toString();

           //setting cruise object to have new variables to be stored

           cruise1.setCruiseline(new_cruiseline);
           cruise1.setShipname(new_shipname);
           cruise1.setCode(new_code);
           cruise1.setCruiseregion(new_cruiseregion);
           cruise1.setCruiselength(new_cruiselength);
           cruise1.setPrice(new_price);
           cruise1.setGratuity(new_gratuity);
           cruise1.setURL(new_url);

           new_list = CruiseList.getInstance();
           new_list.add(new_list.size(), cruise1);
           Toast.makeText(AddCruiseActivity.this,
                   "Added Cruise",
                   Toast.LENGTH_LONG).show();
       }
       catch(Exception e)
       {
           Toast.makeText(AddCruiseActivity.this,
                   "Failed to add cruise",
                   Toast.LENGTH_LONG).show();
       }
   }
}
