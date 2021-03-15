package pizza.dao;

import java.util.List;

import pizza.pojo.Pizza;

public interface PizzaDao
{
    public boolean addPizza(Pizza pizza);
    public boolean updatePizza(Pizza pizza);
    public boolean deletePizza(int id); 
    public Pizza getPizza(int id);
    public List<Pizza> getAllPizza();
}
