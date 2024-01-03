package model;


public class Wash implements Comparable
{
    private String mName;
    private double mPrice;


    public Wash(String name, double price)
    {
        setName(name);
        setPrice(price);
    }

    public String getName()
    {
        return mName;
    }

    public void setName(String name)
    {
        mName = name;
    }

    public double getPrice()
    {
        return mPrice;
    }

    public void setPrice(double price)
    {
        mPrice = price;
    }

  /*
	public int getNumWashes()
	{
		int count = 0;
    if(order > 0 && order < 4)
    {
      count++;
    }
    else
    {
      throw new BadOrderException();
    }
	}
  */

    /*
    @Override
    public String toString()
    {
        String washString = "This wash is a " + name;
        if(extras > 0)
        {
            washString = "with an added ";
        }
        return "[" + washString + "]";
    }
    */

    @Override
    public int compareTo(Object o)
    {

        // Downcast o into Wash
        Wash other = (Wash) o;

        // Decide how to order (sort) Washes
        // 1) By name (String)
        // Compare the names of the two Washes
        int nameComp = mName.compareTo(other.mName);
        if(nameComp != 0)
        {
            return nameComp;
        }

        // 2) By price (double)
        double priceComp =  mPrice - other.mPrice;
        if(mPrice != 0)
        {
            return (int) priceComp;
        }
        return 0;
    }
}
