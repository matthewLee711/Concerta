package Util;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Matthew on 7/14/2016.
 */
//Allows users to change city
public class Prefs {

    SharedPreferences preferences;

    public Prefs(Activity activity) {//preferences are tied to activities
        preferences = activity.getPreferences(Activity.MODE_PRIVATE);
    }

    public void setCity(String city) {
        preferences.edit().putString("city", city).commit();
    }

    //If user not choose city, choose default
    public String getCity() {
        return preferences.getString("city", "Dallas");
    }

}
