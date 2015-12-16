package com.jorc.fleetmanagement;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SafetyReport extends Activity {

 public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.layout_safety);

    final String crap2 = "Your report has been submitted. Our safety officer will be in contact with you.";
   
     Button button = (Button) findViewById(R.id.photoButton);
     Button button2 = (Button) findViewById(R.id.incidentSafety);
     
			button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        Intent intentMain = new Intent(SafetyReport.this , 
                                                       PhotoIntentActivity.class);
                        SafetyReport.this.startActivity(intentMain);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    AlertDialog alertDialog2 = new AlertDialog.Builder(SafetyReport.this).create();
                    alertDialog2.setTitle("Alert");
                     alertDialog2.setMessage(crap2);
                    alertDialog2.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                           dialog.dismiss();
                        }
                    });
                 alertDialog2.show();
                }
            });
      //Dialog picker for time and date
            Button button3 = (Button) findViewById(R.id.safetyTime);
               button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                        Intent intentMain = new Intent(SafetyReport.this , 
                                                       PickTimeAvtivity.class);
                        SafetyReport.this.startActivity(intentMain);
                }
            });

  }

}