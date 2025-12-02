package Lexer;

public class Main {
   
    public static void main(String[] args) {
       /*for (int i=Token.FIN; i <= Token.TIPO; i++){
            Token t = new Token(i, -4);
            System.out.println(i + "=" +t.toString());
        }*/
       
       Token t = new Token();
       t.set(9, 100);
        System.out.println(t);
    }
    
}
