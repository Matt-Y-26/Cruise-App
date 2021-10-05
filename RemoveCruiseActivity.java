package com.example.halper.stringlistlab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveCruiseActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_remove_cruise);
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
   public void RemoveCruise(View view)
   {
       //setting up variables
       CruiseList new_list;
       Cruise cruise1 = new Cruise();
       new_list = CruiseList.getInstance();
       EditText et1;
       EditText et2;
       String codeprice;
       et1 = (EditText) findViewById(R.id.edit_coderemove);
       codeprice = et1.getText().toString();


       boolean found= false;
       //goes through each one on list
       for(int z=0;z<new_list.size();z++)
       {
           if (codeprice.equals(new_list.get(z).getCode()))
           {
               //if loop checks to see if the code given equals a current code for ship index
               //then it removes the list
               new_list.remove(z);

               Toast.makeText(RemoveCruiseActivity.this,
                       "Removed cruise",
                       Toast.LENGTH_LONG).show();
               found=true;
               break;
           }
       }
       //if found is not set true above this runs a toast
       if(found==false) {
           Toast.makeText(RemoveCruiseActivity.this,
                   "Invalid code, try again",
                   Toast.LENGTH_LONG).show();
       }
   }

}
