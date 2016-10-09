package Parking_LOT;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
public class Ticket 
{
	Date date;
	long time;
	String Ticket_Number;
	String generateTicket(ParkingSpace space)throws IOException
	{
		date=new Date();
		time=date.getTime();
		Timestamp ts = new Timestamp(time);
		String[] dateTime=ts.toString().split(" ");
		StringBuilder TicketNumber=new StringBuilder();
		System.out.println("Enter ur name initials\n");
		TicketNumber.append(dateTime[1]);
		File file=new File("Ticket");
		BufferedWriter output=new BufferedWriter(new FileWriter(file));
		try
		{
			output.write("Ticket Number : "+TicketNumber.toString()+"\n");
			output.write("Parking Date : "+dateTime[0]+"\n");
			output.write("Parking Time : "+dateTime[1]+"\n");
			output.write("Parking lot number : "+space.parkingLot_number+"\n");
			output.write("Parking Floor : "+space.floor+"\n");
		}
		catch(IOException e )
		{};
		output.close();
		System.out.println("Please collect your ticket");
		Ticket_Number=TicketNumber.toString();
		return Ticket_Number;
	}
	int generateAmount(Ticket ticket)
	{
		Date current_date=new Date();
		long current_time=current_date.getTime();
		long diff=current_time-time;
		long minutes = TimeUnit.MILLISECONDS.toMinutes(diff); 
		int hour=(int)minutes/60;
		if((int)minutes%60!=0)
			hour++;
		int amount=3*hour;
			return amount;
	}
}
