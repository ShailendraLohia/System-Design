package Parking_LOT;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

class Parker 
{
	public static void main(String args[]) throws IOException
	{
		char c ='y';
		Scanner scan = new Scanner(System.in);
		ParkingLot options=new ParkingLot(100);	
		HashMap<String,Ticket> tickets=new HashMap<String,Ticket>();
		Parker parker=new Parker();
		Ticket ticket=new Ticket();
		while(c=='y'||c=='Y')
		{
			System.out.println("Do you want to park or unpark any other vehicle (y/n)");
			if(scan.hasNext())
			  c =scan.next().charAt(0);
			if(c=='n'||c=='N')
				break;
			System.out.println("DO you want to \n 1.Park \n 2.Unpark \n Enter in Number");
			int option=scan.nextInt();
			if(option==1)
			{
				ParkingSpace book=parker.park(options);
				if(book!=null)
				{
					String s=ticket.generateTicket(book);
					tickets.put(s,ticket);
				}
			}
			else if(option==2)
			{
				System.out.println("Enter the Ticket....");
				BufferedReader input=new BufferedReader(new FileReader("OOPs Designs/Ticket"));
				String TicketNumber=input.readLine().split(" : ")[1];
				int amount=ticket.generateAmount(tickets.get(TicketNumber));
				System.out.println("You need to pay "+amount+"$");
				int lot=-1;
				while(input.readLine()!=null)
					{
					String s=input.readLine();
					if(s.startsWith("Parking lot number"))
						{
						String words[]=s.trim().split(" ");
						lot=Integer.parseInt(words[words.length-1]);
						}
					}
				parker.Unpark(options,lot);
			}
			else
				System.out.println("Invalid Input");
		}
		scan.close();
	}
	private  ParkingSpace park(ParkingLot options)
	{
		boolean gateStatus=ParkingLot.Entrance.isClosed();
		if(gateStatus==false)
			ParkingLot.Entrance.open();
		System.out.println("There are three kind of parking - \n 1.compact \n 2.normal \n 3.handicap");		
		System.out.println("Enter the kind of parking");
		Scanner scan = new Scanner(System.in);
		String typeOf=scan.nextLine();		
		ParkingSpace Space=options.getParkingSpace(typeOf);
		if(Space==null)
		{
			System.out.println("There is no parking space availble in this category");
			scan.close();
			return null;
		}
		System.out.println("This is nearest parking space availble in this category :");
		System.out.println("FLoor"+Space.floor);
		System.out.println("Parking Number"+Space.parkingLot_number);
		System.out.println("Do you want park? (y/n)");
		char c=scan.next().charAt(0);
		scan.close();
		if(c=='y'||c=='Y')
		{
			Space.available=false;
			return Space;
		}
		return null;

	}
	private void Unpark(ParkingLot options,int lotNumber)
	{ 
		boolean gateStatus=ParkingLot.Entrance.isClosed();
		if(gateStatus==false)
			ParkingLot.Entrance.open();
		options.spaces[lotNumber].available=true;
	}
}
