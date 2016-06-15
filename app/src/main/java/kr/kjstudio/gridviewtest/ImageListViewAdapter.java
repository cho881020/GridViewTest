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
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.gallery_list_item, null);
        }
        ImageView thumbImage1 = (ImageView) row.findViewById(R.id.thumbImage1);
        ImageView thumbImage2 = (ImageView) row.findViewById(R.id.thumbImage2);
        ImageView thumbImage3 = (ImageView) row.findViewById(R.id.thumbImage3);
        try {
            String left = mList.get(position * 3);

            Glide.with(mContext).load(left)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
//                    .dontAnimate()
                    .centerCrop().thumbnail( 0.3f ).into(thumbImage1);

            String center = mList.get(position * 3 + 1);

            Glide.with(mContext).load(center)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
//                    .dontAnimate()
                    .centerCrop().thumbnail( 0.3f ).into(thumbImage2);
            String right = mList.get(position * 3 + 2);

            Glide.with(mContext).load(right)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .skipMemoryCache(true)
//                    .dontAnimate()
                    .centerCrop().thumbnail( 0.3f ).into(thumbImage3);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return row;
    }


    @Override
    public int getCount() {
        return mList.size()/3 +1;
    }

}