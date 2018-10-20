package io.github.bayu1993.androidbasic.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Objects;

import io.github.bayu1993.androidbasic.R;
import io.github.bayu1993.androidbasic.data.Constanta;
import io.github.bayu1993.androidbasic.data.model.PariwisataModel;

public class DetailPariwisataActivity extends AppCompatActivity {
    private PariwisataModel pariwisataModel;
    private TextView tvTitle, tvDesc;
    private ImageView imgDetail;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_pariwisata);

        initView();
        pariwisataModel = getIntent().getParcelableExtra(Constanta.KEY_PARIWISATA);
        tvTitle.setText(pariwisataModel.getNama_pariwisata());
        tvDesc.setText(pariwisataModel.getDetail_pariwisata());
        Glide.with(this)
                .load(pariwisataModel.getGambar_pariwisata())
                .into(imgDetail);

        Objects.requireNonNull(getSupportActionBar()).setTitle(pariwisataModel.getNama_pariwisata());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initView() {
        tvTitle = findViewById(R.id.tv_title_pariwisata_detail);
        tvDesc = findViewById(R.id.tv_desc);
        imgDetail = findViewById(R.id.img_pariwisata_detail);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.detail_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_location) {
            Intent intent = new Intent(DetailPariwisataActivity.this, LocationActivity.class);
            intent = intent.putExtra(Constanta.KEY_ADDRESS, pariwisataModel);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
