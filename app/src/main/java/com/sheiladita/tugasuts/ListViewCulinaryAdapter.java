package com.sheiladita.tugasuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ListViewCulinaryAdapter extends ArrayAdapter<CulinaryItem> {

    private List<CulinaryItem> culinaryItemList;

    private Context context;

    public ListViewCulinaryAdapter(List<CulinaryItem> culinaryItemList, Context context) {
        super(context, R.layout.list_item_culinary, culinaryItemList);
        this.culinaryItemList = culinaryItemList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item_culinary, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        ImageView imageCulinary = listViewItem.findViewById(R.id.imageCulinary);


        CulinaryItem culinaryItem = culinaryItemList.get(position);

        textViewName.setText(culinaryItem.getName());

        Glide.with(context).load(culinaryItem.getImage()).into(imageCulinary);

        return listViewItem;
    }
}
