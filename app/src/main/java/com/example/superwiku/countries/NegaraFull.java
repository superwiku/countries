package com.example.superwiku.countries;

import java.io.Serializable;
import java.util.List;

public class NegaraFull implements Serializable {
    private String name,capital,region,flag;
    private Long population,area;
    private List<Float> latlng;
    private List<Currency> currencies;
    private List<Language> languages;

    public NegaraFull(String name, String capital, String region, String flag, Long population, Long area, List<Float> latlng, List<Currency> currencies, List<Language> languages) {
        this.name = name;
        this.capital = capital;
        this.region = region;
        this.flag = flag;
        this.population = population;
        this.area = area;
        this.latlng = latlng;
        this.currencies = currencies;
        this.languages = languages;
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

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getArea() {
        return area;
    }

    public void setArea(Long area) {
        this.area = area;
    }

    public List<Float> getLatlng() {
        return latlng;
    }

    public void setLatlng(List<Float> latlng) {
        this.latlng = latlng;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }
}
