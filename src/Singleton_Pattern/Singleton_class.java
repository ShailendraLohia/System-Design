package Singleton_Pattern;

class Singleton_class
{
	private static Singleton_class instance;
	//The private constructor disable the creation of creating its object outside this class body
	//All the its object can be declared outside but can be created by using getInstance() function
	private Singleton_class()
	{}
	static Singleton_class getInstatnce()
	{
		if(instance==null)
			instance=new Singleton_class();
		return instance;
	}
}

