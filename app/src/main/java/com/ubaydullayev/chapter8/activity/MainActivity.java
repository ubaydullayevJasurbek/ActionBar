package com.ubaydullayev.chapter8.activity;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.ubaydullayev.chapter8.R;
import com.ubaydullayev.chapter8.adapter.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager2 viewPager2 = findViewById(R.id.viewpagerMain);
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(this);
        viewPager2.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayoutMain);

        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) ->
                tab.setText(pagerAdapter.getPageTitle(position))).attach();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem menuItem = menu.findItem(R.id.action_share);
        shareActionProvider =
                (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_create_order) {
            Intent intent = new Intent(this, OrderActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setShareActionIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Want to join me for pizza?");
        shareActionProvider.setShareIntent(intent);
    }


}