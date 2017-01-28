package pos;

public class Pizza
{
  private double cost; //cost of pizza
  private String crust; //type of crust
  private int size; //size - inches
  private int numToppings; //number of toppings
  private String toppingList; //list of toppings

//Constructor
  public Pizza()
  {
    cost = 0;
    crust = "Pan-Crust";
    size = 9;
    numToppings = 0;
    toppingList = null;
  }
  
//adds the parameter amount to the cost
  public void setCost (double amount)
  {
    this.cost += cost;
  }

//sets the crust type
  public void setCrust (String crust)
  {
    this.crust = crust;
  }

//changes the size of the pizza to the parameter diameter
  public void setSize (int size)
  {
    this.size = size;
  }

//sets the number of toppings to the parameter number
  public void setNumToppings(int numToppings)
  {
    this.numToppings = numToppings;
  }

//sets the list of toppings
  public void setToppingList (String toppingList)
  {
    this.toppingList = toppingList;
  }

//returns the cost of the pizza
  public double getCost()
  {
    return cost;
  }

//returns the crust type
  public String getCrust()
  {
    return crust;
  }

//returns the size of the pizza
  public int getSize()
  {
    return size;
  }

//returns the number of toppings
  public int getNumToppings()
  {
    return numToppings;
  }

//returns the list of toppings
  public String getToppingList()
  {
    return toppingList;
  }
}