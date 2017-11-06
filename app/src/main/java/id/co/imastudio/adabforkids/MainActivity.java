package id.co.imastudio.adabforkids;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {

    private ImageView btnPlay;
    private ImageView btnOption;
    private ImageView btnAbout;
    private ImageView btnExit;
    private ImageView btnOn;
    private String settinganSound;
    private AudioManager audioManager;
    private ImageView btnYes;
    private ImageView btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        initView();

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MenuActivity.class));
                playSound();
            }
        });

        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_option);
                dialog.show();

                btnOn = (ImageView) dialog.findViewById(R.id.btnSoundOn);
                //ngambil data
                SharedPreferences pref = getSharedPreferences("setting",0);
                settinganSound = pref.getString("sound", "on");
                if (settinganSound.equals("on")){
                    btnOn.setImageResource(R.drawable.on);
                } else if(settinganSound.equals("off")){
                    btnOn.setImageResource(R.drawable.off);
                }

                audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

                btnOn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        playSound();
                        //ngambil data
                        SharedPreferences pref = getSharedPreferences("setting",0);
                        settinganSound = pref.getString("sound", "on");
                        if (settinganSound.equals("on")){
                            btnOn.setImageResource(R.drawable.off);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("sound","off");
                            editor.commit();
                            //simpan data

                            //setting audio on
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_SHOW_UI);

                        } else if (settinganSound.equals("off")){
                            btnOn.setImageResource(R.drawable.on);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("sound","on");
                            editor.commit();

                            //setting off
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 15, AudioManager.FLAG_SHOW_UI);
                        }

                    }
                });

            }
        });

        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_about);
                dialog.show();
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_exit);
                dialog.show();


                btnYes = (ImageView) dialog.findViewById(R.id.btnYes);
                btnYes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //ngambil data
                        finish();
                        System.exit(0);
                        playSound();
                    }
                });

                btnNo = (ImageView) dialog.findViewById(R.id.btnNo);
                btnNo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //ngambil data
                        dialog.dismiss();
                        playSound();
                    }
                });

            }
        });


    }

    private void initView() {
        btnPlay = (ImageView) findViewById(R.id.btnPlay);
        btnOption = (ImageView) findViewById(R.id.btnOption);
        btnAbout = (ImageView) findViewById(R.id.btnAbout);
        btnExit = (ImageView) findViewById(R.id.btnExit);
    }

    @Override
    public void onBackPressed() {
        final Dialog dialog = new Dialog(MainActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_exit);
        dialog.show();

        btnYes = (ImageView) dialog.findViewById(R.id.btnYes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ngambil data
                finish();
                System.exit(0);
                playSound();
            }
        });

        btnNo = (ImageView) dialog.findViewById(R.id.btnNo);
        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ngambil data
                dialog.dismiss();
                playSound();
            }
        });


    }

    private void playSound() {
        MediaPlayer player = MediaPlayer.create(MainActivity.this, R.raw.sfx_button);
        player.start();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
