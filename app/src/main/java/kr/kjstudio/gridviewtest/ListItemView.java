package kr.kjstudio.gridviewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by KJ_STUDIO on 2016-06-21.
 */
public class ListItemView extends LinearLayout {

    Context mContext;
    public ImageView thumbImage1;
    public ImageView thumbImage2;
    public ImageView thumbImage3;
    public ImageView thumbImage4;
    public ImageView thumbImage5;
    public ImageView thumbImage6;

    public String path1=null;
    public String path2=null;
    public String path3=null;
    public String path4=null;
    public String path5=null;
    public String path6=null;

    public ListItemView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public ListItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    public ListItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.gallery_list_item, this);


        thumbImage1 = (ImageView) findViewById(R.id.thumbImage1);
        thumbImage2 = (ImageView) findViewById(R.id.thumbImage2);
        thumbImage3 = (ImageView) findViewById(R.id.thumbImage3);
        thumbImage4 = (ImageView) findViewById(R.id.thumbImage4);
        thumbImage5 = (ImageView) findViewById(R.id.thumbImage5);
        thumbImage6 = (ImageView) findViewById(R.id.thumbImage6);

    }
}
