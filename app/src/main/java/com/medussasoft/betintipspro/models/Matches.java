package com.medussasoft.betintipspro.models;

/**
 * Created by Kevin Gitonga on 6/18/2016.
 */


public class Matches {

    private String HomeTeam;
    private String AwayTeam;
    private  String League;
    private String MatchTime;
    private String HomeScore;
    private String AwayScore;
    private String MatchStatus;
    private String prediction;
    private double Odds;
    private String MatchDate;
    private int MatchId;
    private String LogoUrl;


    public Matches() {

    }


    public String getHomeTeam() {
        return HomeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.HomeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return AwayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.AwayTeam = awayTeam;
    }

    public String getLeague() {
        return League;
    }

    public void setLeague(String league) {
        this.League = league;
    }

    public String getMatchTime() {
        return MatchTime;
    }

    public void setMatchTime(String matchTime) {
       this.MatchTime = matchTime;
    }

    public String getHomeScore() {
        return HomeScore;
    }

    public void setHomeScore(String homeScore) {
        this.HomeScore = homeScore;
    }

    public String getAwayScore() {
        return AwayScore;
    }

    public void setAwayScore(String awayScore) {
        this.AwayScore = awayScore;
    }

    public String getMatchStatus() {
        return MatchStatus;
    }

    public void setMatchStatus(String matchStatus) {
        this.MatchStatus = matchStatus;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public double getOdds() {
        return Odds;
    }

    public void setOdds(double odds) {
        this.Odds = odds;
    }

    public String getMatchDate() {
        return MatchDate;
    }

    public void setMatchDate(String matchDate) {
        this.MatchDate = matchDate;
    }

    public int getMatchId() {
        return MatchId;
    }

    public void setMatchId(int matchId) {
        this.MatchId = matchId;
    }

    public String getLogoUrl() {
        return LogoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.LogoUrl = logoUrl;
    }
}
