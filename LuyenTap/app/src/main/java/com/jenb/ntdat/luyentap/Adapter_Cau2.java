package com.jenb.ntdat.luyentap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_Cau2 extends BaseAdapter {

    Context context;
    int layout;
    List<ListViewCuaCaiGiDo> dsItem;

    public Adapter_Cau2(Context context, int layout, List<ListViewCuaCaiGiDo> dsItem) {
        this.context = context;
        this.layout = layout;
        this.dsItem = dsItem;
    }

    @Override
    public int getCount() {
        return dsItem.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);
        ListViewCuaCaiGiDo item = dsItem.get(i);

        TextView tvTenItem = view.findViewById(R.id.NameCau2);
        TextView tvNoiDungItem = view.findViewById(R.id.CaptionCau2);
        ImageView imgItem = view.findViewById(R.id.imgCau2);

        tvTenItem.setText(item.getTenItem());
        tvNoiDungItem.setText(item.getNoiDungItem());
        imgItem.setImageResource(item.getAnhItem());

        return view;
    }
}
