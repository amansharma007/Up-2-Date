package com.bkbiet.acm.up_2_date;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


/**
 * Created by Aman Sharma on 08-10-2016.
 */
public class EventsActivity extends Activity {
    //TextView title1;
    Intent i;
    String data,data2;
    DatabaseReference mDataRef;
    DatabaseReference mRootRef;
    DataSnapshot data11;
    private ProgressDialog progress;
    Thread thread;
    ArrayList<String> mMessages=new ArrayList<String>();
    ListView lCon2;
    Bundle bundle=new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_events);
        database_access();
        mDataRef=FirebaseDatabase.getInstance().getReference();
        //title1=(TextView)findViewById(R.id.textView13);
        lCon2=(ListView)findViewById(R.id.listContents2);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,android.R.id.text1,mMessages);
        final String passedTitle=getIntent().getExtras().getString("topic");
        final String passedYear=getIntent().getExtras().getString("year");
        mRootRef=mDataRef.child("root/"+passedTitle);
        lCon2.setAdapter(adapter);
        mRootRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                //title1.setText("Events");
                progress.hide();
                DataSnapshot data1 = dataSnapshot.child("Topic");
                data = data1.getValue().toString();
                switch (passedYear) {
                    case "All":
                        mMessages.add(data);
                        break;
                    case "1st Year":
                        data11 = dataSnapshot.child("Year");
                        data2 = data11.getValue().toString();
                        if(Integer.parseInt(data2)==1)
                            mMessages.add(data);
                        break;
                    case "2nd Year":
                        data11 = dataSnapshot.child("Year");
                        data2 = data11.getValue().toString();
                        if(Integer.parseInt(data2)==2)
                            mMessages.add(data);
                        break;
                    case "3rd Year":
                        data11 = dataSnapshot.child("Year");
                        data2 = data11.getValue().toString();
                        if(Integer.parseInt(data2)==3)
                            mMessages.add(data);
                        break;
                    case "4th Year":
                        data11 = dataSnapshot.child("Year");
                        data2 = data11.getValue().toString();
                        if(Integer.parseInt(data2)==4)
                            mMessages.add(data);
                        break;
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                DataSnapshot data1 = dataSnapshot.child("Topic");
                String data = data1.getValue().toString();
                mMessages.remove(data);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        lCon2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = (String) lCon2.getItemAtPosition(position);
                i = new Intent(EventsActivity.this, EventsDetails.class);
                bundle.putString("Name", s);
                bundle.putString("Year",passedYear);
                bundle.putString("passed", passedTitle);
                i.putExtras(bundle);
                startActivity(i);
            }
        });
    }

    public void database_access(){
        progress=new ProgressDialog(EventsActivity.this);
        progress.setMessage("Please Wait...");
        progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progress.setIndeterminate(true);
        progress.setProgress(0);
        progress.show();

        final int totalProgressTime = 100;
        thread = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while (jumpTime < totalProgressTime) {
                    try {
                        sleep(200);
                        jumpTime += 5;
                        progress.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        };
    }
}
