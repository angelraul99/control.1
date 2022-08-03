package com.utma.control;

import android.content.pm.ActivityInfo;
import android.hardware.lights.Light;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.utma.control.databinding.ActivityMainBinding;
import com.utma.control.event.UiToastEvent;
import com.utma.control.util.Config;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.EventListener;

public class MainActivity extends AppCompatActivity {

    private ImageView imgUp, imgDown, imgLeft, imgRight, imgConnect, imgSoud, imgLight;

    final static String UP="A";
    final static String DOWN="B";
    final static String LEFT="C";
    final static String RIGHT="D";
    final static String CONNECT="F";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    private void inicializarControles(){
        imgDown = findViewById(R.id.img_down);
        imgUp = findViewById(R.id.img_up);
        imgLeft = findViewById(R.id.img_left);
        imgLight = findViewById(R.id.img_right);
        imgConnect = findViewById(R.id.img_connect);
        imgLight = findViewById(R.id.img_light);
        imgSoud = findViewById(R.id.img_sound);

        imgUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EventBus.getDefault().post(new UiToastEvent("BOTON ARRIBA" + UP, true,  false));
                //Toast.makeText(MainActivity.this, "BOTON ARRIBA " + UP, Toast.LENGTH_SHORT).show();
            }
        });

        imgDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EventBus.getDefault().post(new UiToastEvent("BOTON ABAJO" + DOWN, true,  false));
                //Toast.makeText(MainActivity.this, "BOTON ABAJO " + DOWN, Toast.LENGTH_SHORT).show();
            }
        });

        imgRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EventBus.getDefault().post(new UiToastEvent("BOTON IZQUIERDA" + LEFT, true,  false));
                //Toast.makeText(MainActivity.this, "BOTON DERECHA " + LEFT, Toast.LENGTH_SHORT).show();
            }
        });

        imgLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EventBus.getDefault().post(new UiToastEvent("BOTON DERECHA" + RIGHT, true,  false));
                //Toast.makeText(MainActivity.this, "BOTON IZQUIERDA " + RIGHT, Toast.LENGTH_SHORT).show();
            }
        });

        imgUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                EventBus.getDefault().post(new UiToastEvent("BOTON CONECTAR" + CONNECT, true,  false));
                //Toast.makeText(MainActivity.this, "BOTON CONECTAR " + CONNECT, Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onStop(){
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onUiToastEvent(UiToastEvent event){
        Config.Mensaje(MainActivity.this,event.getMessage(), event.getLongToast(), event.getisWarning());
    }
}