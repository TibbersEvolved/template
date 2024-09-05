package com.Erik.demo;

import java.util.ArrayList;
import java.util.List;
//This class handles the local storage and handling off stuff

public class AdressHandler {
    private List<AdressInfo> listAdress;
    public AdressHandler()
    {
        listAdress = new ArrayList<>();
    }
    public void createAdress(long nid,String name, String area)
    {
        AdressInfo temp = new AdressInfo(name,nid,area);
        listAdress.add(temp);
    }

    public List<AdressInfo> getListAdress()
    {
        return this.listAdress;
    }

    public void sortListByName(String name)
    {
        System.out.println("Searching for name");
        AdressInfo moveToTop = null;
        for(int i = 0; i < listAdress.size();i++)
        {
            AdressInfo check = listAdress.get(i);
            String nameCheck = check.getName();
            System.out.println("Checking this name: " + name +" against " + nameCheck);
            if (nameCheck.matches(name)) {
                System.out.println("Found a match");
                moveToTop = check;
            }

        }
        if(moveToTop != null)
        {
            System.out.println("Playing around with list");
            listAdress.remove(moveToTop);
            listAdress.addFirst(moveToTop);

        }
    }

}
