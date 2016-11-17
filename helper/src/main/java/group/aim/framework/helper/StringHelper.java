package group.aim.framework.helper;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by Nattapongr on 10/13/2016 AD.
 */

public class StringHelper {

    public static String HTMLNumberToString(String txt){
        return StringEscapeUtils.unescapeHtml4(txt);
    }
}
