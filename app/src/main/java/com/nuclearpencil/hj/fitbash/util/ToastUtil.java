package com.nuclearpencil.hj.fitbash.util;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nuclearpencil.hj.fitbash.R;

/**
 * Created by Hamid on 12/10/2017.
 */

public class ToastUtil {

    public static void ShowToast(Context ctx, String text){

        Toast toast=new Toast(ctx);
        toast.setGravity(Gravity.CENTER,0,0);
        View view= LayoutInflater.from(ctx).inflate(R.layout.toast_layout, null);
        TextView textView= (TextView) view.findViewById(R.id.text);
        textView.setTextColor(ContextCompat.getColor(ctx, R.color.md_blue_500));
        textView.setText(text);
        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();

    }


}
