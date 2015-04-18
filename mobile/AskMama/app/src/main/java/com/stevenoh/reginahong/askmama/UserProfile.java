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
    private double mHeight; // in cm
    private double mWeight; // in kg
    private Date mDob;
    private int age;
    private boolean mIsMale;
    private double mActiveLevel; // 1.0 / 1.0 -> Sedentary (M/F)
                             // 1.11 / 1.12 -> Lightly active
                             // 1.25 / 1.27 -> Active
                             // 1.48 / 1.45 -> Very active
    private int mActiveLevelChoice;

    private static UserProfile sUser;
    private int mDailyNetCalorie;

    private UserProfile() {
        mDob = new Date();
        mActiveLevelChoice = -1;
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
        mHeight = height * 2.54;
    }

    public void setWeight(double weight) {
        mWeight = weight * 0.453592;
    }

    public void setDob(Date dob) {
        mDob = dob;

    }

    public void setMale(boolean isMale) {
        mIsMale = isMale;
        if (mActiveLevelChoice >= 0)
            setActiveLevel(mActiveLevelChoice);
    }

    public void setActiveLevel(int activeLevel) {
        mActiveLevelChoice = activeLevel;
        switch (activeLevel) {
            case 0:
                mActiveLevel = 1.0;
                break;
            case 1:
                mActiveLevel = mIsMale ? 1.11 : 1.12;
                break;
            case 2:
                mActiveLevel = mIsMale ? 1.25 : 1.27;
                break;
            case 3:
                mActiveLevel = mIsMale ? 1.48 : 1.45;
                break;
        }
    }


    public boolean[] getGoal() {
        return mGoal;
    }

    public boolean getGoal(int idx) {
        return mGoal[idx];
    }

    /*
        Height in inches
     */
    public double getHeight() {
        return mHeight * 0.393701;
    }

    /*
        Weight in pounds
     */
    public double getWeight() {
        return mWeight * 2.20462;
    }

    public Date getDob() {
        return mDob;
    }

    public boolean isMale() {
        return mIsMale;
    }

    public int getActiveLevelChoice() {
        return mActiveLevelChoice;
    }

    public int getDailyNetCalorie() {
           
        if (mIsMale) {

        } else {

        }

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


