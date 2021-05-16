/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeson;

/**
 *
 * @author kerem alp
 */
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kerem alp
 */
public class Member{
private int b;
private ArrayList<ArrayList> a;
    public Member(ArrayList<ArrayList> a, int b) {
        this.b=b;
       this.a=a;
    }
    
    @Override
    public String toString(){
        
        return getA()+String.valueOf(getB()) ;
    }

 
public void printArr(){
    System.out.println(getA());
       
}
    /**
     * @return the b
     */
    public int getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(int b) {
        this.b = b;
    }

    /**
     * @return the a
     */
    public ArrayList getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(ArrayList a) {
        this.a = a;
    }
    
    
}
