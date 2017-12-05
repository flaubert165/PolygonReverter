package com.polygonreverter;

import java.io.*;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        Main obj = new Main();
        StringBuilder newPolygon = obj.processPolygon();
        System.out.println("Dados do processamento para comparação:\n");
        System.out.println("O polígono convertido possui: " + newPolygon.length() + " caracteres.\n\n" + "Polígono Convertido: \n\n" + "POLYGON((" + newPolygon + "))");
    }

    private StringBuilder processPolygon() throws Exception {

        int count1 = 0;
        int count2 = 0;
        String wrongPolygon;
        String currentCoord = "";
        StringBuilder newPolygon = new StringBuilder();

        wrongPolygon = readFile();

        if(wrongPolygon != null && !wrongPolygon.isEmpty()) {

            System.out.println("O polígono que será convertido possui: " + wrongPolygon.length() + " caracteres.\n");
            System.out.println("Polígono que será convertido: \n\n" + wrongPolygon);

            while (count1 < wrongPolygon.length()) {

                String coordPart1 = "";
                String coordPart2 = "";

                while (count1 < wrongPolygon.length() && !wrongPolygon.substring(count1, count1 + 1).equals(",")) {
                    currentCoord += wrongPolygon.substring(count1, count1 + 1);
                    count1++;
                }


                while (count2 < currentCoord.length() && !currentCoord.substring(count2, count2 + 1).equals(" ")) {
                    coordPart1 += currentCoord.substring(count2, count2 + 1);
                    count2++;
                }


                coordPart2 += currentCoord.substring(coordPart1.length() + 1, currentCoord.length());

                newPolygon.append(coordPart2 + " " + coordPart1);

                if (count1 + 1 < wrongPolygon.length()) {
                    newPolygon.append(",");
                }

                count1++;
                count2 = 0;
                currentCoord = "";
            }
        }else {
            throw new Exception("Arquivo vazio!");
        }

        return newPolygon;
    }

    private String readFile(){

        String oldPolygon = "";

        try {

            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new FileReader(getPath()));
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }

            oldPolygon = sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oldPolygon;
    }

    private String getPath(){

        URL url = getClass().getResource("polygon.txt");

        return url.getPath();

    }
}

