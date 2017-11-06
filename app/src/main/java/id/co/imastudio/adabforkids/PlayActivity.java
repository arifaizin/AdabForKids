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
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class PlayActivity extends AppCompatActivity {


    private ViewPager viewPager;


    private int[] chapter1 = {
            R.drawable.chapter01_01,
            R.drawable.chapter01_02,
            R.drawable.chapter01_03,
            R.drawable.chapter01_04,
            R.drawable.chapter01_05,
            R.drawable.chapter01_06,
            R.drawable.chapter01_07,
            R.drawable.chapter01_08,
            R.drawable.chapter01_09,
            R.drawable.chapter01_10
    };

    private int[] chapter2 = {
            R.drawable.chapter02_01,
            R.drawable.chapter02_02,
            R.drawable.chapter02_03,
            R.drawable.chapter02_04,
            R.drawable.chapter02_05,
            R.drawable.chapter02_06,
            R.drawable.chapter02_07,
            R.drawable.chapter02_08,
            R.drawable.chapter02_09,
            R.drawable.chapter02_10
    };

    private int[] chapter3 = {
            R.drawable.chapter03_01,
            R.drawable.chapter03_02,
            R.drawable.chapter03_03,
            R.drawable.chapter03_04,
            R.drawable.chapter03_05,
            R.drawable.chapter03_06,
            R.drawable.chapter03_07,
            R.drawable.chapter03_08,
            R.drawable.chapter03_09
    };

    private int[] chapter4 = {
            R.drawable.chapter04_01,
            R.drawable.chapter04_02,
            R.drawable.chapter04_03,
            R.drawable.chapter04_04,
            R.drawable.chapter04_05,
            R.drawable.chapter04_06,
            R.drawable.chapter04_07,
            R.drawable.chapter04_08,
            R.drawable.chapter04_09
    };

    private int[] chapter5 = {
            R.drawable.chapter05_01,
            R.drawable.chapter05_02,
            R.drawable.chapter05_03,
            R.drawable.chapter05_04,
            R.drawable.chapter05_05,
            R.drawable.chapter05_06,
            R.drawable.chapter05_07,
            R.drawable.chapter05_08,
            R.drawable.chapter05_09,
            R.drawable.chapter05_10,
            R.drawable.chapter05_11,
            R.drawable.chapter05_12
    };

    private int[] chapter6 = {
            R.drawable.chapter06_01,
            R.drawable.chapter06_02,
            R.drawable.chapter06_03,
            R.drawable.chapter06_04,
            R.drawable.chapter06_05,
            R.drawable.chapter06_06,
            R.drawable.chapter06_07,
            R.drawable.chapter06_08
    };

    private int[] chapter7 = {
            R.drawable.chapter07_01,
            R.drawable.chapter07_02,
            R.drawable.chapter07_03,
            R.drawable.chapter07_04,
            R.drawable.chapter07_05,
            R.drawable.chapter07_06,
            R.drawable.chapter07_07,
            R.drawable.chapter07_08,
            R.drawable.chapter07_09,
            R.drawable.chapter07_10,
            R.drawable.chapter07_11,
            R.drawable.chapter07_12
    };

    private int[] chapter8 = {
            R.drawable.chapter08_01,
            R.drawable.chapter08_02,
            R.drawable.chapter08_03,
            R.drawable.chapter08_04,
            R.drawable.chapter08_05,
            R.drawable.chapter08_06,
            R.drawable.chapter08_07,
            R.drawable.chapter08_08,
            R.drawable.chapter08_09,
            R.drawable.chapter08_10
    };

    private int[] chapter9 = {
            R.drawable.chapter9_1,
            R.drawable.chapter9_2,
            R.drawable.chapter9_3,
            R.drawable.chapter9_4,
            R.drawable.chapter9_5,
            R.drawable.chapter9_6,
            R.drawable.chapter9_7,
            R.drawable.chapter9_8,
            R.drawable.chapter9_9
    };

    private int[] suarabilal = {
            R.raw.suarabilal01,
            R.raw.suarabilal02,
            R.raw.suarabilal03,
            R.raw.suarabilal04,
            R.raw.suarabilal05,
            R.raw.suarabilal06,
            R.raw.suarabilal07,
            R.raw.suarabilal08,
            R.raw.suarabilal09
    };

//    private int[] textAdab = {
//            R.drawable.text01,
//            R.drawable.text02,
//            R.drawable.text03,
//            R.drawable.text04,
//            R.drawable.text05,
//            R.drawable.text06,
//            R.drawable.text07,
//            R.drawable.text08,
//            R.drawable.text09
//    };
    private ImageView btnPlayOption;
    private ImageView btnPlayHome;
    private ImageView btnPlayBack;
    private ImageView btnPlayNext;
    private int page = 0;
    private ImageView btnOn;
    private String settinganSound;
    AudioManager audioManager;
    private int currentPage;

    ViewPagerAdapter pageradapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        int pilihan = getIntent().getIntExtra("posisi", 0);

        initView();

        if (pilihan == 0) {
            pageradapter = new ViewPagerAdapter(this, chapter1, suarabilal);
        } else if (pilihan == 1) {
            pageradapter = new ViewPagerAdapter(this, chapter2, suarabilal);
        } else if (pilihan == 2) {
            pageradapter = new ViewPagerAdapter(this, chapter3, suarabilal);
        } else if (pilihan == 3) {
            pageradapter = new ViewPagerAdapter(this, chapter4, suarabilal);
        } else if (pilihan == 4) {
            pageradapter = new ViewPagerAdapter(this, chapter5, suarabilal);
        } else if (pilihan == 5) {
            pageradapter = new ViewPagerAdapter(this, chapter6, suarabilal);
        } else if (pilihan == 6) {
            pageradapter = new ViewPagerAdapter(this, chapter7, suarabilal);
        } else if (pilihan == 7) {
            pageradapter = new ViewPagerAdapter(this, chapter8, suarabilal);
        } else if (pilihan == 8) {
            pageradapter = new ViewPagerAdapter(this, chapter9, suarabilal);
        }
        viewPager.setAdapter(pageradapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
//                Toast.makeText(PlayActivity.this, "posisi"+position, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        btnPlayNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();

                if (currentPage == pageradapter.getCount() - 1) {
//                    Toast.makeText(PlayActivity.this, "Tes Halaman Terakhir", Toast.LENGTH_SHORT).show();
                    final Dialog dialog = new Dialog(PlayActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.setContentView(R.layout.dialog_hebat);
                    dialog.show();

                    MediaPlayer player = MediaPlayer.create(PlayActivity.this, R.raw.suarabilalhebat);
                    player.start();
                }


                viewPager.arrowScroll(View.FOCUS_RIGHT);

            }
        });

        btnPlayBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                viewPager.arrowScroll(View.FOCUS_LEFT);
            }
        });

//        viewPager.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                if (pageradapter.getCount() == page) {
//                    page = 0;
//                } else {
//                    page++;
//                }
//                viewPager.setCurrentItem(page, true);
//                Handler handler = new Handler();
//                handler.postDelayed(this, delay);
//            }
//        }, 2000);

        btnPlayOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound();
                final Dialog dialog = new Dialog(PlayActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.setContentView(R.layout.dialog_option);
                dialog.show();

                btnOn = (ImageView) dialog.findViewById(R.id.btnSoundOn);
                //ngambil data
                SharedPreferences pref = getSharedPreferences("setting", 0);
                settinganSound = pref.getString("sound", "on");
                if (settinganSound.equals("on")) {
                    btnOn.setImageResource(R.drawable.on);
                } else if (settinganSound.equals("off")) {
                    btnOn.setImageResource(R.drawable.off);
                }

                btnOn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //ngambil data
                        playSound();
                        SharedPreferences pref = getSharedPreferences("setting", 0);
                        settinganSound = pref.getString("sound", "on");
                        if (settinganSound.equals("on")) {
                            btnOn.setImageResource(R.drawable.off);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("sound", "off");
                            editor.commit();
                            //simpan data

                            //setting audio on
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, AudioManager.FLAG_SHOW_UI);

                        } else if (settinganSound.equals("off")) {
                            btnOn.setImageResource(R.drawable.on);
                            SharedPreferences.Editor editor = pref.edit();
                            editor.putString("sound", "on");
                            editor.commit();

                            //setting off
                            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 15, AudioManager.FLAG_SHOW_UI);
                        }

                    }
                });

            }
        });


        btnPlayHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PlayActivity.this, MenuActivity.class));
                playSound();
                finish();
            }
        });
    }

    private void playSound() {
        MediaPlayer player = MediaPlayer.create(PlayActivity.this, R.raw.sfx_button);
        player.start();
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        btnPlayOption = (ImageView) findViewById(R.id.btnPlayOption);
        btnPlayHome = (ImageView) findViewById(R.id.btnPlayHome);
        btnPlayBack = (ImageView) findViewById(R.id.btnPlayBack);
        btnPlayNext = (ImageView) findViewById(R.id.btnPlayNext);
    }
}
