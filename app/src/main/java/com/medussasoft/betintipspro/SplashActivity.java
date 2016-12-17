package com.medussasoft.betintipspro;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.medussasoft.betintipspro.config.Config;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Kevin Gitonga on 5/31/2016.
 */
public class SplashActivity extends AppCompatActivity {


    private int NORMAL_RESPONSE_SIZE = 0;
    private int SUCCESS_RESPONSE_SIZE = 0;
    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);
        requestQueue = Volley.newRequestQueue(this, 80);
        if (IsNeton()) {
            getMatches();

        }

    }

    private void getMatches() {

        StringRequest matchesRequest = new StringRequest(Config.RestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("games", response.toString());
                String MatchesArray = response.toString();

                if (MatchesArray.length() > NORMAL_RESPONSE_SIZE && MatchesArray.length() > SUCCESS_RESPONSE_SIZE) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    intent.putExtra("matches", MatchesArray);
                    startActivity(intent);

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
        requestQueue.add(matchesRequest);
        matchesRequest.setRetryPolicy(new DefaultRetryPolicy(20000, 1, 1.0F));


    }

    public boolean IsNeton() {

        ConnectivityManager connMan = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = connMan.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {

            return true;

        } else {
            SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(SplashActivity.this, SweetAlertDialog.ERROR_TYPE);
            sweetAlertDialog.setTitleText("Error!");
            sweetAlertDialog.setContentText("An Error occured, please check network connection and try again.");
            sweetAlertDialog.setConfirmText("Ok");
            sweetAlertDialog.setCancelable(false);
            sweetAlertDialog.show();
            sweetAlertDialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {

                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    SplashActivity.this.finish();
                }
            });
        }

        return false;

    }










    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }




}










