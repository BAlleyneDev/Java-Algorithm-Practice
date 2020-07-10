package com.balleyne.designpatterns.singleton;

public class SingletonThreadSafe {
     private static SingletonThreadSafe singletonInstane = new SingletonThreadSafe();
     
     private SingletonThreadSafe() {}
     
     public static SingletonThreadSafe getInstance() {
    	 return singletonInstane;
     }
}
