package com.example.tarun.auxilium;
        import android.os.Bundle;

/*package net.simplifiedcoding.androidtablayout;
*/
        import android.content.pm.PackageManager;
        import android.location.Criteria;
        import android.os.Bundle;

        import android.location.Criteria;
        import android.location.Location;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Bundle;
        import android.support.annotation.Nullable;
        import android.support.v4.app.ActivityCompat;
        import android.support.v4.app.FragmentActivity;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;


        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;


        import com.google.android.gms.common.ConnectionResult;
        import com.google.android.gms.common.GooglePlayServicesUtil;
        import com.google.android.gms.maps.CameraUpdateFactory;
        import com.google.android.gms.maps.GoogleMap;
        import com.google.android.gms.maps.SupportMapFragment;
        import com.google.android.gms.maps.model.LatLng;

//Our class extending fragment
public class Tab3 extends Fragment implements LocationListener
{
    View v;
    private static final String GOOGLE_API_KEY = "AIzaSyCnQJGPFPzzOYGnDKLXBNB3cHUVGKHZ9oU";
    GoogleMap googleMap;
    EditText placeText;
    double latitude = 0;
    double longitude = 0;
    private int PROXIMITY_RADIUS = 5000;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.tab3, container, false);
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        if (!isGooglePlayServicesAvailable()) {
            getActivity().finish();
        }

        getActivity().setContentView(R.layout.activity_maps);

        placeText = (EditText)v.findViewById(R.id.editText1324);
        Button btnFind = (Button)v.findViewById(R.id.btn_find1234);
        SupportMapFragment fragment = (SupportMapFragment)getActivity().getSupportFragmentManager().findFragmentById(R.id.map);
        googleMap = fragment.getMap();
        googleMap.setMyLocationEnabled(true);
        LocationManager locationManager = (LocationManager)getActivity().getSystemService(getActivity().LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String bestProvider = locationManager.getBestProvider(criteria, true);
        Location location = locationManager.getLastKnownLocation(bestProvider);
        if (location != null) {
            onLocationChanged(location);
        }
        if (ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(bestProvider, 20000, 0, this);

        btnFind.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String type = placeText.getText().toString();
                StringBuilder googlePlacesUrl = new StringBuilder("https://maps.googleapis.com/maps/api/place/nearbysearch/json?");
                googlePlacesUrl.append("location=" + latitude + "," + longitude);
                googlePlacesUrl.append("&radius=" + PROXIMITY_RADIUS);
                googlePlacesUrl.append("&types=" + type);
                googlePlacesUrl.append("&sensor=true");
                googlePlacesUrl.append("&key=" + GOOGLE_API_KEY);

                GooglePlacesReadTask googlePlacesReadTask = new GooglePlacesReadTask();
                Object[] toPass = new Object[2];
                toPass[0] = googleMap;
                toPass[1] = googlePlacesUrl.toString();
                googlePlacesReadTask.execute(toPass);
            }
        });
    }

    private boolean isGooglePlayServicesAvailable() {
        int status = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getActivity());
        if (ConnectionResult.SUCCESS == status) {
            return true;
        } else {
            GooglePlayServicesUtil.getErrorDialog(status, getActivity(), 0).show();
            return false;
        }
    }


    @Override
    public void onLocationChanged(Location location) {
        latitude = location.getLatitude();
        longitude = location.getLongitude();
        LatLng latLng = new LatLng(latitude, longitude);
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(12));
    }

    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
        // TODO Auto-generated method stub
    }



}

