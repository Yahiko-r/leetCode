package test;

import java.util.HashMap;

public class HashCodeTest {
    public static void main(String[] args) {
        People p1=new People("yahiko",20);
        People p2=new People("yahiko",20);
        System.out.println(p1.equals(p2));
        HashMap<People,Integer> hm=new HashMap<>();
        hm.put(p1,1);
        System.out.println(hm.get(new People("yahiko",20)));
    }
}

class People {
    private String name;
    private int age;

    People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((People)obj).name)&&this.age==((People)obj).age;
    }
}
