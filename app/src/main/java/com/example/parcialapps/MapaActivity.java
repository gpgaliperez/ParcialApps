package com.example.parcialapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;
/*import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;*/

public class MapaActivity extends FragmentActivity implements OnMapReadyCallback {//extends AppCompatActivity {
    private GoogleMap mMap;
    private ArrayList<String> lugares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);


        Intent in= getIntent();
        Bundle b = in.getExtras();
        if(b!=null)
        {
            lugares = getIntent().getStringArrayListExtra("test");
            String j =(String) b.get("lugares");
            lugares.add(j);
        }

        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        actualizarMapa();
    }
    private void actualizarMapa() {
        if (ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    9999);
            return;
        }
        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(-31.620816, -60.747582))
                .title("Tu lugar elegido +  lugares.get(0)")
                .snippet(lugares.get(0)));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String
            permissions[], int[] grantResults) {
        switch (requestCode) {
            case 9999: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    actualizarMapa();
                }
            }
        }
    }


}