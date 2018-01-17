package com.bkbiet.acm.up_2_date;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Aman Sharma on 05-10-2016.
 */
public class Home extends Activity implements AdapterView.OnItemSelectedListener{
    //ListView lCon;
    TextView aboutUs;
    Bundle b=new Bundle();
    Spinner spinner;
    String year;
    Intent i;
    int selectedId;
    RadioGroup rGroup;
    RadioButton rButton;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_home);
        initialize();
        //contents=new String[]{
        //        "Placement Cell","Workshops and Events","Holidays","Examination Notices","Extras"
        //};
        //ArrayAdapter<String> arAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,contents);
        //lCon.setAdapter(arAdapter);
        //lCon.setOnItemClickListener(this);
        ArrayAdapter<CharSequence> arAdapter = ArrayAdapter.createFromResource(this,
                R.array.Items, android.R.layout.simple_spinner_item);
        arAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arAdapter);
        rGroup=(RadioGroup)findViewById(R.id.rBG);
        rGroup.check(R.id.rBA);
        spinner.setOnItemSelectedListener(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i=new Intent(Home.this,AboutUs.class);
                startActivity(i);
            }
        });
    }


    private void initialize() {
        spinner = (Spinner)findViewById(R.id.spinner);
        submit=(Button)findViewById(R.id.bS);
        aboutUs=(TextView)findViewById(R.id.about);
        //title=(TextView)findViewById(R.id.textView);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch((String)spinner.getItemAtPosition(position))
        {
            case "Select a category":
                break;
            case "Placement Cell":i=new Intent(Home.this,EventsActivity.class);
                b.putString("topic", "Placement Cell");
                selectedId=rGroup.getCheckedRadioButtonId();
                rButton=(RadioButton)findViewById(selectedId);
                year= rButton.getText().toString();
                b.putString("year", year);
                i.putExtras(b);
                //startActivity(i);
                break;
            case "Workshops and Events":
                i=new Intent(Home.this,EventsActivity.class);
                b.putString("topic","workshops");
                selectedId=rGroup.getCheckedRadioButtonId();
                rButton=(RadioButton)findViewById(selectedId);
                year= rButton.getText().toString();
                b.putString("year", year);
                i.putExtras(b);
                //startActivity(i);
                break;
            case "Holidays":
                i=new Intent(Home.this,EventsActivity.class);
                b.putString("topic","Holidays");
                selectedId=rGroup.getCheckedRadioButtonId();
                rButton=(RadioButton)findViewById(selectedId);
                year= rButton.getText().toString();
                b.putString("year", year);
                i.putExtras(b);
                //startActivity(i);
                break;
            case "Examination Notices":
                i=new Intent(Home.this,EventsActivity.class);
                b.putString("topic","Exam Notices");
                selectedId=rGroup.getCheckedRadioButtonId();
                rButton=(RadioButton)findViewById(selectedId);
                year= rButton.getText().toString();
                b.putString("year", year);
                i.putExtras(b);
                //startActivity(i);
                break;
            case "Extras":
                i=new Intent(Home.this,EventsActivity.class);
                b.putString("topic","Extras");
                selectedId=rGroup.getCheckedRadioButtonId();
                rButton=(RadioButton)findViewById(selectedId);
                year= rButton.getText().toString();
                b.putString("year", year);
                i.putExtras(b);
                //startActivity(i);
                break;
            /*case "About Us":
                i=new Intent(Home.this,AboutUs.class);
                //startActivity(i);
                break;*/

        }
    }
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

}
