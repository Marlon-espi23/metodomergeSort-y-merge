public class App {
    public static void mergeSort(int[] arr, int left, int rigth) {
        //System.out.println("Hello, World!");

        //metodo mergeSort
        if (left < rigth) {
        //encuentra el punto medio del arreglo
        int mid = (left + rigth) / 2;

        //ordenar recursivacamente la mitad izquierda 
        mergeSort(arr, left + 1, mid);
        //ordenar recursivamente la mitad derecha 
        mergeSort(arr, mid + 1, rigth);

        //combina las dos mitades ordenadas
        merge(arr, left, mid, rigth);
    }
}   


       //metodo merge
    private static void merge(int[] arr, int left, int mid, int rigth) {
        //Tamaños de los subarreglos a funcionar
        int sizeLeft = mid - left + 1;
        int sizeRigth =rigth - mid;

        //Arreglo temporales para almacenar los subarreglos 
        int[] tempLeft = new int[sizeLeft];
        int[] tempRigth = new int[sizeRigth];

        //Copia datos a los arreglos temporales 
        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRigth; j++) {
            tempRigth[j] = arr[mid + 1 + j];
        }

        //Fusiona los arreglos temporales en el arreglo original
        int i = 0, j = 0;
        int k = left; //Indice inicial para el arreglo fusionado

        while (i < sizeLeft && j < sizeRigth) {
            if (tempLeft[i] <= tempLeft[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRigth[j];
                j++;
            }
            k++;
        }

        //Copia elementos restante de tempLeft[] si los hay
        while (i < sizeLeft) {
            arr[k] = tempRigth[j];
            j++;
            k++;
            
        }

    
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        int n = arr.length;

        //Llamada al metodo de ordenamiento MergeSort
        mergeSort(arr, 0, n - 1);

        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.println(num + " ");
        }    


    }
}    