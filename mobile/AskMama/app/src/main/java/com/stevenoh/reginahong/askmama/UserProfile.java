package com.stevenoh.reginahong.askmama;


import java.util.Date;

/**
 * Singleton user profile
 */
public class UserProfile {
    private boolean[] mGoal = new boolean[4]; // 0 -> Eat Healthy
                                              // 1 -> Special dietary needs
                                              // 2 -> Lose weight
                                              // 3 -> Gain weight
    private double mHeight; // in inches
    private double mWeight; // in pounds
    private Date mDob;
    private boolean mIsMale;
    private int mActiveLevel; // 0 -> Sedentary
                             // 1 -> Lightly active
                             // 2 -> Active
                             // 3 -> Very active

    private static UserProfile sUser;
    private int mDailyNetCalorie;

    private UserProfile() {
        mDob = new Date();
    }

    public static UserProfile get(){
        if (sUser == null)
            sUser = new UserProfile();
        return sUser;
    }

    public void setGoal(int idx, boolean isChecked) {
        mGoal[idx] = isChecked;
    }

    public void setHeight(double height) {
        mHeight = height;
    }

    public void setWeight(double weight) {
        mWeight = weight;
    }

    public void setDob(Date dob) {
        mDob = dob;
    }

    public void setMale(boolean isMale) {
        mIsMale = isMale;
    }

    public void setActiveLevel(int activeLevel) {
        mActiveLevel = activeLevel;
    }


    public boolean[] getGoal() {
        return mGoal;
    }

    public boolean getGoal(int idx) {
        return mGoal[idx];
    }

    public double getHeight() {
        return mHeight;
    }

    public double getWeight() {
        return mWeight;
    }

    public Date getDob() {
        return mDob;
    }

    public boolean isMale() {
        return mIsMale;
    }

    public int getActiveLevel() {
        return mActiveLevel;
    }

    public int getDailyNetCalorie() {
        return mDailyNetCalorie;
    }

    public String toString() {
        String out = "\n";
        out += "Goal = " + mGoal[0] + ", " + mGoal[1] + ", " + mGoal[2] + ", " + mGoal[3] + " " + "\n";
        out += "Height = " + mHeight + "\n";
        out += "Weight = " + mWeight + "\n";
        out += "DOB = " + mDob + "\n";
        out += "Gender = " + mIsMale + "\n";
        out += "ActiveLevel = " + mActiveLevel;

        return out;
    }
}


