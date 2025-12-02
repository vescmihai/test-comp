package Lexer;

public class Analex {
    private Cinta M;
    private Token R;
    private String ac;
    private int pos;        //Posición de inicio del lexema del preanalisis(), calculado en el dt(). 
                            //Use Cinta.getPos() o sea pos=M.getPos();
    
    public Analex(Cinta c){
        M = c;
        R = new Token();
        init();
    }
    
    public final void init(){   //Rewind
        M.init();
        avanzar();      //Calcular el primer preanalisis.
    }
    
    public Token Preanalisis(){
        return R;
    }
    
    public String lexema(){
        return ac;
    }
    
    public void avanzar(){
       dt();
    }
    
    private void dt(){
       int estado = 0;
       ac = "";
       int nomToken=0;
       
       pos = M.getPos();
       
       while (true){
           char c = M.cc();
           switch(estado){
               case 0 : if (espacio(c)){
                           M.avanzar();
                           estado = 0;
                           pos = M.getPos();
                        }
                        else
                          if (c==Cinta.EOF)
                              estado = 200;
                          else{
                             ac = ""+c;
                             nomToken = Token.getNomToken(c);
                             
                             if (nomToken >= 0){
                                 M.avanzar();
                                 estado = 100;
                             }
                             else //otro
                               estado = 300;  
                          }
                        break;  
                
               case 100 : R.setNom(nomToken);
                          return;
                        
               case 200 : //Estado final
                          R.setNom(Token.FIN);
                          return;
                          
               case 300 : //Estado final
                          R.setNom(Token.ERROR);
                          return;
           }
       }
    }
    
    public void resaltar(){    //Para resaltar el lexema del Preanalisis en el progFuente.
        comunicate(pos, lexema());
    }
    
    public void comunicate(int pos, String lexema){ //Overridable. Para la Interfaz.
        
    }
    
//------------------------------------------------------------------------------
    private boolean espacio(char cc){
        final int SPACE=32, TAB=9;
        return (cc == Cinta.EOLN || cc == SPACE || cc== TAB);
    }
    
    private boolean digito (char cc){
        return ('0'<=cc && cc<='9');
    }
    
    private boolean letra(char cc){
        cc = Character.toUpperCase(cc);   //Convertir a mayúsculas.
        return ('A'<=cc && cc<='Z');
    }
}
