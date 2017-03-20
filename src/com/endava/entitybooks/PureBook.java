package com.endava.entitybooks;

/**
 * 3/20/2017
 */
public class PureBook extends GeneralBook {
    public PureBook(String title, String author, int year) {
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
