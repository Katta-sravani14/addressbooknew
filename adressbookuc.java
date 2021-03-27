package com.katta;

 
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class AdressUc5 {
	 Scanner sc = new Scanner(System.in);
	static ArrayList<Book> store = new ArrayList<Book>();
	int length = store.size();
	// static Book st2;

	 static boolean exit = false;

	 void add_new() {

		System.out.println("enter the number of person you wnna to add");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			Book b1 = new Book();
			System.out.println("enter id");

			b1.setId(sc.nextInt());
			System.out.println("enter the first_name");

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
		/**	if(i>0) {
			if(store.get(i).setFsname().equals(b1.Fsname))
			{
				
				System.out.println("data already present , try to add another data");
				continue;
			}
			else 
			{
			store.add(b1);
			
			}
			}
			else {
				System.out.println("no value!!");
			}
			System.out.println(store);
**/
			// st2= store.get(i);
			store.add(b1);
			System.out.println(store);
		}
		// System.out.println(st2);

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

		//System.out.println(store.toString());
		store.stream().forEach(System.out::println);

	}

	 static void end()
     {
         	System.out.println("thank you");
			exit=true;
     }

	  void survey()
	  {
		  boolean b1=false;

		  while(!b1) {
		  System.out.println("chose your suvey accordingly");
		  System.out.println("[1]  for checking through city");
		  System.out.println("[2]  for checking through state");
		  System.out.println("[3]  for checking through number");
          System.out.println("[4]  for checking through zipcode");
          System.out.println("[5]  for exit");
		  int choose2=sc.nextInt();

		  switch(choose2) 
		  {
		  case 1:
			  System.out.println("enter the value you want to check");
			  String checkout=sc.next();
			  //for finding only name
			  store.stream().filter(element -> element.getCity().equals(checkout))
			                        .forEach(element -> System.out.println(element.getFsname()));

			List<Book> view= store.stream().filter(element -> element.getCity().equals(checkout)).collect(Collectors.toList());
			System.out.println(view);
			  break;

		  case 2:
			  System.out.println("enter the value you want to check");
			  String checkout1=sc.next();
			  //for finding only name
			   /**store.stream().filter(element -> element.getCity().equals(checkout1))
			                        .forEach(element -> System.out.println(element.getFsname()));**/
			  long count1=store.stream().filter(element -> element.getState().equals(checkout1)).count();
			  System.out.println(count1);
			  long count=store.stream().filter(element -> element.getState().equals(checkout1)).count();
			  System.out.println(count);

			   List<Book> view1= store.stream().filter(element -> element.getCity().
					              equals(checkout1)).collect(Collectors.toList());
			    System.out.println(view1);
			  break;

		  case 3:
			  System.out.println("enter the value you want to check");
			  String checkout2=sc.next();
			  //for finding only name
			   /**store.stream().filter(element -> element.getCity().equals(checkout))
			                        .forEach(element -> System.out.println(element.getFsname()));**/
			  long count2=store.stream().filter(element -> element.getPhone_no().equals(checkout2)).count();
			  System.out.println(count2);

			   List<Book> view2= store.stream().filter(element -> element.getPhone_no().
					             equals(checkout2)).collect(Collectors.toList());
			    System.out.println(view2);
			  break;
		  case 4:
			  System.out.println("enter the value you want to check");

		      String checkout3=sc.next();
		      //for finding only name
		       /**store.stream().filter(element -> element.getCity().equals(checkout))
		                        .forEach(element -> System.out.println(element.getFsname()));**/
		       long count3=store.stream().filter(element -> element.getZip_code().equals(checkout3)).count();
			   System.out.println(count3);
		       List<Book> view3= store.stream().filter(element -> element.getZip_code().
		    		            equals(checkout3)).collect(Collectors.toList());
		       System.out.println(view3);

			  break;

		  case 5:
			  System.out.println("thank you");
				b1=true;


		  }
		  }



	  }





	public static void main(String[] args) {

		while (!exit) {
			Scanner sc = new Scanner(System.in);
			System.out.println("1. for adding contact");
			System.out.println("2.displaying");
			System.out.println("3.updating the addrss book");
			System.out.println("4.for data removal");
			System.out.println("5.for doing survey of address book");
			System.out.println("7.For Exit");
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
				new AdressUc5().survey();
				break;

			case 6:
				end();
				break;

			}

		}
		// TODO Auto-generated method stub

	}


	public void sorting() {
		// TODO Auto-generated method stub
		
	}

}