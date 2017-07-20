package com.inti.student.simplenotepad;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntro2Fragment;

/**
 * Created by Wei Sheng on 9/7/2017.
 */

public final class IntroActivity extends AppIntro2 {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntro2Fragment.newInstance("Simple Notepad", "Create a new password and enter the password before enter the apps.",
                R.drawable.password, Color.parseColor("#69F0AE")));
        addSlide(AppIntro2Fragment.newInstance("Simple Notepad", "Click on the ADD NEW button or round add button to create a new note.",
                R.drawable.newnote, Color.parseColor("#BA68C8")));
        addSlide(AppIntro2Fragment.newInstance("Simple Notepad", "Save or delete the note after finish writing the note.",
                R.drawable.savedelete, Color.parseColor("#1E88E5")));


        showStatusBar(false);
        showSkipButton(false);
        setFadeAnimation();
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(this, CreatePasswordActivity.class));
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {

    }

    @Override
    public void onSlideChanged() {

    }
}
