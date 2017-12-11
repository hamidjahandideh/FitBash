package com.nuclearpencil.hj.fitbash.data.model;

import android.os.Parcel;

/**
 * Created by hamid.jahandideh on 11/30/15.
 * email : hamid.jahandideh@yahoo.com
 */
public class ProgramModel  {


    private int id;
    private String title;



    public ProgramModel() {
    }


    public ProgramModel(int id, String title) {
        this.id = id;
        this.title = title;


    }

    protected ProgramModel(Parcel in) {
        id = in.readInt();
        title = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




}
