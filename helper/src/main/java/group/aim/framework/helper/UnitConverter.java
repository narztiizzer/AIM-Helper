package group.aim.framework.helper;

import android.content.Context;

/**
 * Created by Nattapongr on 10/3/2016 AD.
 */

public class UnitConverter {
    public static float pixelsToSp(Context context, float px) {
        float scaledDensity = context.getResources().getDisplayMetrics().scaledDensity;
        return px / scaledDensity;
    }
}
