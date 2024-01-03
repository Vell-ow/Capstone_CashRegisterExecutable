package model;

import java.io.Serializable;

/********************************************
 *	AUTHOR:	Andrew Coviello
 * COLLABORATORS: CS112 Students and Michael Paulding
 *	COURSE:	CS 112
 *	SECTION:	multiple
 *	PROJECT(PART): IC #01 - GameCharacter
 *	LAST MODIFIED:	9/6/2020
 ********************************************/

public class AirFreshener extends Extras implements Comparable, Serializable
{

    private String mScent;
    private int mType;

    // when descending an inheritance tree, how does one correctly call super()?
    public AirFreshener(String name, double price, String scent, int type, int category)
    {
        super(name, price, category);
    }

    public void setName(String name)
    {
       super.setName(name);
    }

    public void setPrice(double price)
    {
        super.setPrice(price);
    }
    public void setScent(String scent)
    {
        mScent = scent;
    }

    public void setType(int type)
    {
        mType = type;
    }


    public String getScent()
    {
        return mScent;
    }

    public int getType()
    {
        return mType;
    }

    @Override
    public boolean equals(Object other)
    {
        //
        if(this == other)
        {
            return true;
        }

        // Check data type
        if (!(other instanceof AirFreshener))
        {
            return false;
        }

        // Downcast to Wallet
        AirFreshener otherAirFreshener = (AirFreshener) other;

        return super.equals(otherAirFreshener) &&  mScent.equals(otherAirFreshener.mScent) && mType == otherAirFreshener.mType;


    }

    @Override
    public String toString()
    {
        // TODO: create several if statements dependent on what integer type is. 1 = free packets $0.00, 2 = trees $1.79, 3 = wafers $3.99, 4 = vent clips $4.99
        return "This is a " + mScent + "-scented air freshener.";
    }
}