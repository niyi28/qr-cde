package com.company;
import java.io.*;
import java.util.Scanner;

public class Encryption {
    public static void main(String[] args)
            throws FileNotFoundException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Note : Encryption Key act as Password to Decrypt the same Image,otherwise it will corrupt the Image.");

        // Here key is act as password to Encrypt and
        // Decrypt the Image
        System.out.print("Enter key for Encryption : ");
        String key = sc.next();

        // Selecting a Image for operation
        String path = "Shiva.jpg";
        try (FileInputStream fis = new FileInputStream(path)) {

            // Converting Image into byte array, create a
            // array of same size as Image size

            byte data[] = new byte[fis.available()];

            // Read the array
            fis.read(data);
            int i = 0;

            // Performing an XOR operation on each value of
            // byte array due to which every value of Image
            // will change.
            for (byte b : data) {
                data[i] = (byte) (b ^ key.length());
                i++;
            }

            // Opening a file for writing purpose
            FileOutputStream fos = new FileOutputStream("shiva.jpg");

            // Writing new byte array value to image which
            // will Encrypt it.

            fos.write(data);
            fos.close();

            System.out.println("Encryption Done... Shiva");
        }
    }
}


