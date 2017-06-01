package com.gmail.nf.project.jddca.film20.domain.utils;

import android.content.Context;
import android.os.Build;

import com.gmail.nf.project.jddca.film20.R;

public class ApiService {

    public static final String IMG_URL = "https://image.tmdb.org/t/p/w500";

    public static String getApiKey(Context context) {
        return context.getResources().getString(R.string.key);
    }

    public static String getLocales(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
            return context.getResources().getConfiguration().locale.toString();
        return context.getResources().getConfiguration().getLocales().get(0).toString();
    }
}
