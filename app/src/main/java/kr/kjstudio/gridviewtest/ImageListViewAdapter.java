package kr.kjstudio.gridviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.cache.ExternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.module.GlideModule;

import java.util.ArrayList;

/**
 * Created by KJ-Studio-01 on 2016-06-02.
 */
public class ImageListViewAdapter extends ArrayAdapter<String> {


    Context mContext;
    ArrayList<String> mList;
    LayoutInflater inf;

    public ImageListViewAdapter(Context context, ArrayList<String> list) {
        super(context, R.layout.gallery_list_item, R.id.titleTxt, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView row = (ListItemView) convertView;

        if (row == null) {
            row = new ListItemView(mContext);

        }
        try {
            String path1 = mList.get(position * 6);

            if (!path1.equals(row.path1)) {
                Glide.with(mContext).load(path1)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .dontAnimate()
                        .centerCrop().thumbnail(0.3f).into(row.thumbImage1);
                row.path1 = path1;
            }

            String path2 = mList.get(position * 6+1);

            if (!path2.equals(row.path2)) {
                Glide.with(mContext).load(path2)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .dontAnimate()
                        .centerCrop().thumbnail(0.3f).into(row.thumbImage2);
                row.path2 = path2;
            }
            String path3 = mList.get(position * 6+2);

            if (!path3.equals(row.path3)) {
                Glide.with(mContext).load(path3)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .dontAnimate()
                        .centerCrop().thumbnail(0.3f).into(row.thumbImage3);
                row.path3 = path3;
            }
            String path4 = mList.get(position * 6+3);

            if (!path4.equals(row.path4)) {
                Glide.with(mContext).load(path4)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .dontAnimate()
                        .centerCrop().thumbnail(0.3f).into(row.thumbImage4);
                row.path4 = path4;
            }

            String path5 = mList.get(position * 6+4);

            if (!path5.equals(row.path5)) {
                Glide.with(mContext).load(path5)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .dontAnimate()
                        .centerCrop().thumbnail(0.3f).into(row.thumbImage5);
                row.path5 = path5;
            }

            String path6 = mList.get(position * 6+5);

            if (!path6.equals(row.path6)) {
                Glide.with(mContext).load(path6)
                        .diskCacheStrategy(DiskCacheStrategy.NONE)
                        .skipMemoryCache(true)
                        .dontAnimate()
                        .centerCrop().thumbnail(0.3f).into(row.thumbImage6);
                row.path6 = path6;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    @Override

    public int getViewTypeCount() {

        return 75;
    }

    @Override
    public int getItemViewType(int position) {

        return position % 75;
    }

    @Override
    public int getCount() {
        return mList.size() / 6 + 1;
    }

}