package group.aim.framework.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by narztiizzer on 9/30/2016 AD.
 */

public class ImageHelper {
    public static Bitmap cropCenterBitmap(Bitmap srcBitmap) {
        Bitmap scaledBitmap;
        if (srcBitmap.getWidth() >= srcBitmap.getHeight()) {

            scaledBitmap = Bitmap.createBitmap(
                    srcBitmap,
                    srcBitmap.getWidth() / 2 - srcBitmap.getHeight() / 2,
                    0,
                    srcBitmap.getHeight(),
                    srcBitmap.getHeight()
            );

        } else {

            scaledBitmap = Bitmap.createBitmap(
                    srcBitmap,
                    0,
                    srcBitmap.getHeight() / 2 - srcBitmap.getWidth() / 2,
                    srcBitmap.getWidth(),
                    srcBitmap.getWidth()
            );
        }
        return scaledBitmap;
    }

    public static File createImageFileFromBitmap(Context inContext, Bitmap inImage, String imageName) {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM), inContext.getResources().getString(R.string.app_name) + "Photo");
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                return null;
            }
        }

        File file = new File(mediaStorageDir.getPath(), imageName.split("\\.")[0] + ".jpg");
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            inImage.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
}
