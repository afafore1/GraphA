package com.algorithms.algorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Ayomitunde on 2/27/2017.
 */
class CarPart
{
    private String warehouseAddress;
    private List<CarPart> subCarparts = new LinkedList<>();
// If we had a model, I think the best thing to do is store relationship as a key value pair.
// i.e. HashMap<CarPart, List<CarPart>> relationship ...


    public String getWarehouseAddress()
    {
        return warehouseAddress;
    }

    public void setWarehouseAddress(String warehouseAddress)
    {
        this.warehouseAddress = warehouseAddress;
    }

    public void move(String newAddress)
    {
        Stack<CarPart> allCarparts = new Stack<>();
        allCarparts.push(this);
        List<CarPart> visitedCarparts = new LinkedList<>();
        while(!allCarparts.isEmpty())
        {
            CarPart currentCarpart = allCarparts.pop(); // get top Carpart
            if(visitedCarparts.contains(currentCarpart)) continue;
            currentCarpart.setWarehouseAddress(newAddress);
            visitedCarparts.add(currentCarpart);
            List<CarPart> carParts = currentCarpart.getSubCarparts();
            for(CarPart c : carParts)
            {
                allCarparts.push(c);
            }
        }
    }

    // we simply add all other parts that make up this carpart.
// If this was an engine, it's list will include cylinders, valvs, spark plugs, etc..
    public void addSubCarpart(CarPart carpart)
    {
        subCarparts.add(carpart);
    }

    public List<CarPart> getSubCarparts()
    {
        return this.subCarparts;
    }

    public static void main(String [] args)
    {
        CarPart a = new CarPart();
        CarPart b = new CarPart();
        CarPart c = new CarPart();
        CarPart d = new CarPart();
        CarPart e = new CarPart();
        CarPart f = new CarPart();
        CarPart g = new CarPart();
        a.addSubCarpart(b);
        a.addSubCarpart(c);
        c.addSubCarpart(d);
        d.addSubCarpart(f);
        f.addSubCarpart(a);
        f.addSubCarpart(c);
        f.addSubCarpart(g);

        List<CarPart> allCarparts = new LinkedList<>();
        allCarparts.add(a);
        allCarparts.add(b);
        allCarparts.add(c);
        allCarparts.add(d);
        allCarparts.add(e);
        allCarparts.add(f);
        allCarparts.add(g);


        a.move("someaddress");

        for(CarPart car : allCarparts)
        {
            System.out.println(car.getWarehouseAddress());
        }

    }
}