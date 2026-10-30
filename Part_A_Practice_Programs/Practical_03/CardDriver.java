public class CardDriver {
    public static void main(String[] args){
        Card[] input={new Card("Ace","Spades"),new Card("King","Hearts"),new Card("Ace","Spades")};
        Card[] added=new Card[input.length];int count=0;
        for(Card c:input){boolean duplicate=false;for(int i=0;i<count;i++)if(c.equals(added[i])){duplicate=true;break;}
            if(duplicate){System.out.println("Duplicate found: "+c);break;}added[count++]=c;}
    }
}
