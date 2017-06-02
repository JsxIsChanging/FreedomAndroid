package com.example.a91256.freedomandroid.utils;

import android.content.Context;
import android.net.Uri;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;


/**
 * Created by 91256 on 2017/5/27.
 */

public class ImageDownloader {

    public static void startDownload(String url, Context context,BaseBitmapDataSubscriber listener){

        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource( Uri.parse(url))
                .setProgressiveRenderingEnabled(true)
                .build();
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        DataSource<CloseableReference<CloseableImage>>
                dataSource = imagePipeline.fetchDecodedImage(imageRequest,context);
        dataSource.subscribe(listener, CallerThreadExecutor.getInstance());
    }

}
