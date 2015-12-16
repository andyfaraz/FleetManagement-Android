package com.jorc.fleetmanagement;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by user10 on 6/12/2015.
 */
public class PickTimeAvtivity extends Activity {
	        //Date Picker Dialog
        public static class DatePickerFragment extends DialogFragment
                 implements DatePickerDialog.OnDateSetListener {

					    @Override
					    public Dialog onCreateDialog(Bundle savedInstanceState) {
					        // Use the current date as the default date in the picker
					        final Calendar c = Calendar.getInstance();
					        int year = c.get(Calendar.YEAR);
					        int month = c.get(Calendar.MONTH);
					        int day = c.get(Calendar.DAY_OF_MONTH);

					        // Create a new instance of DatePickerDialog and return it
					        return new DatePickerDialog(getActivity(), this, year, month, day);
					    }

					    public void onDateSet(DatePicker view, int year, int month, int day) {
					        // Do something with the date chosen by the user
					    }
				 }

			  //	Start the Date Picker Dialog
				 public void showDatePickerDialog(View v) {
				    DialogFragment newFragment = new DatePickerFragment();
				    newFragment.show(getFragmentManager(), "datePicker");
				 }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_picktime);

    }
}
