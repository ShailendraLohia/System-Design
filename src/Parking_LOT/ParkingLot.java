package Parking_LOT;

class ParkingLot
{
	ParkingSpace[] spaces;
	ParkingLot(int n)
	{
		spaces=new ParkingSpace[n];
		ParkingSpaceSign type=new Handicap_ParkingSpaceSign();
		for(int i=0;i<n;i++)
			{
			if(i==10)
				type=new Compact_ParkingSpaceSign();
			if(i==30)
				type=new Normal_ParkingSpaceSign();
			spaces[i]=new ParkingSpace(i,type);
			}
	}
	ParkingSpace getParkingSpace(String typeOf)
	{
		ParkingSpaceSign sign=null;
		switch (typeOf.toLowerCase())
		{
		case "compact":
			sign=new Compact_ParkingSpaceSign();
			break;
		case "normal":
			sign=new Normal_ParkingSpaceSign();
			break;
		case "handicap":
			sign=new Handicap_ParkingSpaceSign();
			break;
			default:
				System.out.println("Invalid Option");
				return null;
		}
		for(ParkingSpace space : spaces)
		{
			if(space.getSign().getClass().equals(sign.getClass())&&space.isEmpty())
				return space;				
		}
		return null;
	}

	static  class Entrance 
	{
		static boolean gate;
		static boolean isClosed()
		{
			if(gate)
				return true;
			return false;
		}
		static void open()
		{
			gate=true;
		}
		static void close()
		{
			gate=false;
		}
	}


}

