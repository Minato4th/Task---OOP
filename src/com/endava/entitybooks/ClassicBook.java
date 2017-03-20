package com.endava.entitybooks;

/**
 * 3/20/2017
 */
public class ClassicBook extends GeneralBook{
    /*private final String PAR_1 = "Fairy tale";
    private final String PAR_2 = "Culinary";
    private final String PAR_3 = "Hunting and Fishing";
    private final String MENU = "\n" +
            " 1. Fairy tale \n" +
            " 2. Culinary \n" +
            " 3. Hunting and Fishing \n";*/

    public ClassicBook(String title, String author, int year) {
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
