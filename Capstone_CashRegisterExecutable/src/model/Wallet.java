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

public class Wallet extends Extras implements Comparable, Serializable
{

    private String mFabric;

    public Wallet(String name, double price, String fabric, int category)
    {
        super(name, price, category);
    }

    public void setFabric(String fabric)
    {
        mFabric = fabric;
    }

    public String getFabric()
    {
        return mFabric;
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
        if (!(other instanceof Wallet))
        {
            return false;
        }

        // Downcast to Wallet
        Wallet otherWallet = (Wallet) other;

        return super.equals(otherWallet) &&  mFabric.equals(otherWallet.mFabric);


    }

    @Override
    public int compareTo(Object o)
    {

        // Downcast o into Wallet
        Wallet other = (Wallet) o;

        // Decide how to order (sort) Wallets
        // 1) By fabric (String)
        // Compare the fabrics of the two Wallets
        int fabriComp = mFabric.compareTo(other.mFabric);
        if(fabriComp != 0)
        {
            return fabriComp;
        }
        return 0;
    }

    /*
    @Override
    public String toString()
    {
        return "This is a " + fabric + " wallet which costs $" + cost + ".";
    }
    */
}