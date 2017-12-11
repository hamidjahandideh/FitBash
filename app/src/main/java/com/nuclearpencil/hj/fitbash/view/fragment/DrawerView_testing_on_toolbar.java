package com.nuclearpencil.hj.fitbash.view.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

import com.hj.loginutil.data.model.StateType;
import com.hj.loginutil.data.model.UserModel;
import com.hj.loginutil.interfaces.OnLoginStateChange;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.app.App;
import com.nuclearpencil.hj.fitbash.app.ge_C;
import com.nuclearpencil.hj.fitbash.data.enums.sliderMenuItems;
import com.nuclearpencil.hj.fitbash.view.activity.home.HomeActivity;
import com.nuclearpencil.hj.fitbash.view.activity.register_login.RegisterLoginActivity;
import com.nuclearpencil.hj.fitbash.view.activity.video.VideoActivity;

/**
 * Created by Hamid on 12/11/2017.
 */

public class DrawerView_testing_on_toolbar extends android.support.v7.widget.AppCompatImageView{

    public static Drawer drawer;
    AccountHeader accountheader;

    public DrawerView_testing_on_toolbar(Context context) {
        super(context);
    }

    public DrawerView_testing_on_toolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DrawerView_testing_on_toolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        GenerateDrawer(getRootView());

    }


    @Override
    public boolean callOnClick() {
        return super.callOnClick();
    }





    private void GenerateDrawer(View view) {

        App.userUtil.addListener(new OnLoginStateChange() {
            @Override
            public void onLoginStateChange(StateType stateType, UserModel user) {
                if (stateType==StateType.LoggedIn) {
                    GenerateUserProfile();
                } else {
                    GenerateGuestProfile();
                }

                if (stateType==StateType.LoggedIn) {
                    accountheader.removeProfile(ge_C.Profile.Drawer_GuestID);
                    GenerateUserProfile();
                } else if (stateType==StateType.LoggedOut){
                    accountheader.removeProfile(ge_C.Profile.Drawer_UserID);
                    GenerateGuestProfile();
                }


            }
        });



        GenerateAccountHeader();
        if (App.userUtil.isLogged()) {
            GenerateUserProfile();
        } else {
            GenerateGuestProfile();
        }


        drawer = new DrawerBuilder()
                .withActivity((HomeActivity)getContext())
                .withAccountHeader(accountheader)
//                .withToolbar(am_toolbar) add toolbar to left
                //.withHeader(R.layout.header)
//                .withHeader(accountheader.getView())
                .addDrawerItems(
                        //MikepenzDrawerlibrary\src\main\java\com\mikepenz\materialdrawer\model\interfaces
                        new SecondaryDrawerItem().withIdentifier(sliderMenuItems.Main.id).withSelectable(false).withName("صفحه ی اصلی").withIcon(new IconicsDrawable(getContext(), FontAwesome.Icon.faw_home).color(Color.rgb(180, 180, 180))),
                        new DividerDrawerItem(),
                        new SecondaryDrawerItem().withIdentifier(sliderMenuItems.Bestsellers.id).withSelectable(false).withName("پربازدیدترین ها").withIcon(new IconicsDrawable(getContext(), GoogleMaterial.Icon.gmd_remove_red_eye).color(Color.rgb(180, 180, 180))).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                                Intent intent = new Intent(getContext(), VideoActivity.class);
                                getContext().startActivity(intent);
                                return false;
                            }
                        }),//.setEnabled(false),
                        new SecondaryDrawerItem().withIdentifier(sliderMenuItems.Favorites.id).withSelectable(false).withName("محبوب ترین ها").withIcon(new IconicsDrawable(getContext(), GoogleMaterial.Icon.gmd_favorite_border).color(Color.rgb(180, 180, 180))).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                                Intent intent = new Intent(getContext(), VideoActivity.class);
                                getContext().startActivity(intent);
                                return false;
                            }
                        }),//.setEnabled(false),
                        new SecondaryDrawerItem().withIdentifier(sliderMenuItems.Newest.id).withSelectable(false).withName("جدیدترین ها").withIcon(new IconicsDrawable(getContext(), FontAwesome.Icon.faw_history).color(Color.rgb(180, 180, 180))).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                            @Override
                            public boolean onItemClick(View view, int i, IDrawerItem iDrawerItem) {
                                Intent intent = new Intent(getContext(), VideoActivity.class);
                                getContext().startActivity(intent);
                                return false;
                            }
                        }),//.setEnabled(false),
                        new DividerDrawerItem(),
                        //new SwitchDrawerItem(),
                        //new ToggleDrawerItem(),
                        //new SectionDrawerItem().withName("lkjkjk"),
                        //new ProfileDrawerItem().withIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_shop)),
                        new SecondaryDrawerItem().withIdentifier(sliderMenuItems.About.id).withName("تماس با ما").withIcon(new IconicsDrawable(getContext(), GoogleMaterial.Icon.gmd_phone).color(Color.rgb(180, 180, 180)))//.setEnabled(false)
                        //material_drawer_item_secondary.xml in mimkepenzlibrary edited for right to left

                )

                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                        //check if the drawerItem is set.
                        //there are different reasons for the drawerItem to be null
                        //--> click on the header
                        //--> click on the footer
                        //those items don't contain a drawerItem

                        //Toast.makeText(Activity_Main.this, String.valueOf(position), Toast.LENGTH_LONG).show();

                        if (drawerItem != null) {
                            DisplayFragment((int) drawerItem.getIdentifier()); // position not work for DividerDrawerItem position
                        }

                        return false;
                    }


                })

                .withDrawerGravity(Gravity.RIGHT)
                .build();





        //use the result object to get different views of the drawer or modify it's data
        //some sample calls

    }


    public void GenerateAccountHeader() {

        accountheader = new AccountHeaderBuilder()
                .withActivity((HomeActivity)getContext())
                .withHeaderBackground(R.drawable.ah_drawer_header)
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile iProfile, boolean b) {
                        switch ((int) iProfile.getIdentifier()) {
                            case ge_C.Profile.UsersMenu.UserInfo:
                                getContext().startActivity(new Intent(getContext(), VideoActivity.class));
                                break;
                            case ge_C.Profile.UsersMenu.Basket:
                                getContext().startActivity(new Intent(getContext(), VideoActivity.class));
                                break;
                            case ge_C.Profile.UsersMenu.Order:
                                getContext().startActivity(new Intent(getContext(), VideoActivity.class));
                                break;
                            case ge_C.Profile.UsersMenu.Exit:

                                App.userUtil.setLogout(getContext());

                                break;
                        }

                        return false;
                    }
                })

                .withOnAccountHeaderSelectionViewClickListener(new AccountHeader.OnAccountHeaderSelectionViewClickListener() {
                    @Override
                    public boolean onClick(View view, IProfile iProfile) {
                        //Toast.makeText(Activity_Main.this, "withOnAccountHeaderSelectionViewClickListener", Toast.LENGTH_LONG).show();
                        switch ((int) iProfile.getIdentifier()) {

                            case ge_C.Profile.Drawer_GuestID:// For Guest
                                HomeActivity activity=(HomeActivity) getContext();
                                activity.startActivityForResult(new Intent(getContext(), RegisterLoginActivity.class), App.userUtil.ActivityRequestCode_CheckLogin);
                                break;

                            case ge_C.Profile.Drawer_UserID:// For User
                                //getContext().startActivity(new Intent(Activity_Main.this,Activity_RegisterLogin.class));
                                break;
                        }

                        return false;
                    }
                })
                //.addProfiles         Can be Several add User
                .build();


    }


    public void GenerateUserProfile() {

        final IProfile profile_User = new ProfileDrawerItem()
                .withName(App.userUtil.getUser().getName())
                //.withEmail(ge_C.Login.Username)
                .withTextColor(Color.RED)
                .withSelectedColor(Color.BLUE)
                .withIcon(ContextCompat.getDrawable(getContext(), R.drawable.ah_ic_drawer_user))
                .withIdentifier(ge_C.Profile.Drawer_UserID);

        accountheader.addProfiles(profile_User,
                //icon selected from  com.mikepenz.google_material_typeface_library.GoogleMaterial ,   com.mikepenz.iconics.typeface.
                // icon pics in http://fontello.com/
                new ProfileSettingDrawerItem().withName("اطلاعات کاربر")
                        .withDescription("اطلاعات کاربر")
                        .withIcon(new IconicsDrawable(getContext(), GoogleMaterial.Icon.gmd_account_box))
                        .withIconColor(Color.GREEN)
                        .withIdentifier(ge_C.Profile.UsersMenu.UserInfo),
                new ProfileSettingDrawerItem()
                        .withName("سبد خرید")
                        .withIcon(new IconicsDrawable(getContext(), GoogleMaterial.Icon.gmd_shopping_basket))//.setEnabled(false),
                        .withIdentifier(ge_C.Profile.UsersMenu.Basket),
                new ProfileSettingDrawerItem()
                        .withName("سفارشات")
                        .withIcon(new IconicsDrawable(getContext(), GoogleMaterial.Icon.gmd_format_list_numbered))//.setEnabled(false),
                        .withIconColor(Color.GREEN)
                        .withIdentifier(ge_C.Profile.UsersMenu.Order),
                new ProfileSettingDrawerItem()
                        .withName("خروج")
                        .withIcon(new IconicsDrawable(getContext(), FontAwesome.Icon.faw_power_off))//.setEnabled(false),
                        .withIconColor(Color.RED)
                        .withIdentifier(ge_C.Profile.UsersMenu.Exit));
    }


    public void GenerateGuestProfile() {

        IProfile profile_Guest = new ProfileDrawerItem()
                .withName("مهمان -> ورود")
                //.withEmail(ge_C.Login.Username)
                .withTextColor(Color.RED)
                .withSelectedColor(Color.BLUE)
                .withIcon(ContextCompat.getDrawable(getContext(), R.drawable.ah_ic_drawer_guest))
                .withIdentifier(ge_C.Profile.Drawer_GuestID);

        accountheader.addProfiles(profile_Guest);

    }



    private void DisplayFragment(int position) {

        Fragment fragment = null;

        if (position == sliderMenuItems.Main.id) {
//            fragment = new AM_Fr_Main();
        } else if (position == sliderMenuItems.ListAllGroup.id) {
//            getContext().startActivity(new Intent(this, Activity_AllGroups.class));

        } else if (position == sliderMenuItems.Bestsellers.id) {
        } else if (position == sliderMenuItems.Favorites.id) {
        } else if (position == sliderMenuItems.Newest.id) {
        } else if (position == sliderMenuItems.About.id) {
        }

        /* // need static sliderMenuItems.Main.id
        switch (position) {
            case sliderMenuItems.Main.id:
                fragment = new F_Main();
                break;
            case 1:
                getContext().startActivity(new Intent(Activity_Main.this, Activity_Product_List.class));
                Toast.makeText(this,"kjhjh",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        */

        if (fragment != null) {
/*
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.am_container_body, fragment);
            fragmentTransaction.commit();
*/

            // set the toolbar title
            //getSupportActionBar().setTitle(title);
        }
    }


    public static Drawer getDrawer() {
        return drawer;
    }


}