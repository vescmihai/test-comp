package Lexer;

public class Token {
        //Para el NOMBRE del token. No modifique estos valores.
    public static final int FIN        = 0;
    public static final int ERROR      = 1;
    
    public static final int VAR        = 2;
    public static final int ARRAY      = 3;
    public static final int VOID       = 4;
    public static final int IF         = 5;
    public static final int ELSE       = 6;
    public static final int TO         = 7;
    public static final int DO         = 8;
    public static final int WHILE      = 9;
    public static final int READLN     = 10;
    public static final int PRINTLN    = 11;
    public static final int UNTIL      = 12;
    public static final int FALSE      = 13;
    public static final int TRUE       = 14;
    public static final int RETURN     = 15;
    public static final int MAIN       = 16;
    
    public static final int COMA       = 17;    //","
    public static final int PTOCOMA    = 18;    //";"
    public static final int CA         = 19;    //"["
    public static final int CC         = 20;    //"]"
    public static final int PA         = 21;    //"("
    public static final int PC         = 22;    //")"
    public static final int LA         = 23;    //"{"
    public static final int LC         = 24;    //"}"
    
    public static final int POR        = 25;    //"*"
    public static final int MOD        = 26;    //"%" y "mod"
    public static final int MAS        = 27;    //"+"
    public static final int MENOS      = 28;    //"-"
    public static final int DIV        = 29;    //"/" y "div" 
    public static final int NOT        = 30;    //"!" y "not"
    public static final int AND        = 31;    //"and"    
    public static final int OR         = 32;    //"or"
    
    public static final int DOTS       = 33;    //".."
    public static final int DOSPUNTOS  = 34;    //":"
    public static final int ASSIGN     = 35;    //":=" y "="
    
    public static final int NUM        = 36;
    public static final int ID         = 37;
    public static final int STRINGctte = 38;
    public static final int OPREL      = 39;
    public static final int TIPO       = 40;
    
        //Atributos del token OPREL
    public static final int IGUAL = 0;  //"=="
    public static final int MEN   = 1;
    public static final int MAY   = 2;
    public static final int MEI   = 3;
    public static final int MAI   = 4;
    public static final int DIS   = 5;  //"!=" y "<>"
    
        //Atributos del token TIPO
    public static final int CHAR    = -4;
    public static final int BOOLEAN = -3;
    public static final int INTEGER = -2;
    
    /**Devuelve el nombre del Token cuyo lexema es cc (lexema de longitud 1) y
     * cc no es sublexema del lexema de otro token.<br>
     * si cc no cumple esta condición, return -1 */
    public static int getNomToken(char cc){
        char lexem[]={COMA,PTOCOMA,CA,CC,PA,PC,LA,LC,POR,MOD,MAS,MENOS};
        int nom[]={',', ';', '[', ']', '(', ')', '{', '}', '*', '%', '+', '-'};
       
        for (int i=0; i<lexem.length; i++){
            if (nom[i]==cc)
                return lexem[i];
        }
        return -1;
    }
      
        //Campos de la class
    private int nom, atr;   //<nom, atr>
    
    public Token(){
       this(FIN); 
    }
    
    public Token(int nombre){
        this(nombre, 0);
    }
    
    public Token(int nombre, int atributo){
        nom = nombre;   atr=atributo;
    }

    
    public void set(int nombre, int atributo){
        nom = nombre;   atr=atributo;
    }

    public void setNom(int nom) {
        this.nom = nom;
    }

    public void setAtr(int atr) {
        this.atr = atr;
    }

    public int getNom() {
        return nom;
    }

    public int getAtr() {
        return atr;
    }
    
 
//---------- 
    @Override
    public String toString(){
        return "<" + get(NOMtokenSTR, nom) + "," + atrToString(nom) + ">";
    }
       
    private String atrToString(int nom){   //Devuelve el atributo del token nom.
        if (FIN <= nom && nom <=ASSIGN)
            return "_";
        
        if (nom == OPREL)
            return get(OPRELstr, atr);
        
        if (nom == TIPO)
            return get(TIPOstr, atr-CHAR);
        
        return ""+atr;
    }

    private String get(String v[], int i){
        try {
            return v[i]; 
        } catch (Exception e) {
            return DESCONOCIDO;
        }
    }
    
    
    private static final String DESCONOCIDO = "??";
    
    private static final String OPRELstr[]={"IGUAL", "MEN", "MAY", "MEI", "MAI", "DIS"};
    private static final String TIPOstr[] ={"CHAR", "BOOLEAN", "INTEGER"};
    
    private static final String NOMtokenSTR[] ={
        "FIN","ERROR",
        "VAR","ARRAY","VOID","IF","ELSE","TO","DO","WHILE","READLN","PRINTLN",
        "UNTIL","FALSE","TRUE","RETURN","MAIN",
        "COMA","PTOCOMA","CA","CC","PA","PC","LA","LC","POR","MOD","MAS","MENOS",
        "DIV","NOT","AND","OR","DOTS","DOSPUNTOS","ASSIGN",
        "NUM","ID","STRINGctte","OPREL","TIPO"
    };  
}
