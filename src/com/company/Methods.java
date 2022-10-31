package com.company;

import com.opencsv.CSVWriter;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Methods {
    static int counter;
    static int counter1 =0;
    public static final String CSV_Pathname = "C:\\\\\\\\Users\\\\\\\\Miłosz\\\\\\\\Downloads\\\\\\\\Baza  - Base - Baza  - Base.csv";


    // Converting final result to String
    public static  String convertIntToSting( int intToConvert) {
        String convertedInt = String.valueOf(intToConvert);
        return convertedInt;
    }




    //  ArrayList storing user's score
    ArrayList<Integer> score1 = new ArrayList<>();

    LocalDate myObj = LocalDate.now();


          // Writing final result into a file
        public void writeResultIntoFile (String fileName,int data) throws IOException {
            FileWriter fw = new FileWriter(fileName, true);
            PrintWriter pw = new PrintWriter(fw);
            pw.println( "Data: "+ myObj + "  " + "Wynik: " + data);
            pw.close();
            fw.close();

    }

  // wrting final result into the database

    public static void writeScore(int result) {
        LocalDate date = LocalDate.now();
        String dateToString = String.valueOf(date);


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_brands_game", "root","");
            String query = "INSERT INTO  results(Result,  Date) VALUES (?,?)";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,result );
            ps.setString(2 ,dateToString);

            int count =   ps.executeUpdate();




            ps.close();
            con.close();



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    // method to sum scored final result ( replaced by the method below)
    public int SumFinalResult (ArrayList <Integer> result) {
        int myInt= result.stream().mapToInt(value -> value).sum();
            return myInt;
    }

    // method to sum scored final result
    public int sumFinalResult1 (ArrayList<Integer> result) {
        int sum = 0;
        for (int i = 0; i < result.size(); i++) {
            sum += result.get(i);

        }
        return sum;
    }

    public void readFile ( String fileName, ArrayList data) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);

        String line;

        while ((line = br.readLine()) != null) {
            data.add(line);


            ;
        }
    }
        public void convertingArrayListToUppercase (ArrayList<String> nameOfArrayList) {
            for (int i = 0; i < nameOfArrayList.size(); i++) {

                String brandlistUpper = nameOfArrayList.get(i).toUpperCase(Locale.ROOT);
                nameOfArrayList.set(i, brandlistUpper);
                for (String s : nameOfArrayList) ;
 } }

            public static String checkNumberOfRows (String fileName) throws IOException {
            String line;
            int rows =0;

            File myfile = new File(fileName);

            FileReader fr = new FileReader(myfile);

            BufferedReader bufferedReader = new BufferedReader(fr);

            while((line = bufferedReader.readLine()) !=null) {
                String [] myArray = line.split(",");
                rows++;


            }
            String convertedRows = String.valueOf(rows);
            return convertedRows;


                // Writing final result into a CSV file
        } public static void writeToFileCSV (String fileName, int sumedFinalResult) throws IOException {
        LocalDate date = LocalDate.now();
            String dateToString = String.valueOf(date);
            File myfile1 = new File(fileName);
            FileWriter fileWriter = new FileWriter(myfile1,true);
           CSVWriter csvWriter = new CSVWriter(fileWriter, ',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

           String [] myArray = { checkNumberOfRows(fileName), convertIntToSting(sumedFinalResult), dateToString };

           csvWriter.writeNext(myArray);
           csvWriter.close();
    }

    // reading and printing table of results

    public static void  readResults (String filename) throws IOException {

        File myfile = new File(filename);
        String line;

        FileReader fr = new FileReader(myfile);

        BufferedReader bufferedReader = new BufferedReader(fr);

        while ((line = bufferedReader.readLine()) != null) {
            String[] myArray = line.split(",");
            for (String s : myArray) {
                System.out.printf("%-20s", s);
            }
            System.out.println();

        }
    }
    // priting results from the database
    public static void fetchResults () {
        String query = "SELECT * FROM results";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_brands_game", "root", "");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData rsmd = rs.getMetaData();


            System.out.printf("%-15s%-15s%-10s%n", rsmd.getColumnLabel(1), rsmd.getColumnLabel(2), rsmd.getColumnLabel(3));
            while (rs.next()) {
//

                System.out.printf("%-15s%-15s%-10s%n", rs.getInt(1), rs.getInt(2), rs.getString(3));


            }
         st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }





    // method to count points
    public static int getResult() {
        counter =+5;
        return counter;


    }

    // method to count rounds
  public static int setCounter1 () {
        counter1++;
        return counter1;
    }





}
