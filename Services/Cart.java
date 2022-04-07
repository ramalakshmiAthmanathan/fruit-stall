package Services;

import Models.Fruit;
import Models.BuyAndGet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    Map<Fruit,Integer> fruits = new HashMap<>();
    List<BuyAndGet> buyAndGets = new ArrayList<>();

    public Double totalCartValue(){
        return fruits.entrySet().stream()
                .map(fruit -> fruit.getKey().getPrice()*fruit.getValue())
                .mapToDouble(price -> price).sum();
    }

    public void addToCart(Fruit fruit,int count,boolean seasonSale){
        if(seasonSale){
            BuyAndGet buyAndGetValue = buyAndGets.stream()
                    .filter(buyAndGet -> buyAndGet.getName().equals(fruit.getName()))
                    .findFirst()
                    .orElseThrow();

            int totalCountAfterBuyFree = buyAndGetValue.getBuyCount() + buyAndGetValue.getFreeCount();

            if(count > totalCountAfterBuyFree){
                count=((count/totalCountAfterBuyFree)
                        *buyAndGetValue.getBuyCount())
                        +(count%totalCountAfterBuyFree);
            }
        }
        fruits.put(fruit,count);
    }

    public static void main(String args[]){
        Fruit apple = new Fruit("Apple",10.0);
        Fruit orange = new Fruit("Orange",20.0);

        BuyAndGet appleOffer = new BuyAndGet("Apple",1,1);
        BuyAndGet orangeOffer = new BuyAndGet("Orange",2,3);

        Cart cart = new Cart();
        cart.buyAndGets.add(appleOffer);
        cart.buyAndGets.add(orangeOffer);

        cart.addToCart(apple,5,true);
        cart.addToCart(orange,10,true);

        System.out.println(cart.totalCartValue());

    }
}
