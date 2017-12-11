package com.nuclearpencil.hj.fitbash.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;

import java.io.File;
import java.util.UUID;

public class HardwareUtil {


    private final Context context;


    //Constructor
    public HardwareUtil(Context ctx) {
        this.context = ctx;
    }


    public static String GetAllHardwareCode() {
        String a = //getPhoneNumber()+
                //GetAndroidID()+
                //GetMacAddress()+
                getUniquePsuedoID();
        //GetGoogleIOid(context)+
        //getAppFirstInstallTime(context)+
        //getAppLastUpdateTime(context);

        return a;
        //if not true password delete of database
    }


    public static String getPhoneNumber(Context context) {
        // Return null if simcard not registered
        //<uses-permission android:name="android.permission.READ_PHONE_STATE" />
        TelephonyManager tMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String mPhoneNumber = tMgr.getLine1Number();

        //region temp for learning
        tMgr.getCallState(); // int
        //tMgr.getCellLocation(); // need permision corse location
        String b = tMgr.getNetworkCountryIso();
        b += tMgr.getNetworkOperator();
        b += tMgr.getNetworkOperatorName();
        b += tMgr.getPhoneType();
        b += tMgr.getSimOperatorName();
        //endregion

        return mPhoneNumber;
    }


    public static String GetAndroidID(Context context) {

        // bug : Return 9774d56d682e549c for some device in android 2.2
        //<uses-permission android:name="android.permission.READ_PHONE_STATE" />

		/*

			All devices with a Google account added returned a value for ANDROID_ID
			All CDMA devices returned the same value (or derivation of the same value) for both ANDROID_ID and TelephonyManager.getDeviceId() -- as long as a Google account has been added during setup.
			I did not yet have a chance to test GSM devices with no SIM, a GSM device with no Google account added, or any of the devices in airplane mode.
		*/

        String deviceId = null;

        deviceId = "" + Secure.getString(context.getContentResolver(), Secure.ANDROID_ID); // Android ID (can be null, can change upon factory reset, can be altered on rooted phone)

        return deviceId;
    }


    public static String getSimSerial(Context context) {
        //All GSM devices (all tested with a SIM) returned a value for TelephonyManager.getSimSerialNumber()
        //All CDMA devices returned null for getSimSerialNumber() (as expected)

        //<uses-permission android:name="android.permission.READ_PHONE_STATE" />
        String tmSerial = null;
        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            tmSerial = "" + tm.getSimSerialNumber(); // Sim Serial
        }
        return tmSerial;
    }


    public static String getDeviceId(Context context) { // IMEI for GSM    /     ESN or MEID For CDMA
        //All devices tested returned a value for TelephonyManager.getDeviceId()

        //<uses-permission android:name="android.permission.READ_PHONE_STATE" />
        String tmDevice = null;
        final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            tmDevice = "" + tm.getDeviceId();  // IMEI
        }
        return tmDevice;
    }


    public static String GetMacAddress(Context context) { // %100
        //    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>

        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wInfo = wifiManager.getConnectionInfo();
        return wInfo.getMacAddress();
    }


    public static String getUniquePsuedoID() { // for all Android devices
        /*
         Pseudo-Unique ID, that works on all Android devices Some
		  devices don't have a phone (eg. Tablets) or for some reason 
		   you don't want to include the READ_PHONE_STATE permission. 
		    You can still read details like ROM Version, Manufacturer name, 
		     CPU type, and other hardware details, that will be well suited if
		      you want to use the ID for a serial key check, or other general purposes. 
		       The ID computed in this way won't be unique: it is possible to
		        find two devices with the same ID (based on the same
		         hardware and rom image) but the chances in real world applications
		          are negligible. For this purpose you can use the Build class:
		 */
        String m_szDevIDShort = "35" + //we make this look like a valid IMEI
                Build.BOARD.length() % 10 + Build.BRAND.length() % 10 +
                Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 +
                Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 +
                Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 +
                Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 +
                Build.TAGS.length() % 10 + Build.TYPE.length() % 10 +
                Build.USER.length() % 10; //13 digits
        return m_szDevIDShort;
    }


    public synchronized static String GetGoogleIOid(Context context) {
        //Here is the code that Reto Meier used in the Google I/O presentation this year to get a unique id for the user:
        String uniqueID = null;
        final String PREF_UNIQUE_ID = "PREF_UNIQUE_ID";

        if (uniqueID == null) {
            SharedPreferences sharedPrefs = context.getSharedPreferences(
                    PREF_UNIQUE_ID, Context.MODE_PRIVATE);
            uniqueID = sharedPrefs.getString(PREF_UNIQUE_ID, null);
            if (uniqueID == null) {
                uniqueID = UUID.randomUUID().toString();
                Editor editor = sharedPrefs.edit();
                editor.putString(PREF_UNIQUE_ID, uniqueID);
                editor.commit();
            }
        }
        return uniqueID;
    }


    /**
     * The time at which the app was first installed. Units are as per currentTimeMillis().
     *
     * @param context
     * @return
     */
    public static String getAppFirstInstallTime(Context context) {
        PackageInfo packageInfo;
        try {
            if (Build.VERSION.SDK_INT > 8/*Build.VERSION_CODES.FROYO*/) {
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return String.valueOf(packageInfo.firstInstallTime);
            } else {
                //firstinstalltime unsupported return last update time not first install time
                ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                String sAppFile = appInfo.sourceDir;
                return String.valueOf(new File(sAppFile).lastModified());
            }
        } catch (NameNotFoundException e) {
            //should never happen
            return String.valueOf(0);
        }
    }


    /**
     * The time at which the app was last updated. Units are as per currentTimeMillis().
     *
     * @param context
     * @return
     */
    public static String getAppLastUpdateTime(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 8/*Build.VERSION_CODES.FROYO*/) {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return String.valueOf(packageInfo.lastUpdateTime);
            } else {
                ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                String sAppFile = appInfo.sourceDir;
                return String.valueOf(new File(sAppFile).lastModified());
            }
        } catch (NameNotFoundException e) {
            //should never happen
            return String.valueOf(0);
        }
    }
}
