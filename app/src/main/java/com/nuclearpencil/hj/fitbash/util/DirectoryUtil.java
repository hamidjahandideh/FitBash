package com.nuclearpencil.hj.fitbash.util;

import android.content.Context;
import android.os.Environment;

import com.hj.userutil.R;

import java.io.File;

/**
 * Created by Hamid on 12/10/2017.
 */

public  class DirectoryUtil {

    public static String getExternalDirectory(Context ctx) {

        String applicationName = ctx.getResources().getString(R.string.app_name);
        //or context.getApplicationInfo().loadLabel(context.getPackageManager());
        String dirPath = Environment.getExternalStorageDirectory().toString() + "/" + applicationName;
        File dir=new File(dirPath);
        boolean b=dir.mkdirs();

        return dir.getPath();

    }




    public static String getDataDirectory(Context ctx){

        /* PackageManager m = ctx.getPackageManager();
        String s = ctx.getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(s, 0);
            s = p.applicationInfo.dataDir;
            ToastUtil.ShowToast(ctx, s);

        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }*/


        return ctx.getApplicationInfo().dataDir;

    }





    public static String generateFilesDirectory(Context ctx){ // data directory + /files

        //ToastUtil.ShowToast(ctx, ctx.getFilesDir().getPath());

        //or

        //ToastUtil.ShowToast(ctx, ctx.getApplicationContext().getFilesDir();

        //or

        //ContextWrapper c = new ContextWrapper(ctx);
        //ToastUtil.ShowToast(ctx, c.getFilesDir().getPath());

        //or

        /* PackageManager m = ctx.getPackageManager();
        String s = ctx.getPackageName();
        try {
            PackageInfo p = m.getPackageInfo(s, 0);
            s = p.applicationInfo.dataDir + "/files";
            ToastUtil.ShowToast(ctx, s);

        } catch (PackageManager.NameNotFoundException e) {
            Log.w("yourtag", "Error Package name not found ", e);
        }*/


        File dir=new File(ctx.getApplicationInfo().dataDir +"/files");
        boolean b=dir.mkdirs();

        return ctx.getApplicationInfo().dataDir +"/files";



    }

}
