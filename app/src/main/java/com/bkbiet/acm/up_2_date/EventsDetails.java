package com.bkbiet.acm.up_2_date;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by Aman Sharma on 16-10-2016.
 */
public class EventsDetails extends Activity {
    DatabaseReference dataref;
    private ProgressDialog progress;
    DatabaseReference rootref;
    String e,t,d,v,c,o,l;
    Thread thread;
    TextView /*header,*/event,topic,venue,description,coordinators,organization,links,years;
    TextView eventT,topicT,venueT,descriptionT,coordinatorsT,organizationT,linksT,yearsT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_details2);
        event=(TextView)findViewById(R.id.tvEvent);
        topic=(TextView)findViewById(R.id.tvTopic);
        venue=(TextView)findViewById(R.id.tvVenue);
        description=(TextView)findViewById(R.id.tvDescription);
        coordinators=(TextView)findViewById(R.id.tvCoordinators);
        organization=(TextView)findViewById(R.id.tvOrganization);
        links=(TextView)findViewById(R.id.tvLinks);
        years=(TextView)findViewById(R.id.tvYear);
        eventT=(TextView)findViewById(R.id.tvEventTitle);
        topicT=(TextView)findViewById(R.id.tvTopicTitle);
        venueT=(TextView)findViewById(R.id.tvVenueTitle);
        descriptionT=(TextView)findViewById(R.id.tvDescriptionTitle);
        coordinatorsT=(TextView)findViewById(R.id.tvCoordinatorsTitle);
        organizationT=(TextView)findViewById(R.id.tvOrganizationTitle);
        linksT=(TextView)findViewById(R.id.tvLinksTitle);
        yearsT=(TextView)findViewById(R.id.tvYearTitle);
        //header=(TextView)findViewById(R.id.textView14);
        database_access();

        dataref= FirebaseDatabase.getInstance().getReference();
        Bundle b=getIntent().getExtras();
        final String pT=b.getString("passed");
        final String name=b.getString("Name");
        final String year=b.getString("Year");
        rootref=dataref.child("root/"+pT);
        rootref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //header.setText("Event Details");
                progress.hide();
                for(DataSnapshot d1:dataSnapshot.getChildren())
                {
                    String test=d1.child("Topic").getValue().toString();

                    switch(pT)
                    {
                        case "Placement Cell":
                            if((test).equalsIgnoreCase(name)){
                                e=d1.child("Event").getValue().toString();
                                event.setText(e);
                                t=d1.child("Topic").getValue().toString();
                                topic.setText(t);
                                //Venue->student contacts
                                venueT.setText("Student Contacts: ");
                                v=d1.child("Student Contacts").getValue().toString();
                                venue.setText(v);
                                d=d1.child("Description").getValue().toString();
                                description.setText(d);
                                //coordinators->faculty contacts
                                coordinatorsT.setText("Faculty Contacts: ");
                                c=d1.child("Faculty Contacts").getValue().toString();
                                coordinators.setText(c);
                                //organization->Note
                                organizationT.setText("Note: ");
                                o=d1.child("Note").getValue().toString();
                                organization.setText(o);
                                l=d1.child("Links").getValue().toString();
                                links.setText(l);
                                years.setText(year);
                            }
                            break;
                        case "workshops":
                            if((test).equalsIgnoreCase(name)){
                                e=d1.child("Event").getValue().toString();
                                event.setText(e);
                                t=d1.child("Topic").getValue().toString();
                                topic.setText(t);
                                v=d1.child("Venue").getValue().toString();
                                venue.setText(v);
                                d=d1.child("Description").getValue().toString();
                                description.setText(d);
                                c=d1.child("Coordinators").getValue().toString();
                                coordinators.setText(c);
                                o=d1.child("Organization").getValue().toString();
                                organization.setText(o);
                                l=d1.child("Links").getValue().toString();
                                links.setText(l);
                                years.setText(year);
                            }
                            break;
                        case "Holidays":
                            if((test).equalsIgnoreCase(name)){
                                eventT.setText("•");
                                e=d1.child("Event").getValue().toString();
                                event.setText(e);
                                t=d1.child("Topic").getValue().toString();
                                topic.setText(t);
                                venueT.setText("•");
                                v=d1.child("Venue").getValue().toString();
                                venue.setText(v);
                                descriptionT.setText("•");
                                d=d1.child("Description").getValue().toString();
                                description.setText(d);
                                coordinatorsT.setText("•");
                                c=d1.child("Coordinators").getValue().toString();
                                coordinators.setText(c);
                                organizationT.setText("•");
                                o=d1.child("Organization").getValue().toString();
                                organization.setText(o);
                                l=d1.child("Links").getValue().toString();
                                links.setText(l);
                                years.setText(year);
                            }
                            break;
                        case "Exam Notices":
                            if((test).equalsIgnoreCase(name)) {
                                e = d1.child("Event").getValue().toString();
                                event.setText(e);
                                t = d1.child("Topic").getValue().toString();
                                topic.setText(t);
                                v = d1.child("Venue").getValue().toString();
                                venue.setText(v);
                                d = d1.child("Description").getValue().toString();
                                description.setText(d);
                                //coordinators->TimeTable
                                coordinatorsT.setText("TimeTable: ");
                                c = d1.child("TimeTable").getValue().toString();
                                coordinators.setText(c);
                                //organization->Branch-Year
                                organizationT.setText("Branch-Year: ");
                                o = d1.child("Branch-Year").getValue().toString();
                                organization.setText(o);
                                l = d1.child("Links").getValue().toString();
                                links.setText(l);
                                years.setText(year);
                            }
                            break;
                        case "Extras":
                            if((test).equalsIgnoreCase(name)){
                                eventT.setText("•");
                                e=d1.child("Event").getValue().toString();
                                event.setText(e);
                                t=d1.child("Topic").getValue().toString();
                                topic.setText(t);
                                venueT.setText("•");
                                v=d1.child("Venue").getValue().toString();
                                venue.setText(v);
                                descriptionT.setText("•");
                                d=d1.child("Description").getValue().toString();
                                description.setText(d);
                                coordinatorsT.setText("•");
                                c=d1.child("Coordinators").getValue().toString();
                                coordinators.setText(c);
                                organizationT.setText("•");
                                o=d1.child("Organization").getValue().toString();
                                organization.setText(o);
                                l=d1.child("Links").getValue().toString();
                                links.setText(l);
                                years.setText(year);
                            }
                            break;
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    public void database_access(){
        progress=new ProgressDialog(EventsDetails.this);
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
