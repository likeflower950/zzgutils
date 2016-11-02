package com.zzgproject.test;


public class HashCodeTest {
	
	private int weight;
    private String color;

    public HashCodeTest(int weight, String color) {
        this.color = color;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

 

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    @Override
    public int hashCode() {
    	return this.getWeight() + this.getColor().hashCode();
    }
    
    @Override
    public boolean equals(Object arg0) {
    	return this.hashCode()==arg0.hashCode();
    }
    
    @Override
    public String toString() {
    	return this.getWeight()+":"+this.getColor();
    }

	public static void main(String[] args) throws Exception{
		HashCodeTest f1 = new HashCodeTest(1, "blue");
		HashCodeTest f2 = new HashCodeTest(1, "blue");

        System.out.println(f1 == f2);
        System.out.println(f1.equals(f2));
		
        System.out.println(f1);
        System.out.println(f2);
        
        System.out.println(f1.hashCode());
        System.out.println(f2.hashCode());
        
        System.out.println("1=========");
        
        String str1 = "abc";
        String str2 = "a"+"b"+"c";
        
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        
        System.out.println("2=========");
        
        for(int i=0; i<=1000;i++){
        	str1 += "abc";
        	str2 += "a";
        	str2 += "b";
        	str2 += "c";
        }
        
        System.out.println(str1);
        System.out.println(str2);
        
        System.out.println(str1==str2);
        System.out.println(str1.equals(str2));
        
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        
        System.out.println("3=========");
        
        String s3 = new String("123");
        String s4 = new String("123");
        
        System.out.println(s3==s4);
        System.out.println(s3.equals(s4));
    
	}
	
	
}

