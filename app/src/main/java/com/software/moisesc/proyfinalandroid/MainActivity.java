package com.software.moisesc.proyfinalandroid;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.software.moisesc.proyfinalandroid.adapter.ViewPagerAdapter;
import com.software.moisesc.proyfinalandroid.network.RegisterUserActivity;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.app_name), MODE_PRIVATE);
        String username = preferences.getString("username", "");
        if (username.isEmpty()) {
            // Usuario no logeado
            Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, R.string.login_success, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Username: " + username, Toast.LENGTH_LONG).show();
            //////////////////////////////////////////////////////////////////////////

                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setElevation(0);
                    }
                    tabLayout = (TabLayout)findViewById(R.id.tab_layout);

                    tabLayout.addTab(tabLayout.newTab().setText("Posts..."));
                    tabLayout.addTab(tabLayout.newTab().setText("Users..."));

                    viewPager = (ViewPager)findViewById(R.id.view_pager);
                    ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
                    viewPager.setAdapter(adapter);

                    viewPager.addOnPageChangeListener(
                            new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            viewPager.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });




            //////////////////////////////////////////////////////////////////////


    }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inlfater  clase son los que leen el xml los  convierte archivos java en memmoria
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.dashboard_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //que opcion ha sido presionada en dasboard_menu
        switch (item.getItemId()) {
            case R.id.logout_option:
                //Toast.makeText(this,"Logout",Toast.LENGTH_LONG).show(); //esta intruccion o la del loguot hace lo mismo
                logout();
                return true;

            case R.id.post_option:
                register();
                return true;

            case R.id.user_option:
                registerUser();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void register() {
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
    }

    private void registerUser() {
        Intent intent = new Intent(this,RegisterUserActivity.class);
        startActivity(intent);
    }

    private void logout() {
        SharedPreferences preferences = getSharedPreferences(
                getString(R.string.app_name), MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove("username");
        editor.commit();
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
