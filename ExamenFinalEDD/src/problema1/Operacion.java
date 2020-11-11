
package problema1;


public class Operacion {
    private ArbolB arbol;
    public void Operacion(ArbolB arbol){
        this.arbol = arbol;
    }
    
    public void Registrar(String texto){
        String[] palabras = texto.split(" ");
        Nodo aux;
        for (String palabra: palabras){
            //No está vacio, entonces se busca agregar una palabra o una ocurrencia
            if (!arbol.isEmpty()){
                aux = arbol.buscar(palabra);
                if (aux != null){
                    aux.setContador(aux.getContador()+1);
                }else{
                    arbol.add(palabra);
                }
            }else{
                //Está vacio por lo que se agrega la palabra
                arbol.add(palabra);
            }
        }
    }
    
    public void imprimirLista(){
        //LLamar al método de recorrer del árbol
        arbol.recorrer(arbol.getHead());
    }
}

