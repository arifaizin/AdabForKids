package id.co.imastudio.adabforkids;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;

public class MenuActivity extends AppCompatActivity {

    GridView gridMenu;
    int[] listMenu = {
            R.drawable.menu01,
            R.drawable.menu02,
            R.drawable.menu03,
            R.drawable.menu04,
            R.drawable.menu05,
            R.drawable.menu06,
            R.drawable.menu07,
            R.drawable.menu08,
            R.drawable.menu09
    };

    String[] listu = {
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",
            "1",

    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        gridMenu = (GridView) findViewById(R.id.gridView);
        MenuAdapter adapter = new MenuAdapter(MenuActivity.this, listMenu, listu );
        gridMenu.setAdapter(adapter);
        gridMenu.setNumColumns(3);

        gridMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent pindah = new Intent(MenuActivity.this, PlayActivity.class);
                pindah.putExtra("posisi", position);
                startActivity(pindah);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
    }
}
