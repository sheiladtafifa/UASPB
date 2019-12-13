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

public class ListViewKoreanAdapter extends ArrayAdapter<KoreanDramaItem> {

    private List<KoreanDramaItem> koreanDramaItemList;

    private Context context;

    public ListViewKoreanAdapter(List<KoreanDramaItem> koreanDramaItemList, Context context) {
        super(context, R.layout.list_item_koreandrama, koreanDramaItemList);
        this.koreanDramaItemList = koreanDramaItemList;
        this.context = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item_koreandrama, null, true);

        TextView textViewDrama = listViewItem.findViewById(R.id.textViewDrama);
        ImageView imageKoreanDrama = listViewItem.findViewById(R.id.imageKoreanDrama);


        KoreanDramaItem koreanDramaItem = koreanDramaItemList.get(position);

        textViewDrama.setText(koreanDramaItem.getDrama());

        Glide.with(context).load(koreanDramaItem.getImage()).into(imageKoreanDrama);

        return listViewItem;
    }

}
