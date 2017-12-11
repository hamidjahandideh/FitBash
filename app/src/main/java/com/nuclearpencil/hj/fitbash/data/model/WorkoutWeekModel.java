package com.nuclearpencil.hj.fitbash.data.model;


import com.google.gson.annotations.SerializedName;
import com.hj.calendar.model.CalendarBaseModel;

import java.util.ArrayList;

/**
 * Created by hamid.jahandideh on 11/30/15.
 * email : hamid.jahandideh@yahoo.com
 */
public class WorkoutWeekModel extends CalendarBaseModel {

    @SerializedName("Id") private int Id;
    @SerializedName("Name") private String Name;
    @SerializedName("Creator") private String Creator;
    @SerializedName("Goal") private String Goal;
    @SerializedName("Level") private String Level;
    @SerializedName("Gender") private String Gender;
    @SerializedName("ProfilePicture") private String ProfilePicture;
    @SerializedName("MusclesInvolved") private String MusclesInvolved;
    @SerializedName("TotalSet") private String TotalSet;
    @SerializedName("TotalExercise") private String TotalExercise;
    @SerializedName("TotalTime") private String TotalTime;
    @SerializedName("TotalCardio") private String TotalCardio;
    @SerializedName("AnatomyPicture") private String AnatomyPicture;
    @SerializedName("ExerciseList") private ArrayList<ExerciseModel> ExerciseList;

    public WorkoutWeekModel(int day) {
        super(day);
    }

    public WorkoutWeekModel(int dayNumber, int id, String name, String creator, String goal, String level, String gender, String profilePicture, String musclesInvolved, String totalSet, String totalExercise, String totalTime, String totalCardio, String anatomyPicture, ArrayList<ExerciseModel> exerciseList) {
        super(dayNumber);
        Id = id;
        Name = name;
        Creator = creator;
        Goal = goal;
        Level = level;
        Gender = gender;
        ProfilePicture = profilePicture;
        MusclesInvolved = musclesInvolved;
        TotalSet = totalSet;
        TotalExercise = totalExercise;
        TotalTime = totalTime;
        TotalCardio = totalCardio;
        AnatomyPicture = anatomyPicture;
        this.ExerciseList = exerciseList;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return Id;
    }

    public String getCreator() {
        return Creator;
    }

    public String getGender() {
        return Gender;
    }

    public String getAnatomyPicture() {
        return AnatomyPicture;
    }

    public String getGoal() {
        return Goal;
    }

    public String getLevel() {
        return Level;
    }

    public String getMusclesInvolved() {
        return MusclesInvolved;
    }

    public String getProfilePicture() {
        return ProfilePicture;
    }

    public String getTotalCardio() {
        return TotalCardio;
    }

    public String getTotalExercise() {
        return TotalExercise;
    }

    public String getTotalSet() {
        return TotalSet;
    }

    public String getTotalTime() {
        return TotalTime;
    }


    public ArrayList<ExerciseModel> getExerciseList() {
        return ExerciseList;
    }
}
