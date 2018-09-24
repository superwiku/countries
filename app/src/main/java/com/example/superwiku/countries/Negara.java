package com.example.superwiku.countries;

import java.util.List;

public class Negara {
    private String name,capital,region,flag;
    private String subregion;

    public Negara(String name, String capital, String region, String flag) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.flag = flag;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getSubregion() {
        return subregion;
    }

    public void setSubregion(String subregion) {
        this.subregion = subregion;
    }
}
