package com.jenb.ntdat.appdoctruyen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class ChapterAdapter extends ArrayAdapter<String> {

    public ChapterAdapter(Context context, List<String> chapters) {
        super(context, 0, chapters);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_chapter, parent, false);

        TextView txtChapter = convertView.findViewById(R.id.txtChapter);
        txtChapter.setText(getItem(position));
        return convertView;
    }
}

