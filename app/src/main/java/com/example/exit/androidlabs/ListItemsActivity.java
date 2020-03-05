package com.example.exit.androidlabs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class ListItemsActivity extends Activity {

    protected static final String ACTIVITY_NAME = "ListItemsActivity";
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // Ensure that there's a camera activity to handle the intent
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });

        Switch switchButton = (Switch)findViewById(R.id.switchToggle);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton switchButton, boolean isChecked) {
                if (isChecked){
//                    CharSequence text = "Switch is On"; //Switch is Off
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.SwitchOn, duration); //this is the ListActivity
                    toast.show(); //display message "Switch is On" if the switch is checked
                }
                if (!isChecked){
//                    CharSequence text = "Switch is Off"; //Switch is Off
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(getApplicationContext(), R.string.SwitchOff, duration); //this is the ListActivity
                    toast.show(); //display message "Switch is Off" if the switch is unchecked
                }
            }
        });

        CheckBox checkBox = (CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
                if (isChecked){
                    AlertDialog.Builder builder = new AlertDialog.Builder(ListItemsActivity.this);
                    //Chain together various setter methods to set the dialog characteristics
                    builder.setMessage(R.string.dialog_message) //Add a dialog message to strings.xml

                            .setTitle(R.string.dialog_title)
                            .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Intent resultIntent = new Intent(  );
                                    resultIntent.putExtra("Response", "Here is my response");
                                    setResult(Activity.RESULT_OK, resultIntent);
                                    finish(); // User clicked OK button
                                }
                            })
                            .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // User cancelled the dialog
                                }
                            })
                            .show();
                }
            }
        });

    }

    protected void onActivityResult(int requestCode, int responseCode, Intent data){

        if (requestCode == REQUEST_IMAGE_CAPTURE) {
            Bundle extras = data.getExtras();
            Bitmap bitmap = (Bitmap) extras.get("data");
            ImageButton imageButton = (ImageButton)findViewById(R.id.imageButton);
            imageButton.setImageBitmap(bitmap);
        }
    }

    protected void onResume(){
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }

    protected void onStart(){
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");
    }

    protected void onPause(){
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");
    }

    protected void onStop(){
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");
    }

    protected void onDestroy(){
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");
    }
}
