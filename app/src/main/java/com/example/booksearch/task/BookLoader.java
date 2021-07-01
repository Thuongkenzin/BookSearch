package com.example.booksearch.task;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import com.example.booksearch.utils.NetworkUtils;

public class BookLoader extends AsyncTaskLoader {

    private String mQueryString;
    public BookLoader(@NonNull Context context, String queryString) {
        super(context);
        this.mQueryString = queryString;
    }

    @Nullable
    @Override
    public Object loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
