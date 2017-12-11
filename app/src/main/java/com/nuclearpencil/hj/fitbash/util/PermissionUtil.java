package com.nuclearpencil.hj.fitbash.util;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hamid on 12/10/2017.
 */

public class PermissionUtil {

    public static void setPermision(final Activity act, String... permisions) { // this method prevent of revoke permission
        List<String> list = Arrays.asList(permisions);
        ArrayList<String> list2 = new ArrayList<String>();

        for (int i = 0; i < list.size(); i++) {
            if (ActivityCompat.checkSelfPermission(act, list.get(i)) != PackageManager.PERMISSION_GRANTED) {
                list2.add(list.get(i));
            }
        }


        if (list2.size()>=0) {
            String[] array = list2.toArray(new String[list2.size()]);
            ActivityCompat.requestPermissions(act, array, 1234);// can revoke permission in array mode
        }



    }




    public static boolean checkPermision(final Activity act, String... permisions) {
        List<String> list = Arrays.asList(permisions);
        for (int i = 0; i < list.size(); i++) {
            if (ActivityCompat.checkSelfPermission(act, list.get(i)) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }


        //Or [ not tested ]
/*        int result = context.checkCallingOrSelfPermission(permission);
        return result == PackageManager.PERMISSION_GRANTED;*/


        return true;
    }

}
