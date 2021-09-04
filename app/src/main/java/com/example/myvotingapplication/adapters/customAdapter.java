package com.example.myvotingapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.myvotingapplication.R;
import com.example.myvotingapplication.model.Data;

import java.util.ArrayList;
public class customAdapter extends BaseAdapter {
    TextView voter_id, password, voted;
    Context context;
    ArrayList<Data> data;

    LayoutInflater inflater;
    public customAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.from(context).inflate(R.layout.custom_list,viewGroup,false);

        voter_id = view.findViewById(R.id.readVoterID);
        //password = view.findViewById(R.id.readPassword);
        voted = view.findViewById(R.id.readVoted);

        voter_id.setText(voter_id.getText() + data.get(i).getVoter_id());
        voted.setText(voted.getText() + " " +data.get(i).getVoted());

        return view;
    }
}
