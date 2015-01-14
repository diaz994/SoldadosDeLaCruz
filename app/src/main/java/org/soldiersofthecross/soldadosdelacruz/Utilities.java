package org.soldiersofthecross.soldadosdelacruz;

import android.os.Environment;

/**
 * Created by victordiaz on 1/7/15.
 */
public class Utilities {

    // making sure that external storage is writable
    public boolean isExternalStorageWritable() {
        String externalStorageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(externalStorageState) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState)) {
            return true;
        }
        return false;
    }

    // making sure that external storage is readable
    public boolean isExternalStorageReadable() {
        String externalStorageState = Environment.getExternalStorageState();
        if(Environment.MEDIA_MOUNTED.equals(externalStorageState) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(externalStorageState)) {
            return true;
        }

        return false;
    }
}
