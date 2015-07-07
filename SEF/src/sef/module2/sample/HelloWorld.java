package sef.module2.sample;

import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HelloWorld {
	
	public static void main(String arg[]){	
		
		
//---------------------TASK 1-------------	
		//greeting from console with the 2.argument
		
		/*String s = arg[1];				
		
		System.out.println("Hello World!" + s);*/
		
//--------------------TASK 2-------------------
		
		//sum of 1^2 + 2^2 + 3^2 ..... h^2, if h is given as an input parameter
		
		/*try{
			
			int number = Integer.valueOf(arg[0]);
			int result = 0;
			
			for (int n = 1; n <= number; n++){
				result = result + n*n; 
			}
			
			System.out.println(result);
			
		}catch (NumberFormatException ex){
			System.out.println("Input error!");
		}*/
		
//---------------TASK 3------------------
		//run classes from CMD
		
//------------------TASK 4----------------------
		
		// guess a number, that was given from random 1-100.
		
		/*int bound = 100;
		Random generator = new Random(); 
		
		int secretNumber = generator.nextInt(100);	
		Scanner sc = new Scanner(System.in);
		int input = 0;
		
		//System.out.print("Insert number: ");
		do{			
			try{				
				input = sc.nextInt();
				
				if(input == secretNumber){
						System.out.print("You guessed!");
						break;
				} else if(input < (secretNumber)){
						System.out.println("Greater!");
				} else {
						System.out.println("Less!");
				}
			}catch (NumberFormatException ex){
				System.out.print("Input error!");
			}				
		} while (input != secretNumber);*/
		
//------------------TASK 5 (ADVANCED)-------------------------
		
		//encrypt string by the key
		
		/*Random generator = new Random();		
		int key = generator.nextInt(5) + 1;
		String result = "";
		String decoded = "";
		
		System.out.println("Insert line");
		
		Scanner sc = new Scanner(System.in);
		String inputString = sc.nextLine();
		
		for (int l = 0; l<inputString.length(); l++){
			int code = (int) inputString.charAt(l) + key;
			
			result = result + (char) code;
		}
		
		System.out.println("Encoded string: " + result);
		
		System.out.println("\nGuess a key: ");
		int tryKey = 0;

		do {			
			try{				
				tryKey = sc.nextInt();
				
				for (int l = 0; l<result.length(); l++){
					int code = (int) result.charAt(l) - tryKey;
					
					decoded = decoded + (char) code;
				}
				
				System.out.println("Decoded string: " + decoded);
				decoded = "";
				
			}catch (NumberFormatException ex){
				System.out.print("Input error!");
			}				
		}while (tryKey != key);		*/
		
		
		
		
		//------------advanced-------------
				String encoded = "";
				String decoded = "";
				
				//String path = "C:/Users/Anna/workspace";
				String path = "C:/Users/Student/workspace";
		        File directory = new File(path);
		        File file = new File(directory, "Hello.txt" );	
				String inputString = readFile(file);
				int key = 0;							
				
				try{				
					key = Integer.valueOf(arg[0]);						
					for (int l = 0; l<inputString.length(); l++){
							int code = (int)inputString.charAt(l) + key;			
							encoded = encoded + (char)code;
						}
					
					for (int l = 0; l<encoded.length(); l++){
							int code = (int)encoded.charAt(l) - key;					
							decoded = decoded + (char)code;
						}
					
					System.out.println("Input string: " + inputString);
						writeFile(file, "\nEncoded: " + encoded);
						System.out.println("Encoded string: " + encoded);
						writeFile(file, "\nDecoded: " + decoded);
						System.out.println("Decoded string: " + decoded);
										
					}catch (NumberFormatException ex){
						System.out.print("Input error!");
					}
								        
		    }
			
			public static String readFile(File file){
		        if(!file.exists()){
		            return null;
		        }
		        BufferedReader reader = null;

		        try{
		            //Открытие потока
		            FileReader fileReader = new FileReader(file);
		            reader = new BufferedReader(fileReader);

		            //Создаём буфер для данных
		            StringBuilder builder = new StringBuilder();
		            String result;

		            //Чтение файла в цикле
		            while((result = reader.readLine())!=null){
		                builder.append(result).append("\n");
		            }
		            return builder.toString();
		        } catch (FileNotFoundException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {
		             close(reader);
		        }
		        return null;

		    }

		    public static void close(Closeable closeable){
		        if(closeable != null){
		            try {
		                closeable.close();
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
		        }
		    }

		    public static void writeFile(File file, String text){
		        BufferedWriter writer = null;
		        try {
		            writer = new BufferedWriter(new FileWriter(file, true)); 
		            writer.write(text);
		        } catch (IOException e){
		            e.printStackTrace();
		        }   finally {
		            close(writer);
		        }
		
		
		
    }
}
