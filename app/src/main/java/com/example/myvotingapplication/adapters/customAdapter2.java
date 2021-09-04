package com.example.myvotingapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.myvotingapplication.R;
import com.example.myvotingapplication.model.Data2;

import java.util.ArrayList;
public class customAdapter2 extends BaseAdapter {
    TextView name, no_votes;
    Context context;
    ArrayList<Data2> data2;

    LayoutInflater inflater;
    public customAdapter2(Context context, ArrayList<Data2> data2) {
        this.context = context;
        this.data2 = data2;
    }

    @Override
    public int getCount() {
        return data2.size();
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
    public View getView(int i, View view1, ViewGroup viewGroup) {
        view1 = inflater.from(context).inflate(R.layout.custom_list2,viewGroup,false);

        name = view1.findViewById(R.id.readPartyName);
        //password = view.findViewById(R.id.readPassword);
        no_votes = view1.findViewById(R.id.readVotes);

        name.setText(name.getText() + data2.get(i).getParty());
        //name.setText("Party1");
        no_votes.setText(no_votes.getText() + " " +data2.get(i).getVotes());

        return view1;
    }
}
