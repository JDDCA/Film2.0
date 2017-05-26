package com.gmail.nf.project.jddca.film20.domain.utils;


import android.content.Context;
import android.os.Build;

public class LocalService {

    public static String getLocales(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
            return context.getResources().getConfiguration().locale.toString();
        return context.getResources().getConfiguration().getLocales().get(0).toString();
    }
}
