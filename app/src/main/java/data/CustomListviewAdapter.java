package data;

import android.app.Activity;
import android.content.Context;
import android.net.Network;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import concerta.matthewlee.com.concerta.AppController;
import concerta.matthewlee.com.concerta.R;
import model.Event;

/**
 * Created by Matthew on 7/14/2016.
 */
public class CustomListviewAdapter extends ArrayAdapter<Event> {
    private LayoutInflater inflater;
    private ArrayList<Event> data;
    private Activity mContext;
    private int layoutResourceId;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public CustomListviewAdapter(Activity context, int resource, ArrayList<Event> objs) {
        super(context, resource, objs);
        data = objs;
        mContext = context;
        layoutResourceId = resource;
    }


    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getPosition(Event item) {
        return super.getPosition(item);
    }

    @Override
    public Event getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() { //get size of arraylist which contains all events
        return data.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {//p1
        View row = convertView;
        ViewHolder viewHolder = null;

        //Get view for app if null
        if(row == null) {
            inflater = LayoutInflater.from(mContext);
            row = inflater.inflate(layoutResourceId, parent, false);//holds layout

            viewHolder = new ViewHolder();

            //get references to views
            viewHolder.bandImage = (NetworkImageView)row.findViewById(R.id.bandImage);
            viewHolder.headliner = (TextView)row.findViewById(R.id.headLinerText);
            viewHolder.venue = (TextView)row.findViewById(R.id.venueText);
            viewHolder.when = (TextView)row.findViewById(R.id.whenText);
            viewHolder.where = (TextView)row.findViewById(R.id.whereText);

            row.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)row.getTag();
        }

        viewHolder.event = data.get(position);

        //Display data
        viewHolder.headliner.setText("Headliner: " + viewHolder.event.getHeadLiner());
        viewHolder.venue.setText("Venue: " + viewHolder.event.getVenueName());
        viewHolder.when.setText("When: " + viewHolder.event.getStartDate());
        viewHolder.where.setText("Where: " + viewHolder.event.getStreet() + ", " +
                viewHolder.event.getCity() + ", " + viewHolder.event.getCountry());
        viewHolder.bandImage.setImageUrl(viewHolder.event.getUrl(), imageLoader);
        viewHolder.website = viewHolder.event.getWebsite();



        return row;
    }

    //Insert all text views, image views, and event class in here
    //When we create custom list views, they are recycled -- good for performance
    public class ViewHolder {
        Event event;
        TextView headliner;
        TextView venue;
        TextView where;
        TextView when;
        String website;
        NetworkImageView bandImage;

    }


}
