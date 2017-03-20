package com.endava.entitybooks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 3/20/2017
 */
public abstract class GeneralBook {
    public BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private double popularity;
    private int pages;
    private double cost;
    private double pureCost;

    private String title;
    private String author;
    private int year;

    @Override
    public String toString() {
        return "com.endava.entitybooks.GeneralBook{" +
                "popularity=" + popularity +
                ", pages=" + pages +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeneralBook)) return false;

        GeneralBook that = (GeneralBook) o;

        if (Double.compare(that.getPopularity(), getPopularity()) != 0) return false;
        if (getPages() != that.getPages()) return false;
        if (Double.compare(that.getCost(), getCost()) != 0) return false;
        if (year != that.year) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        return author != null ? author.equals(that.author) : that.author == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getPopularity());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getPages();
        temp = Double.doubleToLongBits(getCost());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + year;
        return result;
    }

    public GeneralBook(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity){
        this.popularity = popularity;
    }

    public void setPopular(double popularity) {
        this.popularity = popularity;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPureCost() {
        return pureCost;
    }

    public void setPureCost(double pureCost) {
        this.pureCost = pureCost;
    }

    public abstract void setParameter(String parameter);
}
