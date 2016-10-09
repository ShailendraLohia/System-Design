package Parking_LOT;

public abstract class ParkingSpaceSign 
{
String parkingSpaceLine[]=new String[2];
}
//Normal parking lot sign
class Normal_ParkingSpaceSign extends ParkingSpaceSign
{
	boolean sign;
	Normal_ParkingSpaceSign()
	{
		sign=true;
	}
}
//handicap parking lot sign
class Handicap_ParkingSpaceSign extends ParkingSpaceSign
{
	boolean sign;
	Handicap_ParkingSpaceSign()
	{
		sign=true;
	}
}
//Compact parking lot sign
class Compact_ParkingSpaceSign extends ParkingSpaceSign
{
	boolean sign;
	Compact_ParkingSpaceSign()
	{
		sign=true;
	}
}
