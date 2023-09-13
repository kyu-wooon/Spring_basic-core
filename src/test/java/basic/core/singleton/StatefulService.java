package basic.core.singleton;

public class StatefulService {
    //private int price; // 상태를 유지하는 필드 10000 -> 20000 : 이 부분을 제거해야 한다.
    public int order(String name, int price){
         System.out.println("name=" + name + "price = " + price );
         //this.price = price; //이 부분이 문제이다.
        return price;
    }
/*
    public int getPrice(){
        return price;
    }

 */
}
