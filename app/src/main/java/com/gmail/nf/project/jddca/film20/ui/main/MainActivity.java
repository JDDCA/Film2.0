package com.gmail.nf.project.jddca.film20.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.gmail.nf.project.jddca.film20.R;
import com.gmail.nf.project.jddca.film20.ui.filter.FilterFragment;
import com.gmail.nf.project.jddca.film20.ui.generate.GenerateFragment;
import com.roughike.bottombar.BottomBar;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.titleToolbar)
    TextView title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.bottomBar)
    BottomBar bottomBar;


    @BindString(R.string.generate)
    String titleGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.contentContainer);
        if (fragment == null) {
            title.setText(titleGenerate);
            fm.beginTransaction()
                    .add(R.id.contentContainer, new GenerateFragment())
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }

        bottomBar.setOnTabSelectListener(tabId -> {
            if (tabId == R.id.tab_generate) {

            } else if (tabId == R.id.tab_newfilms) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.minSettings:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.contentContainer, new FilterFragment())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .commit();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
