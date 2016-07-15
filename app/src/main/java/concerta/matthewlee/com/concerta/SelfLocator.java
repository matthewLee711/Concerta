package concerta.matthewlee.com.concerta;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;


import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Matthew on 7/15/2016.
 */
public class SelfLocator {
    Context mContext;
    private Location location;
    private LocationManager lm;
    public double lat;
    public double lng;
    public SelfLocator(Context mContext) {
        this.mContext = mContext;
    }

    //Request user permission for location
    private void getLocation() {
        //Checks user permission
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            lm = (LocationManager)mContext.getSystemService(Context.LOCATION_SERVICE);
            location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            //Retrieve user coordinates
            if(location != null) {
                lat = location.getLatitude();
                lng = location.getLongitude();
            }
        }
        else {
            //permission not working
            //Toast toast = Toast.makeText(this, "stuff", Toast.LENGTH_SHORT);
            //toast.show();
        }

    }


    //Get current location
    public void updateLocation(Location location) {
        getLocation();
    }

    //Determines if to update location
    private boolean isBetterLocation(Location currentLoc, Location newLoc) {
        //Have a location is better than none
        if(currentLoc == null) {
            return true;
        }




        return true;
    }





}
