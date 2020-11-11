/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problema1;

/**
 *
 * @author Jo
 */
public class ArbolB {
    private Nodo head;
    
    public ArbolB(){
        this.head= null;
    }
    
    public void add(String dato){
        //Método para agregar el nuevo elemento
        this.head = add(this.head, dato);
    }
    
    private Nodo add(Nodo actual,String dato){
        if (this.head == null){
            Nodo nuevo = new Nodo(dato);
            return nuevo;
        } 
        if (getAscii(dato)<actual.getValor()){
            actual.setIzquierda(add(actual.getIzquierda(),dato));
        }else if (getAscii(dato)>actual.getValor()){
            actual.setDerecha(add(actual.getDerecha(),dato));
        }
        
        return actual;
    }
    
    public Nodo buscar(String dato){
        int ascii = getAscii(dato);
        return buscar(this.head, ascii);
    }
    
    private Nodo buscar(Nodo actual, int dato){
        //Método para buscar un elemento y si no lo encuentra devuelve null
        if (actual == null || actual.getValor()==dato){
            return head;
        }
        if (actual.getValor() < dato){
            return buscar(actual.getDerecha(),dato);
        }
        
        return buscar (actual.getIzquierda(),dato);
    }
    
    public boolean isEmpty(){
        //Método para verificar si el árbol está vacio
        return this.getHead() == null;
    }
    
    public void recorrer(Nodo actual){
        if (actual == null){
            return;
        }
        System.out.println("Palabra: " +actual.getDato()+" Ocurrencias: "+actual.getContador());
        recorrer(actual.getIzquierda());
        recorrer(actual.getDerecha());
    }
    
    public int getAscii(String dato){
        int ascii = 0;
        char[] caracteres = dato.toCharArray();
        for (char car:caracteres){
            ascii = ascii + (int)car;
        }
        return ascii;
    }

    /**
     * @return the head
     */
    public Nodo getHead() {
        return head;
    }

    /**
     * @param head the head to set
     */
    public void setHead(Nodo head) {
        this.head = head;
    }
    
    
}
