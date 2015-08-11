package com.newtest.novusapp;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.newtest.novusapp.fragments.MyMarker;
import com.google.android.gms.location.LocationRequest;

import com.google.android.gms.maps.model.Marker;
import java.util.HashMap;
import java.util.ArrayList;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;

import android.content.IntentSender;
import android.widget.ImageView;
import android.widget.TextView;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class  MapsActivity extends FragmentActivity
{

    public GoogleMap mMap; // Might be null if Google Play services APK is not available.
    MapFragment mapFragment;
    //final String TAG = "myLogs";
    private HashMap<Marker, MyMarker> mMarkersHashMap;
    private ArrayList<MyMarker> mMyMarkersArray = new ArrayList<MyMarker>();

    private GoogleApiClient mGoogleApiClient;
    public static final String TAG = MapsActivity.class.getSimpleName();
    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 9000;
    private LocationRequest mLocationRequest;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen_two);

        // Initialize the HashMap for Markers and MyMarker object
        mMarkersHashMap = new HashMap<Marker, MyMarker>();

        mMyMarkersArray.add(new MyMarker("Kiev, Boulevard of Friendship of Peoples, 16A", "icon1", Double.parseDouble("50.414136"), Double.parseDouble("30.538932")));
        mMyMarkersArray.add(new MyMarker("Kiev Ring Road, 12", "icon2", Double.parseDouble("50.406248"), Double.parseDouble("30.397936")));
        mMyMarkersArray.add(new MyMarker("Kiev area Gostomelsky 1", "icon3", Double.parseDouble("50.497539"), Double.parseDouble("30.366753")));
        mMyMarkersArray.add(new MyMarker("Kiev, Prospect Bazhana Nicholas, 8", "icon4", Double.parseDouble("50.393633"), Double.parseDouble("30.611629")));
        mMyMarkersArray.add(new MyMarker("Kiev, Brovarsky Prospect, 17", "icon5", Double.parseDouble("50.453127"), Double.parseDouble("30.593834")));
        mMyMarkersArray.add(new MyMarker("Kyiv, Brovarsky Avenue, 18D", "icon6", Double.parseDouble("50.466861"), Double.parseDouble("30.654774")));
        mMyMarkersArray.add(new MyMarker("Kiev, Prospect Grigorenko Peter, 18", "icon7", Double.parseDouble("50.410834"), Double.parseDouble("30.625807")));
        mMyMarkersArray.add(new MyMarker("Kiev, Prospect Krasnozvezdny 4D", "icondefault", Double.parseDouble("50.422628"), Double.parseDouble("30.464117")));


        setUpMap();

        plotMarkers(mMyMarkersArray);
    }

    private void plotMarkers(ArrayList<MyMarker> markers)
    {
        if(markers.size() > 0)
        {
            for (MyMarker myMarker : markers)
            {// Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.currentlocation_icon));

                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);

                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
            }
        }
    }

    private int manageMarkerIcon(String markerIcon)
    {
        if (markerIcon.equals("icon1"))
            return R.drawable.novus2;
        else if(markerIcon.equals("icon2"))
            return R.drawable.novus2;
        else if(markerIcon.equals("icon3"))
            return R.drawable.novus2;
        else if(markerIcon.equals("icon4"))
            return R.drawable.novus2;
        else if(markerIcon.equals("icon5"))
            return R.drawable.novus2;
        else if(markerIcon.equals("icon6"))
            return R.drawable.novus2;
        else if(markerIcon.equals("icon7"))
            return R.drawable.novus2;
        else
            return R.drawable.novus2;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void setUpMap()
    {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null)
        {// Try to obtain the map from the SupportMapFragment.
            mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

            // Check if we were successful in obtaining the map.

            if (mMap != null)
            {
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
                {
                    @Override
                    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker)
                    {
                        marker.showInfoWindow();
                        return true;
                    }
                });
            }
            else
                Toast.makeText(getApplicationContext(), "Unable to create Maps", Toast.LENGTH_SHORT).show();
        }
    }

    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter
    {
        public MarkerInfoWindowAdapter()
        {
        }

        @Override
        public View getInfoWindow(Marker marker)
        {
            return null;
        }
        @Override
         public View getInfoContents(Marker marker)
    {
        View v  = getLayoutInflater().inflate(R.layout.infowindow_layout, null);

        MyMarker myMarker = mMarkersHashMap.get(marker);

        ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);

        TextView markerLabel = (TextView)v.findViewById(R.id.marker_label);

        markerIcon.setImageResource(manageMarkerIcon(myMarker.getmIcon()));

        markerLabel.setText(myMarker.getmLabel());

        return v;
    }
    }

}
