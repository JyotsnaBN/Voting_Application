package com.example.myvotingapplication.model;

public class Data {
    String key, voter_id, password, voted;

    public Data(){}
    public Data(String key, String voter_id, String password, String voted)
    {
        this.key = key;
        this.voter_id = voter_id;
        this.password = password;
        this.voted = voted;
    }
    public String getVoter_id(){ return voter_id;}
    public String getKey(){ return  key;}
    public String getPassword(){return password;}
    public String getVoted(){ return voted;}
}
