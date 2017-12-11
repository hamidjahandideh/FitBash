package com.nuclearpencil.hj.fitbash.app;

import android.os.Build;


import com.nuclearpencil.hj.fitbash.util.HardwareUtil;

/**
 * Created by Hamid on 10/31/2016.
 */

public class ge_C {


    public static class Profile {

        public static final int Drawer_GuestID = 0;
        public static final int Drawer_UserID = 1;

        public static class UsersMenu {

            public static final int UserInfo = 0;
            public static final int Basket = 1;
            public static final int Order = 2;
            public static final int Exit = 3;
        }

    }


    public static class SP {


        public static class Downloading {

            public static final String FileName = "D";
            public static final String Key_Downloading = "ms";

        }


    }


    public class Activity_RegisterLogin {

        public static final String SharedPreference_Settings = "settings";
        public static final String SharedPreference_Key_UserName = "username";
        public static final String SharedPreference_Key_Password = "password";


        public static final int Display_Register = 1; // Use for Replace Fragment
        public static final int Display_Login = 2;// Use for Replace Fragment

    }


}
