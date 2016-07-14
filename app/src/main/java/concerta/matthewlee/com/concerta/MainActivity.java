package concerta.matthewlee.com.concerta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import data.CustomListviewAdapter;
import model.Event;

public class MainActivity extends AppCompatActivity {
    private CustomListviewAdapter adapter;
    private ArrayList<Event> events = new ArrayList<>();
    private String urlLeft = "https://app.ticketmaster.com/discovery/v2/events.json?classificationName=music&dmaId=";
    private String urlCity = "";
    private String urlRight = "&apikey=2qTYBG5PfFezVUGhGoKW1EaYdMHzw313";
    private ListView listView;
    private TextView selectedCity;

    private String url ="https://app.ticketmaster.com/discovery/v2/events.json?classificationName=music&dmaId=324&apikey=2qTYBG5PfFezVUGhGoKW1EaYdMHzw313";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getEvents("Portland");

    }

    private void getEvents(String city) {
        //clear data from arraylist first
        events.clear();

        final String finalUrl = urlLeft + city + urlRight;//MAIN. NEED CTY CONVERTER

        JsonObjectRequest eventsRequest = new JsonObjectRequest(Request.Method.GET,
                url, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {//BIG POSSIBLE ERRORS
                try { //Gets all events
                    JSONObject eventReceived = response.getJSONObject("_embedded");

                    JSONArray eventsArray = eventReceived.getJSONArray("events");

                    for(int i = 1; i < eventsArray.length(); i++) {
                        JSONObject event = eventsArray.getJSONObject(i);//grab specific event
                        //Get artists
                    }



                    //Log.v("Data: ", eventsObject.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        AppController.getInstance().addToRequestQueue(eventsRequest);

    }














    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
