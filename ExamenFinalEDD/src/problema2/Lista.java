/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema2;

/**
 *
 * @author Jo
 */
public class Lista {
    private NodoL head;
    
    public Lista(){
        this.head = null;
    }
    
    //Insertar con posición x y
    public void insertar(Object dato, int x, int y){
        NodoL nuevo = new NodoL(dato,x,y);
        NodoL aux = this.head;
        boolean existe = false, esNull = false;
        if (this.isEmpty()){
            this.head = nuevo;
        }else{
            while (nuevo.getX()>aux.getX()){
                if (aux.getSiguiente() == null){
                    esNull = true;
                    break;
                }
                aux = aux.getSiguiente();
            }
            
            while (!esNull && nuevo.getY()>aux.getY() && aux.getSiguiente().getX()==nuevo.getX()){             
                if (aux.getSiguiente() == null){
                    break;
                }
                aux = aux.getSiguiente();
                if (nuevo.getY() == aux.getY()){
                    existe = true;
                }
            }
            
            if (existe){
                //Sustitución del valor que ya existe.
                aux = nuevo;
            }
            else if (!existe){
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }else if (esNull){
                nuevo.setSiguiente(aux.getSiguiente());
                aux.setSiguiente(nuevo);
            }
            
        }
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
}
