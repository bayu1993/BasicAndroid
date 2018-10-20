package io.github.bayu1993.androidbasic.activity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import io.github.bayu1993.androidbasic.R;
import io.github.bayu1993.androidbasic.data.Constanta;
import io.github.bayu1993.androidbasic.data.model.PariwisataModel;

public class LocationActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private PariwisataModel pariwisataModel;
    private double longitude, latitude;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        pariwisataModel = getIntent().getParcelableExtra(Constanta.KEY_ADDRESS);
        try {
            getCoordinate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        Objects.requireNonNull(mapFragment).getMapAsync(this);
        Objects.requireNonNull(getSupportActionBar()).setTitle(pariwisataModel.getNama_pariwisata());
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private void getCoordinate() throws IOException {
        Geocoder geocoder = new Geocoder(this);
        List<Address> addresses;
        addresses = geocoder.getFromLocationName(pariwisataModel.getAlamat_pariwisata(), 1);
        if (addresses.size() > 0) {
            latitude = addresses.get(0).getLatitude();
            longitude = addresses.get(0).getLongitude();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng pariwisataLocation = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(pariwisataLocation)
                .title(pariwisataModel.getNama_pariwisata()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(pariwisataLocation));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(10), 2000, null);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
