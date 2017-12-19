package com.nuclearpencil.hj.fitbash.view.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.GravityEnum;
import com.afollestad.materialdialogs.MaterialDialog;
import com.nuclearpencil.hj.fitbash.R;
import com.nuclearpencil.hj.fitbash.data.model.ProgramModel;
import com.nuclearpencil.hj.fitbash.view.activity.BaseActivity;
import com.nuclearpencil.hj.fitbash.view.activity.HomeActivity;
import com.nuclearpencil.hj.fitbash.view.fragment.ProgramDetailsFragment;

/**
 * Created by Hamid on 12/2/2017.
 */

public class ProgramHeaderViewHolder extends BaseViewHolder {

    ViewGroup rootView;
    TextView tv_title;
    ImageView iv;
//            ProgressView progressbar;


    public ProgramHeaderViewHolder(final Context context, View itemView) {
        super(context,itemView);


        rootView = (ViewGroup) itemView;
        RelativeLayout rl_goal = (RelativeLayout) rootView.findViewById(R.id.rl_goal);
        RelativeLayout rl_level = (RelativeLayout) rootView.findViewById(R.id.rl_level);
        RelativeLayout rl_gender_age = (RelativeLayout) rootView.findViewById(R.id.rl_gender_age);
        RelativeLayout rl_days_count = (RelativeLayout) rootView.findViewById(R.id.rl_days_count);
        RelativeLayout rl_weeks = (RelativeLayout) rootView.findViewById(R.id.rl_weeks);


        rl_goal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(context)
                        .title("Please select one item")
                        .items(new String[]{"All Goals","Build Muscle","Lose Fat","Transform","Improve Sport","Endurance","Flexibility"})
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
/**
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 **/

                                return true;
                            }
                        })
                        .negativeText("All Goals")
                        .titleGravity(GravityEnum.END)
                        .buttonsGravity(GravityEnum.END)
                        .itemsGravity(GravityEnum.END)
                        .show();
            }
        });


        rl_level.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(context)
                        .title("لطفا یکی از گزینه ها را انتخاب کن")
                        .items(new String[]{"تمام مراحل","تازه کار","متوسط","پیشرفته"})
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
/**
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 **/

                                return true;
                            }
                        })
                        .negativeText("تمام مراحل")
                        .titleGravity(GravityEnum.END)
                        .buttonsGravity(GravityEnum.END)
                        .itemsGravity(GravityEnum.END)
                        .show();
            }
        });

        rl_gender_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(context)
                        .title("لطفا یکی از گزینه ها را انتخاب کن")
                        .items(new String[]{"تمامی جنسیت/ سنین","همه","فقط مردان","مرد :نوجوان","مرد :20-39","مرد :بالای 40","فقط زنان","زن : نوجوان","زن : 20-39","زن : بالای 40"})
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
/**
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 **/

                                return true;
                            }
                        })
                        .negativeText("تمامی جنسیت/ سنین")
                        .titleGravity(GravityEnum.END)
                        .buttonsGravity(GravityEnum.END)
                        .itemsGravity(GravityEnum.END)
                        .show();
            }
        });

        rl_days_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(context)
                        .title("لطفا یکی از گزینه ها را انتخاب کن")
                        .items(new String[]{"با هر طول","مداوم","1-14 روز","15-30 روز","31-60 روز","91-90 روز","91-180 روز","181-365 روز",""})
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
/**
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 **/

                                return true;
                            }
                        })
                        .negativeText("با هر طول")
                        .titleGravity(GravityEnum.END)
                        .buttonsGravity(GravityEnum.END)
                        .itemsGravity(GravityEnum.END)
                        .show();
            }
        });


        rl_days_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(context)
                        .title("لطفا یکی از گزینه ها را انتخاب کن")
                        .items(new String[]{"با هر طول","مداوم","1-14 روز","15-30 روز","31-60 روز","91-90 روز","91-180 روز","181-365 روز"})
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
/*
*
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 *
*/

                                return true;
                            }
                        })
                        .negativeText("با هر طول")
                        .titleGravity(GravityEnum.END)
                        .buttonsGravity(GravityEnum.END)
                        .itemsGravity(GravityEnum.END)
                        .show();
            }
        });


        rl_weeks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MaterialDialog.Builder(context)
                        .title("لطفا یکی از گزینه ها را انتخاب کن")
                        .items(new String[]{"هفت","شش","پنج","چهار","سه","دو","یک"})
                        .itemsCallbackSingleChoice(-1, new MaterialDialog.ListCallbackSingleChoice() {
                            @Override
                            public boolean onSelection(MaterialDialog dialog, View view, int which, CharSequence text) {
/*
*
                                 * If you use alwaysCallSingleChoiceCallback(), which is discussed below,
                                 * returning false here won't allow the newly selected radio button to actually be selected.
                                 *
*/

                                return true;
                            }
                        })
                        .negativeText("هفت")
                        .titleGravity(GravityEnum.END)
                        .buttonsGravity(GravityEnum.END)
                        .itemsGravity(GravityEnum.END)
                        .show();
            }
        });





    }


    @Override
    public void bind(Object object, final int position) {

        final ProgramModel programModel =(ProgramModel) object;


        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//or itemView.setOnClickListener
                BaseActivity activity=(BaseActivity) context;
                activity.pushFragment(new ProgramDetailsFragment());
            }
        });



    }

    @Override
    public void initWidgets(View view) {

    }

    @Override
    public void setListeners(View view) {

    }
}

