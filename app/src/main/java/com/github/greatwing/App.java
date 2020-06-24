package com.github.greatwing;

import android.app.Application;

import ren.yale.android.cachewebviewlib.WebViewCacheInterceptor;
import ren.yale.android.cachewebviewlib.WebViewCacheInterceptorInst;
import ren.yale.android.cachewebviewlib.config.CacheExtensionConfig;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        WebViewCacheInterceptor.Builder builder =  new WebViewCacheInterceptor.Builder(this);
        builder.setCacheSize(2*1024*1024*1024);
        builder.setDebug(true);


        CacheExtensionConfig extension = new CacheExtensionConfig();
        extension
                .addExtension("mp3")
                .addExtension("json")
                .addExtension("lua")
                .addExtension("atlas")
                .addExtension("pkm")
                .addExtension("png")
                .addExtension("webp")
                .addExtension("js")
                .addExtension("bin")
                .addExtension("html");
        builder.setCacheExtensionConfig(extension);

        builder.setAssetsDir("static");
        WebViewCacheInterceptorInst.getInstance().init(builder);
    }
}
