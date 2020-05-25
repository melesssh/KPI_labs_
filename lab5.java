package lab5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class lab5 {

	public static void main(String[] args) {
    	 File firstFile = new File("D:\\Files\\first.txt"); 
    	 File secondFIle=new File("D:\\Files\\second.txt");
   	  try {
    	  
    	  BufferedReader br = new BufferedReader(new FileReader(firstFile)); 
    	  
    	  List<String> strs=new ArrayList();
    	  String st;
			while ((st = br.readLine()) != null) {
				strs.add(st);
			  }
			strs.sort((str1,str2)->str1.length()-str2.length());
	        OutputStream os = new FileOutputStream(secondFIle);
			strs.forEach(str->{
				try {
					os.write(str.getBytes(), 0, str.length());
					os.write("\n".getBytes(), 0, "\n".length());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
