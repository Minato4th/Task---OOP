package com.endava.entitybooks;

/**
 * Created by aborisco on 3/20/2017.
 */
public class FictionBook extends GeneralBook {
    public FictionBook(String title, String author, int year) {
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
