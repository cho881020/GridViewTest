package kr.kjstudio.gridviewtest;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.module.GlideModule;

/**
 * Created by KJ_Studio on 2016-06-13.
 */
public class MyGlideModule implements GlideModule {
    private final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
    private final int cacheSize = maxMemory / 8;

    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        MemorySizeCalculator calculator = new MemorySizeCalculator(context);
        int defaultMemoryCacheSize = calculator.getMemoryCacheSize();
        int defaultBitmapPoolSize = calculator.getBitmapPoolSize();

        int customMemoryCacheSize = (int) (1.2 * defaultMemoryCacheSize);
        int customBitmapPoolSize = (int) (1.2 * defaultBitmapPoolSize);

        builder.setMemoryCache( new LruResourceCache( customMemoryCacheSize ));
        builder.setBitmapPool( new LruBitmapPool( customBitmapPoolSize ));

        int cacheSize500MegaBytes = 524288000;

        builder.setDiskCache(
                new InternalCacheDiskCacheFactory(context, cacheSize500MegaBytes)
        );
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
