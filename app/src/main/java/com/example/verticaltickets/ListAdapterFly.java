package com.example.verticaltickets;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ListAdapterFly extends BaseAdapter {

    private Context fcontext;
    private List<AdapterFly> fadapterlist;

    public ListAdapterFly(Context fcontext, List<AdapterFly> fadapterlist) {
        this.fcontext = fcontext;
        this.fadapterlist = fadapterlist;
    }

    @Override
    public int getCount() {
        return fadapterlist.size();
    }

    @Override
    public Object getItem(int i) {
        return fadapterlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(fcontext,R.layout.customlistview,null);

        TextView tvFrom = (TextView)v.findViewById(R.id.Ffrom);
        TextView tvTo = (TextView)v.findViewById(R.id.Fto);
        TextView tvDate = (TextView)v.findViewById(R.id.Fdate);
        TextView tvTime = (TextView)v.findViewById(R.id.Ftime);
        TextView tvCost = (TextView)v.findViewById(R.id.Fcost);

        tvFrom.setText(fadapterlist.get(i).getF_from());
        tvTo.setText(fadapterlist.get(i).getF_to());
        tvDate.setText(fadapterlist.get(i).getF_date());
        tvTime.setText(fadapterlist.get(i).getF_time());
        tvCost.setText(fadapterlist.get(i).getF_cost());

        return v;
    }
}
