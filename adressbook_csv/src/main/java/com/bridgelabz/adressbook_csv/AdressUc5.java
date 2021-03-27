package com.bridgelabz.adressbook_csv;

import java.util.List;

//import java.awt.List;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class AdressUc5 {
	 Scanner sc = new Scanner(System.in);
	static ArrayList<Book> store = new ArrayList<Book>();
	int length = store.size();
	// static Book st2;

	 static boolean exit = false;

	 void add_new() throws IOException {



		System.out.println("enter the number of person you wnna to add");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			Book b1 = new Book();
			System.out.println("enter id");
			//int id=sc.nextInt();
			b1.setId(sc.nextInt());
			System.out.println("enter the first_name");
			//String fname=sc.next();
			b1.setFsname(sc.next());
			System.out.println("enter the last name");
			b1.setLname(sc.next());
			System.out.println("enter the city");
			b1.setCity(sc.next());
			System.out.println("enter the state");
			b1.setState(sc.next());
			System.out.println("enter the zip_code");
			b1.setZip_code(sc.next());
			System.out.println("enter the phone_no");
			b1.setPhone_no(sc.next());
			System.out.println("enter the email_id");
			b1.setEmail(sc.next());
			System.out.println("adding the records " + b1.toString());


			//store.add(new Book(id,fname,null,null,null,null,null,null));
			store.add(b1);
			// b1=null;
			System.out.println(store.toString());

			// st2= store.get(i);
		}
		// System.out.println(st2);
		 Path path = Paths.get("E://qwerty.csv");
		 //writing to the file
		 try {


			 FileWriter outputfile=new FileWriter(path.toFile(),true);
			 CSVWriter writer = new CSVWriter(outputfile);

			// String[] data =store.toString().split(",");
			 store.forEach(user ->{String[] data = {String.valueOf(user.)}} );

			 writer.writeNext(data);
			 writer.close();
		 }

		 catch (IOException e) 
		 {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 ////////////////////////////////////////////////////////////////////////////

		// reading through file
		 try {
		 FileReader reader = new FileReader(Paths.get("E://qwerty.csv").toFile());
		 CSVReader csvreader = new CSVReaderBuilder(reader).build();

		List<String[]> contactData =  csvreader.readAll();

		 for(String[] row : contactData)
		    {
			 for(String cell :row) {
				 System.out.println(cell + "\t");
			 }
		 }
		 }

		 catch(IOException e)
		 {
			 e.printStackTrace();
		 }


	}
		 void update() 
		{
			System.out.println("enter the input");
			String fname_fromuser=sc.next();
			Book b_update=null;
			int indexof_store=-1;
			for(int index=0; index<=store.size();index++)
			{   
				if(store.get(index).getFsname().equals(fname_fromuser))
				{
				b_update=store.get(index);
			    indexof_store=1;
			    break;
				}
				else
				{
				System.out.println("wrong data input ");	
				break;
				}

			}

			if(indexof_store==-1)
			{
				System.out.println("name in book not found");

			}

			else
			{
				System.out.println("give the contact details u wanna to change");

				System.out.println("1 for changing lname");
				System.out.println("2 for changing city");
				System.out.println("3 for  changing state");
				System.out.println("4 for changing zip code");
				System.out.println("5 for changing number");
				System.out.println("6 for changing email");
				int change=sc.nextInt();
				 switch(change)
				 {
				 case 1 :
					 System.out.println("enter the lname");
					 b_update.setLname(sc.next());
				     break;
				 case 2:
					 System.out.println("enter the city");
					 b_update.setCity(sc.next());
					 break;

				 case 3:
					 System.out.println("enter changing state");
					 b_update.setState(sc.next());
					 break;

				 case 4:
					 System.out.println("enter zip code");
					 b_update.setZip_code(sc.next());
					 break;

				 case 5:
					 System.out.println("enter for changing number");
					 b_update.setPhone_no(sc.next());
					 break;

				 case 6:
					 System.out.println("enter email");
					 b_update.setEmail(sc.next());
					 break;
				 }

			}

		}

		 void delete()

	        {
	        	System.out.println("enter the input");
	    		String fname_fromuser=sc.next();
	    		Book b_update=null;
	    		int indexof_store=-1;
	    		for(int index=0; index<=store.size();index++)
	    		{   
	    			if(store.get(index).getFsname().equals(fname_fromuser))
	    			{
	    			b_update=store.remove(index);
	    		    indexof_store=1;
	    		    break;
	    			}
	            }
	        }

	 static void print() {

		System.out.println(store.toString());

	}

	 static void end()
   {
       	System.out.println("thank you");
			exit=true;
   }

	public static void main(String[] args) throws IOException {

		while (!exit) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. for adding contact");
			System.out.println("2.displaying");
			System.out.println("3.updating the addrss book");
			System.out.println("4.for data removal");
			System.out.println("5.For Exit");
			System.out.println("choose your option");
			int userin = sc.nextInt();
			switch (userin) {
			case 1:
				new AdressUc5().add_new();
				break;

			case 2:

				print();
				break;

			case 3:
				new AdressUc5().update();
				break;

			case 4:
				new AdressUc5().delete();
				break;

			case 5:
				end();
				break;

			}

		}
		// TODO Auto-generated method stub

	}

}

//user2List.forEach(user -> {
//  String[] strUser = {String.valueOf(user.getId()), user.getName()};
