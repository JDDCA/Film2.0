package com.gmail.nf.project.jddca.film20.domain.utils;


import android.content.Context;

import com.gmail.nf.project.jddca.film20.R;

public class KeyService {

    public static String getApiKey(Context context) {
        return context.getResources().getString(R.string.key);
    }
}
