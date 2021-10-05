package com.example.halper.stringlistlab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ChangePrice extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_change_price);
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
   public void ChangePrice(View view)
   {
       CruiseList new_list;
       Cruise cruise1 = new Cruise();
       new_list = CruiseList.getInstance();
       EditText et1;
       EditText et2;
       String code;
       double new_price;
       et1 = (EditText) findViewById(R.id.edit_codeprice);
       code = et1.getText().toString();
       et2 = (EditText) findViewById(R.id.edit_pricevalue);
       new_price =Double.parseDouble(et2.getText().toString());

       boolean found= false;

       for(int z=0;z<new_list.size();z++)
       {
           //current code equals current code in the list
           if (code.equals(new_list.get(z).getCode()))
           {
               //changes price
               cruise1=new_list.get(z);
               cruise1.setPrice(new_price);
               Toast.makeText(ChangePrice.this,
                       "Changed price",
                       Toast.LENGTH_LONG).show();
               //this sets it too true, making the if statement below not run
               found=true;

           }
       }

       if(found==false) {
           Toast.makeText(ChangePrice.this,
                   "Invalid code, try again",
                   Toast.LENGTH_LONG).show();
       }

   }

}
