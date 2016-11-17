package group.aim.framework.helper;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Window;

/**
 * Created by Nattapongr on 9/27/2016 AD.
 */

public class ScreenSizeHelper {
    public static DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
    // Get display size
    private static int screenWidth;
    private static int screenHeight;

    private ScreenSizeHelper() {
    }

    /**
     * Use for get screen size
     */
    private static void getScreenSize() {
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
    }

    public static int getScreenWidth() {
        getScreenSize();
        return ScreenSizeHelper.screenWidth;
    }

    public static int getScreenHeight() {
        getScreenSize();
        return ScreenSizeHelper.screenHeight;
    }

    public static int getScreenWidthInDP() {
        getScreenSize();
        return (int) (ScreenSizeHelper.screenWidth / metrics.density);
    }

    public static int getScreenHeighInDP() {
        getScreenSize();
        return (int) (ScreenSizeHelper.screenHeight / metrics.density);
    }

    public static boolean isTabletSize(Context context) {
        return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static int getStatusBarHeight(Activity activity) {
        Rect rectangle = new Rect();
        Window window = activity.getWindow();
        window.getDecorView().getWindowVisibleDisplayFrame(rectangle);
        return rectangle.top;
    }
}
