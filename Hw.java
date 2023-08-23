package demo.src.main.java.Ex1_6513177;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

// Name, Id: Ananda Kongkoed, 6513177 
// Name, Id: ntn, 6513???

class Hw {
    public static void main(String[] args) {

        String localDir = System.getProperty("user.dir");

        String path = localDir + "/demo/src/main/Java/Ex1_6513177/";
        String infile = path + "milks.txt";
        String outfile = path + "outmilks.txt";

        try 
        {
            Scanner scan  = new Scanner(new File(infile));
            Scanner sc = new Scanner(System.in);
            PrintWriter write = new PrintWriter(new File(outfile));

            System.out.println("Enter bottle size in ml = ");
            
            int converter = 236;
            double size_oz = sc.nextDouble() / converter;

            System.out.println("Read milk calories from " + infile);
            System.out.println("Write output to " + outfile);

            write.print("Milk               Calories/cup(8oz)     Calories/bottle(2000 ml)\r\n");
            write.print("=================================================================\r\n");

            while (scan.hasNext()) 
            {
                String type = scan.next();
                int cal = scan.nextInt();
                double cal_con = cal * size_oz;
                
                if (type.length() != 9) {
                    type += " ".repeat(9 - type.length());
                }

                write.printf("%s", type);
                write.printf("%20d", cal);
                write.printf("%26.2f\t\n", cal_con);
            }

            scan.close();
            write.close();
            }
            catch(Exception e) {
                System.err.println("An error occurs. End program.");
                System.err.println(e);	  
            }
    }
}