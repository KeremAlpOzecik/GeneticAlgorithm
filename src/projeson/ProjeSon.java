/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author kerem alp
 */
public class ProjeSon {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int generationOrt=0; 
        
        for (int k = 0; k < 5; k++) {
            
        
long startTime = System.currentTimeMillis();  //Başlangıç zamanı
ArrayList<ArrayList> Population=new ArrayList<>(); //Kromozomları tutan nesil listesi
ArrayList<ArrayList> nextGeneration=new ArrayList<>(); // başarılı kromozomları tutan liste
List<ArrayList> member1=new ArrayList<>(); // cross over işlemi için
List<ArrayList> member2=new ArrayList<>(); // cross over işlemi için
ArrayList<ArrayList> chromosome1=new ArrayList<>(); //cross over işlemi için
ArrayList<ArrayList> chromosome2=new ArrayList<>(); //cross over işlemi için
ArrayList<String> ResultMember=new ArrayList<>();// cross over ve mutasyon işlemleri sonucunda oluşan kromozom
ArrayList<Integer> FitnesArr = new ArrayList<>();// her kromozomun fitnessıını tutmak için liste
ArrayList<String> chromosome=new ArrayList<>(); //Kromozom
ArrayList<String> bulunanKelime=new ArrayList<>();//bılunan kelime için liste
ArrayList<Member> MemArr = new ArrayList<>(); //Member türündeki class elemanlarını tutan liste fitness değerine göre sıralamak için
String Target="YapayZekaYöntemleri";
int population_Number=100; // 1 nesildeki kromozom sayısı
String Gene_pool="abcçdefgğhıijklmnoöpqrsştuüvwxyzABCÇDEFGĞHİIJKLMNOÖPQRŞSTUÜVWXYZ";//gen havuzu
int Target_Text_Lenght= Target.length();
boolean found=false;
int Generation_timer=0;   
Random rand = new Random();
int Fitness=0;


for (int j = 0; j < population_Number; j++) {//Rastgele seçien harflerle kromozomlar oluşturuluyor 
            chromosome=new ArrayList<>();
            for (int i = 0; i < Target_Text_Lenght; i++) { 
            chromosome.add(String.valueOf(Gene_pool.charAt(rand.nextInt(Gene_pool.length()))));
            }
            Population.add(chromosome);  
        } 

        while (!found) {//Fitness sayısı hedef kelime uzunluğuna eşit olduğunda bitecek
FitnesArr = new ArrayList<>(); //silinebilir
MemArr=new ArrayList<>(); //Population bu artık
            
            
            
         for (ArrayList chromosom : Population) {//popülsyonun içinde tek tek gezrek kromozomların fitness değeri hesaplanıyor
            
            Fitness=0;
            
             
            for (int i = 0; i < Target_Text_Lenght; i++) {
               
                if (chromosom.get(i).toString().charAt(0)== Target.charAt(i)) {
                    Fitness++;

                    
                }
          
            }
       
            if(Fitness==Target_Text_Lenght){
                bulunanKelime=chromosom;
                
             
            found=true;
                
            }  
           
            MemArr.add(new Member(chromosom, Fitness));//Yeni Populasyon MemArr.getA();
            FitnesArr.add(Fitness);
     
        }
        Collections.sort(MemArr, Comparator.comparing(Member::getB));//fitness a göre sıraladı
        Population=new ArrayList<>();
            for (Member member : MemArr) {
               Population.add(member.getA());
             
            }
        
        int last_best = ( 90 * population_Number) / 100; //en iyi %10 yeni nesile aktarıldı last best yüzde oranını veriyor
        nextGeneration=new ArrayList<>();
        nextGeneration.addAll(Population.subList(last_best, Population.size()));
    //listenin son elemanı fitness değeri en yüksek eleman
            System.out.println("En yüksek fitness değerine sahip kromozom --> "+nextGeneration.get(nextGeneration.size()-1));
        while(true){ //Crossover işlemi burada yapılıyor
            if (nextGeneration.size()<population_Number) { 
            member1= Population.subList(last_best, Population.size());
            chromosome1=new ArrayList<>();
            chromosome2=new ArrayList<>();
            chromosome1.add(member1.get(rand.nextInt(population_Number-last_best)));
            chromosome2.add(member1.get(rand.nextInt(population_Number-last_best)));
             ResultMember=new ArrayList<>();
                
            
                for (int i = 0; i < chromosome1.get(0).size(); i++) {//çaprazlama işlemi
                    double prob = Math.random();
                    if(prob < 0.47){
                        for (ArrayList arrayList : chromosome1) {
                            ResultMember.add(arrayList.get(i).toString());
                        }
                     
                    }
                    else if(prob >0.47 && prob < 0.94){
                             for (ArrayList arrayList : chromosome2) {
                            ResultMember.add(arrayList.get(i).toString());
                            
                        }
                    }
                    else{//Mutasyon işlemi
                        char a=Gene_pool.charAt(rand.nextInt(Gene_pool.length()));
                        String b= String.valueOf(a);
                    
                       ResultMember.add(b);
                    }
                    
                }

                nextGeneration.add(ResultMember);//Yeni jenerasyona Crossover ve Mutasyona uğramoş kromozom ekleniyor
               
                
               
            }
            else break;
            
        }
        Generation_timer++;
       
        Population=nextGeneration;
        
         
            
            
        }





System.out.println("Bulunan Kelime"+bulunanKelime+" Generation -->  "+Generation_timer);
generationOrt+=Generation_timer;

 long endTime = System.currentTimeMillis();
   
   long estimatedTime = endTime - startTime;
        System.out.println("Bulunana Kadar Geçen Süre "+estimatedTime+"ms");



    }
    
        System.out.println("Nesil ortalaması: "+generationOrt/5);}
    
}
