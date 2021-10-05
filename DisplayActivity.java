package com.example.halper.stringlistlab;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

public class DisplayActivity extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_display);
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
   public void DisplayCruise(View view)
   {
       //setting up variables and getting all of it ready for the real code
       EditText et1;
       CruiseList new_list;
       Cruise cruise1 = new Cruise();
       TextView tv;
       tv = (TextView) findViewById(R.id.text_maindisplay);
       String new_code;
       new_list = CruiseList.getInstance();
       et1 = (EditText) findViewById(R.id.edit_codeenter);
       new_code = et1.getText().toString();
       tv.setText("");

       boolean found = false;
          for(int z=0;z<new_list.size();z++)
          {

              if (new_code.equals(new_list.get(z).getCode()))
              {
                   //code matched displaying

                   cruise1 = new_list.get(z);
                   tv.append(cruise1.getCruiseline()+"\n");
                   tv.append(cruise1.getShipname()+"\n");
                   tv.append(cruise1.getCruiseregion()+"\n");
                   tv.append((cruise1.getCruiselength())+"\n");
                   tv.append((cruise1.getPrice())+"\n");
                   double totalgrat = cruise1.getGratuity()*(double)cruise1.getCruiselength();
                   tv.append(totalgrat+"\n");
                   double totalcost = cruise1.getPrice()+totalgrat;
                   tv.append(totalcost+"\n");

                   //url for drawee
                   Uri uri = Uri.parse(cruise1.getURL());
                   SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.image_area);
                   draweeView.setImageURI(uri);
                   //sets found true, disables if statement below
                   found=true;
                   Toast.makeText(DisplayActivity.this,
                          "Valid code displaying detials",
                          Toast.LENGTH_LONG).show();
                  //break;
              }
          }
          if(found==false) {
              Toast.makeText(DisplayActivity.this,
                      "Invalid code, try again",
                      Toast.LENGTH_LONG).show();
          }

       }
}
