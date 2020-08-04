package com.example.bridginghealthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.appandroid.R;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Actiity_Maps extends AppCompatActivity implements OnMapReadyCallback {

    private double latitude;
    private double longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actiity__maps);

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.mapa);
        mapFragment.getMapAsync(this);



        Intent it = getIntent();
        if (it != null){

            this.latitude = it.getDoubleExtra("latitude",-21.1875179);
            this.longitude = it.getDoubleExtra("longitude",-47.8336921);
        }else{
            //FATEC-RP
            this.latitude = -21.1875179;
            this.longitude = -47.8336921;
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(Actiity_Maps.this, MenuActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        CameraUpdate cam = CameraUpdateFactory.newLatLngZoom(
                new LatLng(this.latitude, this.longitude),
                16
        );

        googleMap.addMarker(new MarkerOptions().position(new LatLng(this.latitude, this.longitude)).title("Estou aqui!"));
        googleMap.moveCamera(cam);
        googleMap.animateCamera(cam);
    }
}
