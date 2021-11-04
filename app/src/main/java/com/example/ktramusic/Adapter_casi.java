package com.example.ktramusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter_casi extends BaseAdapter {


    Context mContext;
    int mLayout;
    List<list_casi> mList_casi;


    Adapter_casi(Context Context, int Layout, List<list_casi> List_casi) {
        mContext = Context;
        mLayout = Layout;
        mList_casi = List_casi;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater !=null;
        convertView = inflater.inflate(mLayout,null);

        TextView txt_tencasi = (TextView)convertView.findViewById(R.id.txt_casi);
        txt_tencasi.setText(mList_casi.get(position).ten_casi);
        return convertView;
    }
}
