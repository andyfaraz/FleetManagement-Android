package com.jorc.fleetmanagement;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        
        Button report=(Button)findViewById(R.id.button_rec);
          report.setOnClickListener(onReport);
        Button help=(Button)findViewById(R.id.button_send);
          help.setOnClickListener(onHelp);

    }

    @Override
    public void onMapReady(final GoogleMap map) {
        // Add a marker for each truck.
                              //Show Alert from parse
                        ParseQuery query = new ParseQuery("trucks");
                          query.findInBackground(new FindCallback<ParseObject>() {
                              public void done(List<ParseObject> scoreList, ParseException e) {
                                  if (e == null) {
                                            for (int i = 0; i < scoreList.size(); i++) {
                                                   ParseObject u = (ParseObject)scoreList.get(i);
                                                  String truckName; String xcor; String ycor;
                                                   xcor = u.getString("xcor1").toString();
                                                   ycor = u.getString("ycor1").toString();
                                                   truckName = u.getString("driver").toString();
                                                       Snackbar.make(getWindow().getDecorView(), truckName+" position was updated.", Snackbar.LENGTH_LONG)
                                                       .setAction("Action", null).show();

                                                    LatLng sydney = new LatLng(-34, 151);
                                                     LatLng tempCoord = new LatLng(Double.parseDouble(ycor), Double.parseDouble(xcor));
                                                     map.addMarker(new MarkerOptions()
                                                        .icon(BitmapDescriptorFactory.defaultMarker(i * 30))
                                                        .position(tempCoord).title(truckName));

                                                    //map.moveCamera(CameraUpdateFactory.newLatLng(sydney));
                                                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 8.0f));
                                             }

                                    } else {
                                      //Log.d("score", "Error: " + e.getMessage());
                                  }
                               }
                           });

    }
    //Button Report
     private View.OnClickListener onReport=new View.OnClickListener() {
        public void onClick(View v) {
            //Show Report
            AlertDialog alertDialog = new AlertDialog.Builder(MapsActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Truck Monitoring System is healthy. The locations are updated from the server and trucks are on their way.");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                     }
                    });
            alertDialog.show();

        }
     };
    //Button Help
     private View.OnClickListener onHelp=new View.OnClickListener() {
        public void onClick(View v) {
            //Show Report
            AlertDialog alertDialog = new AlertDialog.Builder(MapsActivity.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Call your supervisor if truck marker is yellow");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                     public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                     }
                    });
            alertDialog.show();

        }
     };

}