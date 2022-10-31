package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static com.company.Methods.*;

public class Pro02_06 {




    static Scanner scan;



    public static void main(String[] args) throws IOException {

        Brands brand1 = new Brands();

         boolean runGame = true;

         Methods m1 = new Methods();


        scan = new Scanner(System.in);
        boolean shouldContinue = true;


        //Reading from a file
/*
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/user/Desktop/new.txt"));

        String line = bufferedReader.readLine(); {}
        while (line != null) {
            brand1.brandslist.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

 */







        //  ArrayList storing brands already provided by a user
        ArrayList<String> usersList = new ArrayList<>();

        while(shouldContinue) {
            System.out.println("Wybierz opcje");
            System.out.println("1. Rozpocznij gre");
            System.out.println("2. Pokaz tabele wynikow");
            System.out.println("3. Zakoncz gre");

            Scanner sc = new Scanner(System.in);

            int useChoice = sc.nextInt();

            switch (useChoice) {


            case 1 ->  {

        System.out.println("Witaj w grze, w ktorej Twoim zadaniem jest podanie jak najwiekszej liczby marek samochodów");
        System.out.println("Za kazda poprawna marke samochodu otrzymasz 5 punktow");
        System.out.println("Jesli nie jestes w stanie wymyslec kolejnej marki, mozesz w kazdej chwili zakonczyc gre wciskajac przycisk X na klawiaturze");
        System.out.println("");

        while (runGame) {
            System.out.println("");
            System.out.println("Runda: " + Methods.setCounter1());
            System.out.println("Podaj marke samochodu");

            m1.readFile("C:\\Users\\Miłosz\\Desktop\\new1.txt", brand1.brandslist);
            m1.convertingArrayListToUppercase(brand1.brandslist);

       /*

            while (scan.hasNext()) {
                String  brandslist =scan.nextLine();
*/

            Scanner scanner1 = new Scanner(System.in);
            String input = scanner1.nextLine();

            //Converting input to UpperCase
            String inputConverted =  input.toUpperCase(Locale.ROOT);


            for (int i=0; i < brand1.brandslist.size(); i++ ) {


                if (input.isEmpty()) {
                    System.out.println("Nie podano zadnej marki. Wprowadz nazwe odpowiedniej marki");
                    break;

                    // Checking if the user gussed a brand stored in the brandslist + checking if user's input is not a duplicate
                } else if (brand1.brandslist.get(i).equals(inputConverted) && !usersList.contains(inputConverted)) {
                    System.out.println("Match!!");
                    System.out.println("Zdobywasz 5 punktow");
                    // Storing user's score
                    m1.score1.add(Methods.getResult());
                    //Adding user's input into the userList
                    usersList.add(inputConverted);
                    break;



                    // Condition if a brand is correct but already given
                } else if (brand1.brandslist.get(i).equals(inputConverted) && usersList.contains(inputConverted)) {
                    System.out.println("Duplikat! Ta marka zostala juz podana. Podaj inna marke");
                    break;


                    // Provding wrong answer  If condition and both else if are false printing this
                } else if (!brand1.brandslist.get(i).equals(inputConverted) && i == brand1.brandslist.size() -1) {
                    System.out.println("Pudło");
                    break;



                    //Ending the game
                } else if (input.equals("X") || input.equals("x")) {
                    System.out.println("Gra zakonczona");
                    // Suming the final resolut and printing
                    System.out.println("Ostateczny wynik w grze to: " + m1.sumFinalResult1(m1.score1));
                    // Storing the final resoult in a file
                    writeScore(m1.sumFinalResult1(m1.score1));
                    runGame = false;
                    break;



                } else {

                } }}}

                case 2 ->  Methods.fetchResults();

                case  3 ->  {System.out.println("Wyjscie z gry");
                             System.out.println("Do widzenia");
                 shouldContinue = false; }

                default ->
                    System.out.println(" Error : wybierz jedna  z powyzszych opcji");









    } } }}





































        //  }












































