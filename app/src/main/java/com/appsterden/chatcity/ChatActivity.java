package com.appsterden.chatcity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.appsterden.chatcity.model.AiResponseData;
import com.appsterden.chatcity.retrofit.ApiServices;
import com.appsterden.chatcity.retrofit.RestClient;
import com.appsterden.chatcity.utils.FontsOverride;
import com.appsterden.chatview.ChatView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ChatActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, ChatView.ChatListener {
    private ChatView chatView;
    private ApiServices mApiServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        chatView = (ChatView) findViewById(R.id.chat_view);
        RestClient restClient = new RestClient();
        mApiServices = restClient.getApiServices();

        chatView.setChatListener(this);
        initViews();
    }


    private void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        setStatusBarColor();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Lato-Regular.ttf");

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setStatusBarColor() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent, null));
        } else {
            window.setStatusBarColor(this.getResources().getColor(R.color.colorAccent));
        }
    }

    /**
     * Called when an item in the navigation menu is selected.
     *
     * @param item The selected item
     * @return true to display the item as the selected item
     */
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void userIsTyping() {

    }

    @Override
    public void userHasStoppedTyping() {

    }

    @Override
    public void onMessageReceived(String message, long timestamp) {

    }

    @Override
    public boolean sendMessage(String message, long timestamp) {
//        Intent intent = new Intent(ChatActivity.this,MapsActivity.class);
//        startActivity(intent);
        mApiServices.askAi(message, new Callback<AiResponseData>() {
            @Override
            public void success(AiResponseData aiResponseData, Response response) {
                if (aiResponseData.getData().getIsSuccess()) {
                    if (aiResponseData.getData().getPlace().isEmpty() || aiResponseData.getData().getPlace().equalsIgnoreCase("")) {
                        chatView.newMessage("Sorry I didn't get you!!!");
                    } else {
                        chatView.newMessage(aiResponseData.getData().getPlace());
                        Intent intent = new Intent(ChatActivity.this, MapsActivity.class);
                        intent.putExtra("addr", aiResponseData.getData().getPlace());
                        intent.putExtra("isreq", aiResponseData.getData().getReq());
                        startActivity(intent);
                    }
                } else {
                    if (aiResponseData.getData().getMessage().isEmpty() || aiResponseData.getData().getMessage().equalsIgnoreCase("")) {
                        chatView.newMessage("Sorry I didn't get you!!!");
                    } else {
                        chatView.newMessage(aiResponseData.getData().getMessage());
                    }
                }
            }

            @Override
            public void failure(RetrofitError error) {
                chatView.newMessage("Sorry I didn't get you!!!");
            }
        });
        return true;
    }


}
