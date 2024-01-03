package model;

public class Extras extends Wash implements Comparable
{
    // Extras is stuff like wallets, vent clips, vehicle height fees and air fresheners
    private int mCategory;


    public Extras(String name, double price, int category)
    {
        super(name, price);
        setCategory(category);
    }

    public void setCategory(int category)
    {
        mCategory = category;
    }

    public int getCategory()
    {
        return mCategory;
    }

    @Override
    public int compareTo(Object o)
    {

        // Downcast o into Extras
        Extras other = (Extras) o;

        // Decide how to order (sort) Extras

        // 1) By category (int)
        int catComp =  mCategory - other.mCategory;
        if(mCategory != 0)
        {
            return catComp;
        }
        return 0;
    }
}