package Main;

import java.util.Scanner;
public class AleKing {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int n,n2,opc;
        Lista list = new Lista();
        do{
            n = entrada.nextInt();
            for (int i = 0; i < n; i++) {
                do{
                   n2 = entrada.nextInt(); 
                }while(n2<0 && n2>1000000);
                list.insertar(n2);
            }
            opc = entrada.nextInt();
            
        }while(((n<0) && (n>1000000))&&(opc<=0 && opc>3));
        list.opcion(opc);
        
    }
}
class Nodo{
    int dato;
    Nodo sig;
    Nodo ant;
}
class Lista{
    Nodo inicio=null;
    Nodo fin=null;
    
    public void insertar(int dato){
        Nodo nuevo = new Nodo();
        
        nuevo.dato=dato;
        nuevo.sig=null;
        nuevo.ant=null;
        if(inicio==null){
            inicio=nuevo;
            nuevo.sig=null;
            fin=nuevo;
        }else{
            fin.sig=nuevo;
            nuevo.ant=fin;
            nuevo.sig=null;
            fin=nuevo;
        }
    }
    public Boolean verificar(){
        Nodo nodoActual=inicio; 
        Nodo nodoSiguiente= null; 
        Boolean v=null; 
        if(nodoActual==null){
            v=true; 

        }else{
          while(nodoActual.sig!=null){ 
              nodoSiguiente=nodoActual.sig; 
              if(nodoActual.dato<nodoSiguiente.dato){ 
                  v=false; 
                  break;
              }
              nodoActual=nodoActual.sig;
            }
        }
        if(v==null){
            v=true;
        }
        return v;
    }
    public void opcion(int op){
        switch(op){
            case 1:
                Nodo aux=fin;
                while(aux!=null){
                    System.out.print(" "+aux.dato);
                    aux=aux.ant;
                }
                break;
            case 2:
                Nodo aux2 = inicio;
                while(aux2!=null){
                    System.out.print(" "+aux2.dato);
                    aux2=aux2.sig;
                }
                break;
            case 3:
                Nodo aux3=inicio;
                Nodo sig=null;
                Integer guardar;  
                if(verificar()){
                        aux3=inicio;
                        while(aux3!=null){
                        System.out.print(" "+aux3.dato);
                        aux3=aux3.sig;
                    }
                }else{
                    while(!verificar()){
                      aux3=inicio; 
                        while(aux3.sig!=null){ 
                            sig=aux3.sig; 
                            if(aux3.dato<sig.dato){
                                guardar=aux3.dato; 
                                aux3.dato=sig.dato; 
                                sig.dato=guardar;
                            }
                            else{
                                aux3=aux3.sig;
                            }
                        }
                    }
                        aux3=inicio;
                        while(aux3!=null){
                        System.out.print(" "+aux3.dato);
                        aux3=aux3.sig;
                    }
                }
                break;
            default:
                break;
        }
    }
    
}