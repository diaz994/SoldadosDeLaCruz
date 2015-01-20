package org.soldiersofthecross.soldadosdelacruz;

import android.util.Log;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by victordiaz on 12/21/14.
 */

public class SotcApplication extends android.app.Application {

    final public static String TAG = "Sotc Application Class";
    @Override
    public void onCreate () {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                                            .setDefaultFontPath("fonts/Roboto-Regular.ttf")
                                            .setFontAttrId(R.attr.fontPath)
                                            .build()
        );

        Log.d(TAG, "Font has been applied");
    }
}
