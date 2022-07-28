package com.shubham.newsapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.shubham.newsapp.R;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class GridCategoryAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    List<DemoCategory> demoCategories;

    // constructor


    public GridCategoryAdapter(Context context) {
        this.context = context;
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        demoCategories = new ArrayList<>();

        demoCategories.add(new DemoCategory(R.drawable.icn1,"Basics"));
        demoCategories.add(new DemoCategory(R.drawable.icn2,"Logic"));
        demoCategories.add(new DemoCategory(R.drawable.icn3,"Android"));
        demoCategories.add(new DemoCategory(R.drawable.ic4,"Database"));
        demoCategories.add(new DemoCategory(R.drawable.icn5,"Binary"));
        demoCategories.add(new DemoCategory(R.drawable.icn6,"Components"));
        demoCategories.add(new DemoCategory(R.drawable.icn7,"Java"));
        demoCategories.add(new DemoCategory(R.drawable.icn8,"HTML"));

    }

    @Override
    public int getCount() {
        return demoCategories.size();
    }

    @Override
    public Object getItem(int position) {
        return demoCategories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder = null;

       if(convertView == null){
           convertView = layoutInflater.inflate(R.layout.item_category,null);
           holder = new ViewHolder();
           holder.circleImageView = convertView.findViewById(R.id.category_img);
           holder.textView = convertView.findViewById(R.id.text_category);

           convertView.setTag(holder);
       }
       else{
           holder = (ViewHolder) convertView.getTag();

       }

       holder.textView.setText(demoCategories.get(position).imageName);

       Glide.with(context).load(demoCategories.get(position).ImageId)
               .centerCrop()
               .into(holder.circleImageView);

       return convertView;
    }

    static class ViewHolder{
        CircleImageView  circleImageView;
        TextView textView;
    }

    class DemoCategory{
        int ImageId;
        String imageName;

        public DemoCategory(int imageId, String imageName) {
            ImageId = imageId;
            this.imageName = imageName;
        }
    }

}
