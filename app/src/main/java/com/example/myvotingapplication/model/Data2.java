package com.example.myvotingapplication.model;

public class Data2 {

    String key,name;
    int no_votes;

    public Data2(){}
    public Data2(String key, String name, int no_votes)
    {
        this.key = key;
        this.name = name;
        this.no_votes = no_votes;
    }
    public String getParty(){ return name;}
    public String getKey(){ return  key;}
    public int getVotes(){ return no_votes;}

}
