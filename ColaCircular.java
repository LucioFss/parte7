public class ColaCircular implements Cola{
    private int principio;
    private int fondo;
    private int tamaño;
    private int[] arreglo;

    public ColaCircular(int tamaño){
        this.principio = -1;
        this.fondo = -1;
        this.tamaño = tamaño;
        this.arreglo = new int[tamaño];
    }

    @Override
    public void encolar(int item) {
        if(estaLlena()){
            throw new IllegalStateException("Cola llena");
        }
        //se evalua que la lista antes de encolar esta vacia
        if(principio == -1){
            //el principio cambia a cero diciendo que ahora hay elementos encolados
            principio = 0;
        }
        //fondo se incrementa en 1 y se calcula su modulo con el tamaño total
        /*
         * ej = si no tenemos elementos y tenemos una cola de 10 elementos , 
         * el fondo sera -1 y se le suma 1, ahora es 0, y el modulo entre 0 y 10 (0%10) = 0,
         * agregamos otro, elemento, ahora el fondo es 1, el modulo seria 1%10 = 1
         */
        fondo = (fondo+1) % tamaño; //Cambiamos el fondo
        arreglo[fondo] = item;
    }

    @Override
    public void desencolar() {
        //Se evalua si la cola esta vacia
        if(estaVacia()){
            throw new NullPointerException("Cola vacia");
        }
        /*
         * evaluamos si la cola tiene un unico elemento, si lo tiene simplemente vuelven al principio
         */
        if(principio == fondo){
            fondo = -1; //Vuelve a los valores iniciales
            principio = -1; //Vuelve a los valores inciales
        }else{
            principio = (principio + 1) % tamaño; //Se pisa/ salta al siguiente elemento del arreglo "eliminandolo"
        }
    }
    
    @Override
    public boolean estaLlena() {
        /*
         * Se evalua si el modulo del valor del fondo de la cola es igual al del principio 
         * lo que significa que el modulo es n=m y por ende n % m = 0, es decir resultado con modulo 0
        */
        return (fondo + 1) % tamaño == principio; 
    }

    @Override
    public boolean estaVacia() {
        //Si el valor inicial de principio es -1 es decir, 
        return principio == -1;
    }

    /**
     * Metodo que imprime la cola, desde el valor de la variable "principio" 
     * hasta la el valor de la varia fondo
     */
    @Override
    public void imprimir() {
        if(estaVacia()){
            System.out.println("Lista vacia");
        }else{
            for(int i = principio; i < fondo+1; i++){
                System.out.print("["+arreglo[i]+"]");
            }
        }
    }
    
}
