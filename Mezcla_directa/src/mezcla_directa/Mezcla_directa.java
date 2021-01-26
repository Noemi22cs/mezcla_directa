package mezcla_directa;
/**
 *
 * @author Noemi
 */
public class Mezcla_directa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Mezcla_directa ordenar=new Mezcla_directa();
        int vector[]={5,8,67,180,23,92,162};
        System.out.println("Vector original");
        ordenar.mostrarArreglo(vector);
        System.out.println("Vectro ordenado por mezcla directa");
        vector=ordenar.mezcla(vector);     
        ordenar.mostrarArreglo(vector);
    }
        public int[] mezcla(int[] arreglo) {
        int i, j, k;
        if (arreglo.length > 1) {//Si el tamaño del arreglo es mayor de 1, entonces se llevará a cabo la búsqueda
            int nElementosIzq = arreglo.length / 2;
            int nElementosDer = arreglo.length - nElementosIzq;
            int arregloIzq[] = new int[nElementosIzq];
            int arregloDer[] = new int[nElementosDer];

            for (i = 0; i < nElementosIzq; i++) {
                arregloIzq[i] = arreglo[i];
            }
            for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
                arregloDer[i - nElementosIzq] = arreglo[i];
            }
            //Recursividad
            arregloIzq = mezcla(arregloIzq);
            arregloDer = mezcla(arregloDer);
            i = 0;
            j = 0;
            k = 0;
            while (arregloIzq.length != j && arregloDer.length != k) {
                if (arregloIzq[j] < arregloDer[k]) {
                    arreglo[i] = arregloIzq[j];
                    i++;
                    j++;
                } else {
                    arreglo[i] = arregloDer[k];
                    i++;
                    k++;
                }
            }
            while (arregloIzq.length != j) {
                arreglo[i] = arregloIzq[j];
                i++;
                j++;
            }
            while (arregloDer.length != k) {
                arreglo[i] = arregloDer[k];
                i++;
                k++;
            }
        }
        return arreglo;
        }
        public void mostrarArreglo(int[]arreglo){
            int k;
            for (k=0;k<arreglo.length;k++){
                System.out.print("["+arreglo[k]+"]");
            }
            System.out.println();
        }
}
