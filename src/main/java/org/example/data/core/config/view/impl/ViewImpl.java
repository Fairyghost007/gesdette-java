package org.example.data.core.config.view.impl;


import java.util.List;
import java.util.Scanner;

import org.example.data.core.config.view.View;

public  abstract class ViewImpl<T>   implements View<T>{

    protected Scanner scanner=new Scanner(System.in);
    @Override
      public void affiche(List<T> datas) {
      for (T data : datas) {
           System.out.println(data);   
      }
    } 
    @Override
    public void affiche(T data) {
        System.out.println(data);
    }

    @Override
    public void delete() {

    }
}
