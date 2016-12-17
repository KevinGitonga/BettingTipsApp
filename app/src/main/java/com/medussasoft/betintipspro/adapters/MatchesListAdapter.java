package com.medussasoft.betintipspro.adapters;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.medussasoft.betintipspro.MainActivity;
import com.medussasoft.betintipspro.R;
import com.medussasoft.betintipspro.models.Matches;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Kevin Gitonga on 6/18/2016.
 */
public class MatchesListAdapter extends RecyclerView.Adapter<MatchesListAdapter.ViewHolder> {
    Context mContext;
    List<Matches> Matchdata;

    public MatchesListAdapter(MainActivity mainActivity, List<Matches> matchdata) {

        this.mContext=mainActivity;
        this.Matchdata=matchdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
     if (Build.VERSION.SDK_INT <21){

         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_listview,null);
     }else {
         view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_listview_post,null);
     }

        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Matches matches=Matchdata.get(position);
        holder.HomeTeamTV.setText(matches.getHomeTeam());
        Picasso.with(mContext).load(matches.getLogoUrl()).into(holder.LeagueImg);
        holder.AwayTeamTV.setText(matches.getAwayTeam());
        String MatchTime=(String.valueOf(matches.getMatchTime()));
        String matchTime = MatchTime.substring(0,5);
        holder. MatchTimeTV.setText(matchTime);
        holder.AwayScoreTV.setText((matches.getAwayScore()));


        String date=matches.getMatchDate();

        holder.MatchDateTV.setText(date);


        holder.OddsTV.setText(String.valueOf(matches.getOdds()));
        holder. MatchidTV.setText(String.valueOf(matches.getMatchId()));

        if(matches.getHomeScore().equals("-1")){
            holder.HomeScoreTV.setText("_");
        }else {
            holder.HomeScoreTV.setText((matches.getHomeScore()));
        }
        if(matches.getAwayScore().equals("-1")){
            holder.AwayScoreTV.setText("_");
        }else{
            holder.HomeScoreTV.setText((matches.getHomeScore()));
        }


        if(matches.getMatchStatus().equals("won")){


            holder.WonLostimg.setImageResource(R.drawable.correct_won);
            holder.PredictionTV.setTextColor(Color.parseColor("#2ecc71"));
            holder.OddsTV.setTextColor(Color.parseColor("#2ecc71"));

        }else if(matches.getMatchStatus().equals("lost")) {
            holder.WonLostimg.setImageResource(R.drawable.false_lost);
            holder.PredictionTV.setTextColor(Color.parseColor("#c0392b"));
            holder.OddsTV.setTextColor(Color.parseColor("#c0392b"));

        }else if(matches.getMatchStatus().equals("pending")){
            holder.WonLostimg.setImageResource(R.drawable.pending_game);
           holder.PredictionTV.setTextColor(Color.parseColor("#3498db"));
            holder.OddsTV.setTextColor(Color.parseColor("#3498db"));

        }else if(matches.getMatchStatus().equals("cancelled")) {
            holder.WonLostimg.setImageResource(R.drawable.pending_game);
            holder.PredictionTV.setTextColor(Color.GRAY);
            holder.OddsTV.setTextColor(Color.GRAY);


        }}

    @Override
    public int getItemCount() {
        return Matchdata.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView HomeTeamTV;
        TextView AwayTeamTV;
        TextView HomeScoreTV;
        TextView MatchTimeTV;
        TextView AwayScoreTV;
        TextView PredictionTV;
        TextView OddsTV;
        TextView MatchidTV;
        TextView MatchDateTV;
        ImageView LeagueImg;
        ImageView WonLostimg;
        public ViewHolder(View listViewItem) {
            super(listViewItem);
            this.HomeTeamTV = (TextView) listViewItem.findViewById(R.id.hostNameTV);
            this.AwayTeamTV = (TextView) listViewItem.findViewById(R.id.AwayNameTV);
            this.HomeScoreTV = (TextView) listViewItem.findViewById(R.id.HomeScoreTV);
            this.WonLostimg= (ImageView) listViewItem.findViewById(R.id.WinLoseImg);
            this.MatchTimeTV = (TextView) listViewItem.findViewById(R.id.matchTimeTV);
           this .AwayScoreTV = (TextView) listViewItem.findViewById(R.id.AwayScoreTV);
            this.PredictionTV = (TextView) listViewItem.findViewById(R.id.GamePrediction);
            this.OddsTV = (TextView) listViewItem.findViewById(R.id.OddstextView);
            this. MatchidTV = (TextView) listViewItem.findViewById(R.id.MatchidTV);
            this.MatchDateTV = (TextView) listViewItem.findViewById(R.id.MatchDatetv);
            this.LeagueImg= (ImageView) listViewItem.findViewById(R.id.LeagueMatchImg);

        }
    }
}































/*

*//*
        RecyclerView.ViewHolder localViewHolder;
        if (listViewItem==null) {
            localViewHolder=new RecyclerView.ViewHolder();
            mInflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            listViewItem = mInflater.inflate(R.layout.row_listview,null);
            localViewHolder.HomeTeamTV = (TextView) listViewItem.findViewById(R.id.hostNameTV);
           localViewHolder.AwayTeamTV = (TextView) listViewItem.findViewById(R.id.AwayNameTV);
            localViewHolder.HomeScoreTV = (TextView) listViewItem.findViewById(R.id.HomeScoreTV);
            localViewHolder.WonLostimg= (ImageView) listViewItem.findViewById(R.id.WinLoseImg);
            localViewHolder.MatchTimeTV = (TextView) listViewItem.findViewById(R.id.matchTimeTV);
            localViewHolder.AwayScoreTV = (TextView) listViewItem.findViewById(R.id.AwayScoreTV);
            localViewHolder.PredictionTV = (TextView) listViewItem.findViewById(R.id.GamePrediction);
            localViewHolder.OddsTV = (TextView) listViewItem.findViewById(R.id.OddstextView);
            localViewHolder.LeagueImg = (NetworkImageView) listViewItem.findViewById(R.id.LeagueMatchImg);
           localViewHolder. MatchidTV = (TextView) listViewItem.findViewById(R.id.MatchidTV);
           localViewHolder. MatchDateTV = (TextView) listViewItem.findViewById(R.id.MatchDatetv);
            listViewItem.setTag(localViewHolder);

        }else {
            localViewHolder = (ViewHolder)listViewItem.getTag();
        }

            Matches matches = Matchdata.get(position);
           Picasso.with(mContext).load(matches.getLogoUrl()).into(localViewHolder.LeagueImg);
           localViewHolder.HomeTeamTV.setText(matches.getHomeTeam());
           localViewHolder.AwayTeamTV.setText(matches.getAwayTeam());

           String MatchTime=(String.valueOf(matches.getMatchTime()));
            String matchTime = MatchTime.substring(0, 3);
           localViewHolder. MatchTimeTV.setText(matchTime);

            localViewHolder.AwayScoreTV.setText((matches.getAwayScore()));
        localViewHolder. MatchDateTV.setText(String.valueOf(matches.getMatchDate()));
        localViewHolder.OddsTV.setText(String.valueOf(matches.getOdds()));
        localViewHolder. MatchidTV.setText(String.valueOf(matches.getMatchId()));
        if(matches.getHomeScore().equals("null")){
            localViewHolder.HomeScoreTV.setText("_");
        }else {
            localViewHolder.HomeScoreTV.setText((matches.getHomeScore()));
        }
        if(matches.getAwayScore().equals("null")){
            localViewHolder.AwayScoreTV.setText("_");
        }else{
            localViewHolder.HomeScoreTV.setText((matches.getHomeScore()));
        }


            if(matches.getMatchStatus().equals("won")){


                localViewHolder.WonLostimg.setImageResource(R.drawable.correct_won);
                localViewHolder.PredictionTV.setTextColor(Color.parseColor("#2ecc71"));
                localViewHolder.OddsTV.setTextColor(Color.parseColor("#2ecc71"));

            }else if(matches.getMatchStatus().equals("lost")) {
                localViewHolder.WonLostimg.setImageResource(R.drawable.false_lost);
                localViewHolder.PredictionTV.setTextColor(Color.parseColor("#c0392b"));
                localViewHolder.OddsTV.setTextColor(Color.parseColor("#c0392b"));
                return listViewItem;
            }else if(matches.getMatchStatus().equals("pending")){
                localViewHolder.WonLostimg.setImageResource(R.drawable.pending_game);
                localViewHolder.PredictionTV.setTextColor(Color.parseColor("#3498db"));
                localViewHolder.OddsTV.setTextColor(Color.parseColor("#3498db"));
                return  listViewItem;
            }else if(matches.getMatchStatus().equals("cancelled")){
                localViewHolder.WonLostimg.setImageResource(R.drawable.pending_game);
                localViewHolder.PredictionTV.setTextColor(Color.GRAY);
                localViewHolder.OddsTV.setTextColor(Color.GRAY);
            }*//*

            //String Reverse=(matches.getMatchDate());
           //String MatchdateString=new StringBuffer(Reverse).reverse().toString();





        return listViewItem;
    }
      class ViewHolder

    {
        TextView HomeTeamTV;
        TextView AwayTeamTV;
        TextView HomeScoreTV;
        TextView MatchTimeTV;
        TextView AwayScoreTV;
        TextView PredictionTV;
        TextView OddsTV;
        TextView MatchidTV;
        TextView MatchDateTV;
        NetworkImageView LeagueImg;
        ImageView WonLostimg;
    }
}*/

