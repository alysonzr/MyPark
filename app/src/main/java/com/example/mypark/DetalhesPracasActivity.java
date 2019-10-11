package com.example.mypark;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.location.Location;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import java.lang.Math;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;


public class DetalhesPracasActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private Location location;

 private Double latitudeUsuario;
 private Double longitudeUsuario;
 private Double result;

    private  GoogleApiClient mGoogleApiClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_pracas);


         callConnection();


        TextView textviewSkat1 = (TextView) findViewById(R.id.textviewSkat1);
        TextView textviewSkat2 = (TextView) findViewById(R.id.textviewSkat2);

        Intent i = getIntent();
        Bundle p = i.getExtras();
        String facilits = p.getString("chave");


        ConverteLatitude(latitudeUsuario,longitudeUsuario,"-29.926859","-51.039984");

        if (facilits.equals("skate")) {

            textviewSkat1.setText("Praça do Tuiuti e Skate Park"+ getResult());

            textviewSkat2.setText("Praça velha morada do vale 1");

        }

        if (facilits.equals("AreaCrianca")) {
            textviewSkat1.setText("Praça Morada do vale 3");

            textviewSkat2.setText("Praça velha morada do vale 1");
        }


    }

    private synchronized void callConnection() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    // LISTENER
    @Override
    public void onConnected(Bundle bundle) {
        Log.i("LOG", "onConnected(" + bundle + ")");

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        } else {
            Location l = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);

            if (l != null) {
                latitudeUsuario = l.getLatitude();
                longitudeUsuario = l.getLongitude();
                Log.i("LOG", "latitude: " + l.getLatitude());
                Log.i("LOG", "longitude: " + l.getLongitude());
            }
        }
    }


    @Override
    public void onConnectionSuspended(int i) {
        Log.i("LOG", "onConnectionSuspended(" + i + ")");
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.i("LOG", "onConnectionFailed("+connectionResult+")");
    }

    public void ConverteLatitude(Double latitude1, Double logitude1, String latitude2, String logitude2) {

        final int R = 6371; // Radious of the earth
        Double lat1 = latitude1;
        Double lon1 = logitude1;
        Double lat2 = Double.parseDouble(latitude2);
        Double lon2 = Double.parseDouble(logitude2);
        Double latDistance = toRad(lat2 - lat1);
        Double lonDistance = toRad(lon2 - lon1);
        Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
                        Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        Double distance = R * c;
        result = distance;
        Log.i("LOG", "distancia: " + distance);
    }

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }


    public Double getLatitudeUsuario() {
        return latitudeUsuario;
    }

    public void setLatitudeUsuario(Double latitudeUsuario) {
        this.latitudeUsuario = latitudeUsuario;
    }

    public Double getLongitudeUsuario() {
        return longitudeUsuario;
    }

    public void setLongitudeUsuario(Double longitudeUsuario) {
        this.longitudeUsuario = longitudeUsuario;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}




