package com.example.jason;

import com.google.gson.annotations.SerializedName;

public class GameCompany {
    @SerializedName("name")
    public String gameCompany;
    @SerializedName("year")
    public String yearFounded;
    @SerializedName("console")
    public String consoleName;

    public GameCompany(String name, String year, String console)
    {
        gameCompany = name;
        yearFounded = year;
        consoleName = console;
    }

    public String getGameCompany(){
        return gameCompany;
    }
    public String getYearFounded(){
        return yearFounded;
    }
    public String getConsoleName(){
        return consoleName;
    }

    public void setGameCompany(String gameCompany) {
        this.gameCompany = gameCompany;
    }

    public void setYearFounded(String yearFounded) {
        this.yearFounded = yearFounded;
    }

    public void setConsoleName(String consoleName) {
        this.consoleName = consoleName;
    }
}
