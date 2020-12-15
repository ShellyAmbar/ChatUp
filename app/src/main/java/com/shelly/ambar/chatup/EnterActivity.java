package com.shelly.ambar.chatup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class EnterActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnLogin;
    private Button btnSignup;
    private ImageView logo_picture;
    private TextView btnTerms;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        btnLogin =findViewById(R.id.tvLogin);
        btnSignup =findViewById(R.id.tvSignup);
        logo_picture=findViewById(R.id.logo_picture);
        btnTerms = findViewById(R.id.btnTerms);
        btnLogin.setOnClickListener(this);
        btnSignup.setOnClickListener(this);
        btnTerms.setOnClickListener(this);

        Animation slideDown = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down_from_top);
        Animation slideUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up_from_bottom);

        logo_picture.setAnimation(slideDown);
        btnTerms.setAnimation(slideUp);
        YoYo.with(Techniques.BounceInLeft).duration(2000).delay(200).playOn(btnLogin);
        YoYo.with(Techniques.BounceInRight).duration(2000).delay(800).playOn(btnSignup);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnTerms:
                break;
            case R.id.tvLogin:
                YoYo.with(Techniques.Swing).duration(500).playOn(btnLogin);
                startActivity(new Intent(EnterActivity.this, LoginActivity.class));
                break;
            case R.id.tvSignup:
                YoYo.with(Techniques.Swing).duration(500).playOn(btnSignup);
                startActivity(new Intent(EnterActivity.this, SignUpCardsActivity.class));
                break;

        }
    }
}
