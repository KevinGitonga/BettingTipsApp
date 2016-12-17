package com.medussasoft.betintipspro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.medussasoft.betintipspro.adapters.MatchesListAdapter;
import com.medussasoft.betintipspro.config.Config;
import com.medussasoft.betintipspro.models.Matches;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
   List<Matches> Matchdata = new ArrayList<>();
    MatchesListAdapter matchesAdapter;
    RecyclerView MatchesList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        MobileAds.initialize(getApplicationContext(),"@string/footer_banner_ad");
        FetchMatches();
        showAd();
        matchesAdapter =new MatchesListAdapter(this,Matchdata);
        MatchesList = (RecyclerView) findViewById(R.id.recycler_view);
        MatchesList.setLayoutManager(new LinearLayoutManager(this));
        MatchesList.setAdapter(matchesAdapter);
        Backendless.initApp(this,Config.Backendless_app_id,Config.Backendless_secret_key,"v1");
        Backendless.Messaging.registerDevice(Config.gcm_id, new AsyncCallback<Void>() {
            @Override
            public void handleResponse(Void response) {
                Log.e("BETINTIPS","device was registered");
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Log.e("BETINTIPS","an error occured"+ fault.getMessage());

            }
        });


    }

    private void showAd() {
        AdView adView = (AdView)this.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("917576A8E42AF7E1751AB740FB5C64C1").build();
        adView.loadAd(adRequest);
    }

    private void FetchMatches() {
        String MatchesArray=getIntent().getStringExtra("matches");
        Log.e("fromintent",MatchesArray);

        JSONObject MatchDat;
        JSONArray jsonArray;


        try {
            MatchDat = new JSONObject(MatchesArray);


            jsonArray = MatchDat.getJSONArray("matches");
            Log.e("matchesfromjobjectnode",jsonArray.toString());





        for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject obj = jsonArray.getJSONObject(i);
                Matches newMatch = new Matches();

                newMatch.setHomeTeam(obj.getString("Home_team"));
                newMatch.setAwayTeam(obj.getString("Away_team"));
                newMatch.setHomeScore(obj.getString("Home_score"));
                newMatch.setLeague(obj.getString("League_name"));
                newMatch.setOdds(obj.getDouble("Odds"));
                newMatch.setAwayScore(obj.getString("Away_score"));
                newMatch.setMatchTime(obj.getString("Match_time"));
                newMatch.setMatchStatus(obj.getString("Match_status"));
                newMatch.setPrediction(obj.getString("prediction"));
                newMatch.setMatchId(obj.getInt("Match_id"));
                newMatch.setMatchDate(obj.getString("Match_date"));
                newMatch.setLogoUrl(obj.getString("League_logo"));
                Log.e("matchy",obj.getString("Home_team"));
                Matchdata.add(newMatch);



            }
        }catch (JSONException e) {
                e.printStackTrace();
            }





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id==R.id.action_about){
            Intent intent=new Intent(MainActivity.this,AboutActivity.class);
            startActivity(intent);
        }else if (id ==R.id.action_share){
            ShareApp();
        }



        return super.onOptionsItemSelected(item);
    }

    private void ShareApp() {


        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out this app it helped me win bets for once:https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
