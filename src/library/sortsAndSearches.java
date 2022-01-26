package library;

import java.util.Date;
import java.util.Stack;
import objects.ticket;


public class sortsAndSearches {
    
// <editor-fold defaultstate="collapsed" desc="Integer Merge Sort">
    
    public static void integerMergeSort(int[] programArray){ //takes array from program to be sorted
        
        int size = programArray.length;
        //stops stack overflow of trying to split an array with the size of 1
        if (size < 2) { 
            return;
        }
        
        int mid = size / 2; //middle of the main array
        int leftSize = mid; //left array is the first half of the main array
        int rightSize = size - mid; //right array is the second half of the main array
        
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        
        //putting values into left array from first half of main array
        for (int i = 0; i < mid; i++) {
            left[i] = programArray[i];
        }
        
        //putting values into right array from second half of main array
        for (int i = mid; i < size; i++) {
            right[i - mid] = programArray[i];
        }
        
        integerMergeSort(left);
        integerMergeSort(right);
        integerMerge(left,right, programArray); //puts completely split arrays back into program array
        
    }
    
    public static void integerMerge(int left[], int[] right, int[] arr) {        
        int leftSize = left.length;
        int rightSize = right.length;
        int a = 0; //left side pointer
        int b = 0; //right side pointer
        int i = 0; //main array pointer
        
        while (a < leftSize && b < rightSize) {
            if (left[a] <= right[b]) {
                arr[i] = left[a];
                a++;
                i++;
            } else { 
                arr[i] = right[b];
                b++;
                i++;
            }
        }
        while (a < leftSize) {
            arr[i] = left[a];
            a++;
            i++;
        }
        while (b < rightSize) {
            arr[i] = right[b];
            b++;
            i++;
        }

    }
    
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="String Merge Sort">
 
    public static void stringMergeSort(String[] programArray) {
        int size = programArray.length;
        //stops stack overflow of trying to split an array with the size of 1
        if (size < 2) {
            return;
        }
        
        int mid = size / 2; //middle of the main array
        int leftSize = mid; //left array is the first half of the main array
        int rightSize = size - mid; //right array is the second half of the main array
        
        String[] left = new String[leftSize];
        String[] right = new String[rightSize];

        for (int i = 0; i < left.length; i++) {
            left[i] = programArray[i];
        }
        for (int i = 0; i < right.length; i++) {
            right[i] = programArray[i + mid];
        }

        stringMergeSort(left);
        stringMergeSort(right);

        stringMerge(programArray, left, right);

    }

    public static void stringMerge(String[] resultArray, String[] left, String[] right) {
        int a = 0; //left side pointer
        int b = 0; //right side pointer
        for (int i = 0; i < resultArray.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b])<0)) { //placing the smallest element
                      resultArray[i] = left[a];
                      a++;
                 } else {
                      resultArray[i] = right[b];
                      b++;
                      
                 }
            }
    }
    
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Stack Reverses">    
    
    public static void stringReverseArray(String[] programArray) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < programArray.length; i++) {
            stack.push(programArray[i]);
        }

        for (int i = 0; i < programArray.length; i++) {
            programArray[i] = stack.pop();
        }

    }
    
    public static void integerReverseArray(int[] programArray) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < programArray.length; i++) {
            stack.push(programArray[i]);            
        }
        
        for (int i = 0; i < programArray.length; i++) {
            programArray[i] = stack.pop();
        }
        
    }
    
    public static void dateReverseArray(Date[] date) {
        Stack<Date> stack = new Stack<>();
        for (int i = 0; i < date.length; i++) {
            stack.push(date[i]);            
        }
        
        for (int i = 0; i < date.length; i++) {
            date[i] = stack.pop();            
        }
    }
    
    public static void ticketReverseArray(ticket[] userTicket) {
        Stack<ticket> stack = new Stack<>();
        for (int i = 0; i < userTicket.length; i++) {
            stack.push(userTicket[i]);            
        }
        
        for (int i = 0; i < userTicket.length; i++) {
            userTicket[i] = stack.pop();            
        }
    }
    
    
// </editor-fold>
    
    public static void dateBubbleSort (Date[] date) {
        //sort months into correct order
        for (int i = 0; i < date.length; i++) {
            for (int j = 0; j < date.length - i - 1; j++) {
                //if first date comes before second date, swap dates
                if (date[j].after(date[j + 1])) {
                    Date temp = date[j];
                    date[j] = date[j + 1];
                    date[j + 1] = temp;
                } else {
                    System.out.print("");
                }
            }
        }
    }

    
    
    
    public static void bubbleSort (int[] number) {
       
        for (int i = 0; i < number.length; i++) {
            for (int j = 0; j < number.length - i -  1; j++) {

                if (number[j] > number[j + 1] ){
                    //System.out.println(number.get(j));
                    int temp = number[j];
                    number[j] = number[j + 1];
                    number[j + 1] = temp;
                } else {
                    System.out.print("");
                }

            }
        }
        
    }    
    
}
