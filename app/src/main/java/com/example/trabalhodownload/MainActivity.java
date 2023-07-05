package com.example.trabalhodownload;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button downloadButton;
    private EditText editUrl;
    private ImageView imageView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadButton = findViewById(R.id.downloadButton);
        editUrl = findViewById(R.id.editUrl);
        imageView = findViewById(R.id.imageView);
        progressBar = findViewById(R.id.progressBar);

        downloadButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        DownloadTask downloadTask = new DownloadTask(downloadButton, imageView, progressBar);
        downloadTask.execute(editUrl.getText().toString());

    }
}