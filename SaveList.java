package com.example.halper.stringlistlab;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class SaveList extends AppCompatActivity {

   @Override
   protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_save_list);
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
   public void SaveList(View view)
   {
       try {
           //setting up variables
           CruiseList new_list;
           Cruise cruise1 = new Cruise();
           new_list = CruiseList.getInstance();
           EditText et1;
           String outtxtfile;
           et1 = (EditText) findViewById(R.id.edit_savelistfile);
           outtxtfile = et1.getText().toString();
           //setting up file outwriter
           File outfile = new File(getExternalFilesDir(null), outtxtfile);
           FileWriter fw = new FileWriter(outfile);
           BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
           int j;
           //this copies each one to the document
           for(j=0;j<new_list.size();j++)
           {
               pw.append(new_list.get(j).getCruiseline()+"\n");
               pw.append(new_list.get(j).getShipname()+"\n");
               pw.append(new_list.get(j).getCode()+"\n");
               pw.append(new_list.get(j).getCruiseregion()+"\n");
               pw.append(Integer.toString(new_list.get(j).getCruiselength())+"\n");
               pw.append(Double.toString(new_list.get(j).getPrice())+"\n");
               pw.append(Double.toString(new_list.get(j).getGratuity())+"\n");
               pw.append(new_list.get(j).getCruiseline()+"\n");
           }

           pw.close();
       }
       catch(Exception e)
       {
           Toast.makeText(SaveList.this,
                   "Save list error, please try again",
                   Toast.LENGTH_LONG).show();
       }
   }
}
