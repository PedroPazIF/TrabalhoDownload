package com.example.trabalhodownload;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {
    Button downloadButton;
    ImageView imageView;
    ProgressBar progressBar;


    public DownloadTask(Button downloadButton, ImageView imageView, ProgressBar progressBar) {
        this.downloadButton = downloadButton;
        this.imageView = imageView;
        this.progressBar = progressBar;
    }


    @Override
    protected void onPreExecute() {
        downloadButton.setEnabled(false);
        imageView.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        progressBar.setVisibility(View.INVISIBLE);
        imageView.setImageBitmap(bitmap);
        imageView.setVisibility(View.VISIBLE);
        downloadButton.setEnabled(true);

    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        String url = strings[0];
        Bitmap bitmap = null;

        try {
            InputStream in = new URL(url).openStream();

            bitmap = BitmapFactory.decodeStream(in);

            in.close();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }

        return bitmap;
    }
}
