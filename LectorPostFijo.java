import java.util.Stack;
/**
 * CLASE QUE POSEE UN METODO QUE CALCULA POSTFIJOS INGRESADOS 
 * COMO STRING Y SUS TESTS
 */
public class LectorPostFijo{
    /**
     * Metodo que dado un string que representa una expresión en notación postfija, 
     * la evalúa y retorna su resultado.  
     * @param operacion operacion postfija
     * @return double resultado de la operación postfija
     */
    public static double evaluarPF(String operacion){
        Stack<Double> pila = new Stack<>(); //Pila que guardara números y los resultados de operaciones
        //Iteración sobre cada caracter de la expresión postfija
        for(int i = 0; i < operacion.length(); i++){
            char var = operacion.charAt(i); //Se guarda el caracter sea numero o signo de operando

            //Evaluacion si el caraCter actual es un numero, si lo es se guarda en la pila
            if(Character.isDigit(var)){
                
                /*
                El metodo de Caracter getNumericValue(var), metodo que convierte un caracter a
                un numero, en este caso casteamos(Cast) el resulado a double por que el 
                compilador no sabe a que número se convertira ese caracter
                */    
                pila.push((double) Character.getNumericValue(var)); //Convertido el caracter a numero gracias al cast y el metodo, se apila
            }
            //Se evalua si el caracter actual es el signo operando "+"
            if(var == '+'){
                double val1 = pila.pop();
                double  val2 = pila.pop();
                pila.push(val1 + val2); 

            }
            //Se evalua si el caracter actual es el signo operando "+"
            if(var == '-'){
                double val1 = pila.pop();
                double  val2 = pila.pop();
                pila.push(val2 - val1); 
            }
            //Se evalua si el caracter actual es el signo operando "+"
            if(var == '*'){
                double val1 = pila.pop();
                double  val2 = pila.pop();
                pila.push(val1 * val2); 
            }
            //Se evalua si el caracter actual es el signo operando "+"
            if(var == '/'){
                double val1 = pila.pop();
                double  val2 = pila.pop();
                pila.push(val2 / val1); 
            }
        }   

        return pila.peek();
    }

    public static void main(String[] args) {
        double result1 = evaluarPF("74-63+*");
        System.out.println(result1);
        double result2 = evaluarPF("512+4*+3-");
        System.out.println(result2);
        double result3 = evaluarPF("392+*8-5/");
        System.out.println(result3);
    }
}