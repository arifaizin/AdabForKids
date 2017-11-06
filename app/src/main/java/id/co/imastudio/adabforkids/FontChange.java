package id.co.imastudio.adabforkids;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by idn on 5/8/2017.
 */

public class FontChange extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/cartoonist_kooky.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
