package Parking_LOT;

class ParkingSpace 
{
	ParkingSpaceSign sign;
	boolean available;
	int floor;
	int parkingLot_number;
	ParkingSpace(int parkingLot_number,ParkingSpaceSign Parkingsign)
	{
		this.parkingLot_number=parkingLot_number;
		floor=parkingLot_number/20;
		if(parkingLot_number%20!=0)
			floor++;
		sign=Parkingsign;
		available=true;
	}
	ParkingSpaceSign getSign()
	{
		return sign;
	}
	boolean isEmpty()
	{
		return available;
	}
	void setStatus(boolean status)
	{
		available=status;
	}
}
