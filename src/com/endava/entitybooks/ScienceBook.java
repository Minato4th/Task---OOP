package com.endava.entitybooks;

public class ScienceBook extends GeneralBook{
    public ScienceBook(String title, String author, int year) {
        super(title, author, year);
    }

    private String parameter;

    @Override
    public void setParameter(String parameter) {
        this.parameter = parameter;
        updateTitle();
    }

    private void updateTitle(){
        setTitle(getAuthor() + " - Classic Book, par: \'" + parameter + "\'");
    }
}
