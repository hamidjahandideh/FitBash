package com.nuclearpencil.hj.fitbash.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by hamid.jahandideh on 11/30/15.
 * email : hamid.jahandideh@yahoo.com
 */
public class ExerciseModel {

    @SerializedName("Id") private int Id;
    @SerializedName("Name") private String Name;
    @SerializedName("Picture1") private String Picture1;
    @SerializedName("Picture2") private String Picture2;
    @SerializedName("Gif") private String Gif;
    @SerializedName("Describtion") private String Describtion;
    @SerializedName("Rate") private String Rate;
    @SerializedName("Equipment") private String Equipment;
    @SerializedName("MuscleTarget") private String MuscleTarget;
    @SerializedName("ExerciseType") private String ExerciseType;


    public ExerciseModel(){

    }


    public ExerciseModel(int id,String name,String picture1,String picture2,String gif,String describtion,String rate,String equipment,String muscleTarget,String exerciseType){

        this.Id=id;
        this.Name=name;
        this.Picture1=picture1;
        this.Picture2=picture2;
        this.Gif=gif;
        this.Describtion=describtion;
        this.Rate=rate;
        this.Equipment=equipment;
        this.MuscleTarget=muscleTarget;
        this.ExerciseType=exerciseType;
    }


    public int getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public String getDescribtion() {
        return Describtion;
    }

    public String getEquipment() {
        return Equipment;
    }

    public String getExerciseType() {
        return ExerciseType;
    }

    public String getGif() {
        return Gif;
    }

    public String getMuscleTarget() {
        return MuscleTarget;
    }

    public String getPicture1() {
        return Picture1;
    }

    public String getPicture2() {
        return Picture2;
    }

    public String getRate() {
        return Rate;
    }


}
