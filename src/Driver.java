import java.lang.reflect.*;
import java.util.*;
import java.io.*;

public class Driver {
    
	public static void main(String[]args) throws Throwable {
    	
        File[] plugins = new File("C:/Users/Bharat's PC/OneDrive/CISC 3150 OOP/Homeworks/Homework 10/plugin").listFiles();
        
        System.out.println("Files available to choose from: \n");
        
        for(File plugin: plugins)
        	if(plugin.isFile())
        		System.out.println(plugin.getName());
       
        Scanner cin = new Scanner(System.in);
        
        System.out.println("\nEnter '1' to execute Plugin 1 or '2' to execute Plugin 2:" );
        int choice = cin.nextInt();
        System.out.println("\nYou chose Plugin" + " " + choice + "\n");
        String pluginName = "Plugin" + choice;

        Class<?> myClass = Class.forName(pluginName);
        Object myInstance = myClass.newInstance();
        
        Method myMethod1 = myClass.getMethod("whoSaysHello");
        Method myMethod2 = myClass.getMethod("whoSaysBye");

        myMethod1.invoke(myInstance);
        myMethod2.invoke(myInstance);
    }
}