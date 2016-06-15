package kr.kjstudio.gridviewtest;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private int count;
    private String[] arrPath;


    // Storage Permissions
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    private android.widget.GridView phoneImageGrid;
    private android.widget.ListView imageListView;

    /**
     * Checks if the app has permission to write to device storage
     * <p/>
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
        else {

            final String[] columns = {MediaStore.Images.Media.DATA, MediaStore.Images.Media._ID};
            final String orderBy = MediaStore.Images.Media._ID;

            Cursor imagecursor = managedQuery(
                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI, columns, null,
                    null, orderBy);
            int image_column_index = imagecursor.getColumnIndex(MediaStore.Images.Media._ID);
            this.count = imagecursor.getCount();
            this.arrPath = new String[this.count];
            for (int i = 0; i < this.count; i++) {
                imagecursor.moveToPosition(i);
                int id = imagecursor.getInt(image_column_index);
                int dataColumnIndex = imagecursor.getColumnIndex(MediaStore.Images.Media.DATA);
                arrPath[i] = imagecursor.getString(dataColumnIndex);
            }
//        imagecursor.close();

            Log.d("path_count", arrPath.length + "개");
            ArrayList<String> paths = new ArrayList<>(Arrays.asList(arrPath));

            ImageAdapter imageAdapter = new ImageAdapter(paths);
            Log.d("adapter", "made");


//        phoneImageGrid.setAdapter(imageAdapter);

            ImageListViewAdapter adapter = new ImageListViewAdapter(MainActivity.this, paths);
            imageListView.setAdapter(adapter);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.imageListView = (ListView) findViewById(R.id.imageListView);

        verifyStoragePermissions(this);

    }

    public class ImageAdapter extends BaseAdapter {
        private LayoutInflater mInflater;
        ArrayList<String> mPathArray;

        public ImageAdapter(ArrayList<String> paths) {
            mInflater = LayoutInflater.from(MainActivity.this);
            mPathArray = paths;
        }

        public int getCount() {
            return mPathArray.size();
        }

        @Override
        public Object getItem(int position) {
            return mPathArray.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            if (row == null) {
                row = mInflater.inflate(R.layout.gallery_list_item, null);
            }
//            ImageView thumbImage = (ImageView) row.findViewById(R.id.thumbImage);
//            Glide.with(MainActivity.this)
//                    .load(mPathArray.get(position))
//                    .thumbnail(0.5f)
//                    .centerCrop()
//                    .crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(thumbImage);
//
            return row;
        }
    }
}
