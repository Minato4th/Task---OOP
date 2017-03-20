package com.endava.service;

import com.endava.entitybooks.*;
import com.endava.validator.Checking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 3/20/2017
 */
public class Menu {

    private List<GeneralBook> generalBooks = new ArrayList<>();
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private int currentPositin = -1;
    private Checking checking = new Checking();

    public void mainMenu() throws IOException {
        boolean done = true;
        while (done){
            System.out.println("Please chose what to do :\n"
                    + "1. Insert book \n"
                    + "2. View books \n"
                    + "3. Exit");

            int buff = (int)checking.digitCheck();
            if (buff == 1) {
                insertData();
                done = false;
            }
            else if (buff == 2) {
                viewData();
                done = false;
            }
            else if (buff < 1 || buff > 3){
                System.out.println("Inexistent command");
                done = true;
            }else if (buff == 3){
                System.out.println("Bye!");
                done = false;
            }
        }
    }


    public void insertData() throws IOException {
        System.out.println("Please chose book to insert \n"
                + "1. Classic Book \n"
                + "2. Science Book \n"
                + "3. Fiction Book \n"
                + "4. Copy to Pure Book \n");

        System.out.println("And then please insert next data for Book \n"
                + "Title \n"
                + "Author \n"
                + "Year \n");

        int buff = Integer.parseInt(reader.readLine());
        if (buff == 1) generalBooks.add(new ClassicBook(reader.readLine(), reader.readLine(), checking.yearSet()));
        else if (buff == 2) generalBooks.add(new ScienceBook(reader.readLine(), reader.readLine(), checking.yearSet()));
        else if (buff == 3) generalBooks.add(new FictionBook(reader.readLine(), reader.readLine(), checking.yearSet()));
        else if (buff == 4) copyBook();

        if (buff > 0 && buff < 4){
            currentPositin++;
            System.out.println("Please enter Popularity: ");
            generalBooks.get(currentPositin).setPopularity(checking.popularitySet());

            System.out.println("Please enter Pages: ");
            generalBooks.get(currentPositin).setPages(checking.pagesSet());

            System.out.println("Please enter Price: ");
            generalBooks.get(currentPositin).setCost(checking.costSet(generalBooks.get(currentPositin).getPopularity(), generalBooks.get(currentPositin)));
            generalBooks.get(currentPositin).setPureCost(checking.getPureCost());

            System.out.println("Please enter Parameter: ");
            generalBooks.get(currentPositin).setParameter(reader.readLine());
            mainMenu();
        }
    }

    public void viewData() throws IOException {
        int num = 0;
        for (GeneralBook book : generalBooks) {
            System.out.println("Book : " + num);
            System.out.println(book.getTitle());
            System.out.println(book.getCost());
            System.out.println();
            num++;
        }
        mainMenu();
    }

    private void copyBook() throws IOException {
        System.out.println("What book to copy \n");
        boolean done = true;
        while (done){
            int copyNumber = (int) checking.digitCheck();
            if (copyNumber >= 0 && copyNumber < generalBooks.size()) {
                generalBooks.add(new PureBook(generalBooks.get(copyNumber).getTitle(),
                        generalBooks.get(copyNumber).getAuthor(),
                        generalBooks.get(copyNumber).getYear()));
                generalBooks.get(generalBooks.size()-1).setPages(generalBooks.get(copyNumber).getPages());
                generalBooks.get(generalBooks.size()-1).setPopular(generalBooks.get(copyNumber).getPopularity());
                generalBooks.get(generalBooks.size()-1).setCost(generalBooks.get(copyNumber).getPureCost());
                System.out.println("Done!\n");
                currentPositin++;
                mainMenu();
            }else {
                System.out.println("Inexistent Book, try again :");
            }
        }
    }
}
