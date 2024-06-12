package com.example.counterwhale;

public class Counter {
    private String countWhat = "";
    private int count = 0;

    public int increaseCount (int currentCount) {
        if (count < 99999 && count > -99999){
            count = currentCount != count ? (currentCount+1) : (count+1);
        }
        return count;
    }

    public int decreaseCount (int currentCount) {
        if (count < 99999 && count > -99999){
            count = currentCount != count ? (currentCount-1) : (count-1);
        }
        return count;
    }

    public int getCount () {
        return count;
    }

    public String getCountWhat() {
        return countWhat;
    }

    public void setCountWhat(String countWhat) {
        this.countWhat = countWhat;
    }


}
