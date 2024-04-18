package main;

import java.awt.Color;
import java.io.File;
import java.util.Scanner;
import source.Picture;

public class Main{

    final static int RED = 1;                                                   
    final static int GREEN = 2;
    final static int BLUE = 3;

    final static int min = 0;                                                    //minimum of the values of rgb and the dimensions
    final static int maxDimensions = 1000;                                       //maximum of the value dimensions
    final static int maxColors = 255;                                            //maximum of the value rgb

    final static int rangeDimensions = maxDimensions - min + 1;                  //range for the dimensions used in the @param Math.random() function
    final static int rangeColors = maxColors - min + 1;                          //range for the colors used in the @param Math.random() function

    static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args){

        userInterface();

    }

    static private void userInterface()
    {
        printUserChoices();
        switch(scanner.nextInt())
        {
            case 1: 
                makePicture();
                break;
            case 2:
                randomPicture();
                break;
            case 3:
                extractPicture(getPicture());
                break;
            case 4:
                mirrorPicture(getPicture());
                break;
            case 5:
                boundingBox(getPicture());
                break;
            case 6:
                rotatePicture(getPicture());
                break;
            case 7:
                printAllFiles();
                break;
            default: 
                return;
        }
        userInterface();
    }

    static void printUserChoices()
    {
        System.out.println("> Übungsblatt 3 <");
        System.out.println("1 > 1.1 Ein monochromes Bild wird durch eine Benutzereingabe der RGB-Werte (0 - 255) erstellt ");
        System.out.println("2 > 1.2 Ein Bild mit einer zufälligen Größe zwischen 1000 x 1000 Pixeln und zufälligen Farben wird erstellt");
        System.out.println("3 > 1.3 Auf einem Bild wird ein Rot-, Grün- und Blaufilter angewandt");
        System.out.println("4 > 2.1 Eine Bilddatei wird eingelesen und horizontal gespiegelt");
        System.out.println("5 > 2.2 Eine Bilddatei wird eingelesen und um eine Bounding Box erweitert");
        System.out.println("6 > 2.3 Eine Bilddatei wird eingelesen und um einen Winkel 'Alpha' gegen den Uhrzeigersinn rotiert");
        System.out.println("7 > Alle verfügbaren Bilder werden genannt");
        System.out.println("8 > Programm wird beendet");
        System.out.print(">>> ");
    }

    static void printAllFiles()                 //code von der Seite https://stackoverflow.com/questions/5694385/getting-the-filenames-of-all-files-in-a-folder genommen
    {
        File folder = new File("Übungsblatt3/Picture/src/ref");
        File[] listOfFiles = folder.listFiles();
        
        System.out.println("<");

        if(listOfFiles != null) 
        {
            for (int i = 0; i < listOfFiles.length; i++) 
            {
                if (listOfFiles[i].isFile()) 
                    System.out.println("> " + listOfFiles[i].getName());
            }
        }
        System.out.println("<");
    }

    static private int getIntValue(String value)
    {
        System.out.println("> Wert für " + value + " eingeben");
        System.out.print(">>>");
        return scanner.nextInt();
    }

    static private Picture getPicture()
    {
        System.out.println("> Bitte den kompletten Namen der Bilddatei angeben (inlusive .jpeg / .png)");
        System.out.print(">>> ");
        String name = scanner.next();
        try
            {
                return new Picture("ref/" + name);
            } 
            catch(IllegalArgumentException e)
            {
                getPicture();
            }
        return null;
    }

    static private void randomPicture()
    {
        int width = (int) (Math.random() * rangeDimensions) + min;
        int height = (int) (Math.random() * rangeDimensions) + min;
        
        Picture random = new Picture(width, height);

        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                int r = (int) (Math.random() * rangeColors) + min;
                int g = (int) (Math.random() * rangeColors) + min;
                int b = (int) (Math.random() * rangeColors) + min;

                int rgb = r * 65536 + g * 256 + b;

                random.setRGB(i, j, rgb);
            }
        }
        random.show();
    }

    static private void makePicture()
    {
        Picture pic = new Picture(200, 200);

        int r = - 1, g = -1, b = -1;
        
        while(r < 0 || r > 255) 
            {
                r = getIntValue("r");
            }
        while(g < 0 || g > 255) 
            {
                g = getIntValue("g");
            }
        while(b < 0 || b > 255) 
            {
                b = getIntValue("b");
            }
        
        int rgb = (r << 16) + (g << 8) + (b << 0);              // Berechnung von der Seite: https://www.rapidtables.com/web/color/blue-color.html
        
        for(int i = 0; i < 200; i++)
        {
            for(int j = 0; j < 200; j++)
            {
                pic.setRGB(i, j, rgb);
            }
        }

        pic.show();
    }

    static private Picture disassamblePicture(Picture referenece, int component)
    {
        Picture disassembled = new Picture(referenece.width(), referenece.height());
        
        for(int i = 0; i < referenece.width(); i++)
        {
            for(int j = 0; j < referenece.height(); j++)
            {
                int r = (referenece.getRGB(i, j) >> 16) & 0xFF;
                int g = (referenece.getRGB(i, j) >>  8) & 0xFF;
                int b = (referenece.getRGB(i, j) >>  0) & 0xFF;

                switch(component)
                {
                    case 1:
                        g = 0;
                        b = 0;
                        break;
                    case 2:
                        r = 0;
                        b = 0;
                        break;
                    case 3:
                        r = 0;
                        g = 0; 
                        break;
                }
                
                disassembled.setRGB(i, j, (r << 16) + (g << 8) + (b << 0));
            }
        }

        return disassembled;
    }


    static private void extractPicture(Picture toDisassamble)
    {
        toDisassamble.show();
        
        Picture red = disassamblePicture(toDisassamble, RED);
        Picture green = disassamblePicture(toDisassamble, GREEN);
        Picture blue = disassamblePicture(toDisassamble, BLUE);
        
        red.show();
        green.show();
        blue.show();
    }

    static private void mirrorPicture(Picture toMirror)
    {
        Picture clone = new Picture(toMirror);
        clone.show();

        int width = toMirror.width() - 1;

        for(int i = 0; i < width / 2; i++)
        {
            for(int j = 0; j < toMirror.height(); j++)
            {
                int temporary = toMirror.getRGB(i, j);
                toMirror.setRGB(i, j, toMirror.getRGB(width - i, j));
                toMirror.setRGB(width - i, j, temporary);
            }
        }

        toMirror.show();
    }

    static private void boundingBox(Picture toAddBoundingBox)
    {
        Picture validate = new Picture(toAddBoundingBox.width(), toAddBoundingBox.height());
        
        int a = 255, 
            r = 255, 
            g = 255, 
            b = 255;

        int topX = toAddBoundingBox.height(), 
            bottomX = 0, 
            leftY = toAddBoundingBox.width(), 
            rightY = 0;

        for(int i = 0; i < toAddBoundingBox.width(); i++)
        {   
            for(int j = 0; j < toAddBoundingBox.height(); j++)
            {
                validate.set(i, j, Color.white);

                if(toAddBoundingBox.getRGB(i, j) != (a << 24) + (r << 16) + (g << 8) + (b << 0))
                {
                    validate.set(i, j, Color.black);
                    
                    if(i < leftY)
                        leftY = i;

                    if(i > rightY)
                        rightY = i;

                    if(j < topX)
                        topX = j;

                    if(j > bottomX)
                        bottomX = j;
                }
            }
        }

        for(int i = leftY; i < rightY; i++)
        {
            toAddBoundingBox.set(i, topX, Color.red);
            toAddBoundingBox.set(i, bottomX, Color.red);
        }

        for(int i = topX; i < bottomX; i++)
        {
            toAddBoundingBox.set(leftY, i, Color.red);
            toAddBoundingBox.set(rightY, i, Color.red);
        }

        validate.show();
        toAddBoundingBox.show();
    }

    static private void rotatePicture(Picture toRotate)
    {
        int height = toRotate.height(), width = toRotate.width(), 
            halfHeight = (height - 1) / 2, halfWidth = (width - 1) / 2;

        double alpha = (double) getIntValue("Winkel");

        Picture target = new Picture(width, height);


        for(int i = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                
                int x = (int) (((j - halfWidth) * Math.cos(alpha) - ((i - halfHeight) * Math.sin(alpha)) + halfWidth));
                int y = (int) (((j - halfWidth) * Math.sin(alpha) + ((i - halfHeight) * Math.cos(alpha)) + halfHeight));
                
                //System.out.println(i + " " + j + "x = " + x + ", y = " + y);

                if(x < 0 || y < 0 || x >= width || y >= height)
                    target.set(i, j, Color.red);
                else 
                    target.setRGB(i, j, toRotate.getRGB(x, y));        
            }            
        }

        target.show();
    }
}
