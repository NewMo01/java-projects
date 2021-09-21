
package algorithms;

public class Sorting {
    
// Display array
    static void Display(int[]a){
        for(int i: a)System.out.print(i+ "  " );
    }
    
// Bubble sort   ////////////////////////////////
    static void BubbleSort(int[] a){ 
        for(int i=0;i<a.length-1;i++){
            boolean con = false ;
            for(int j=0;j<a.length-1-i;j++){
                if(a[j]>a[j+1]){
                    int t = a[j] ;
                    a[j] = a[j+1] ;
                    a[j+1] = t ;
                    con = true ; 
                }
            }
            if(!con)break ;
        } 
    }
// Selection sort   ////////////////////////////////
    static void SelectionSort(int[]a){
        for(int i=0;i<a.length-1;i++){
            int min = a[i] , min_ind = i;
            for(int j=i+1;j<a.length;j++){
                if(a[j]<min) {min = a[j]; min_ind = j; }
            }
            // swap min with first element
            if(min != a[i]){
                int t = a[i] ;
                a[i] = min ;
                a[min_ind] = t;
            }
        }
    }
// Insertion sort  ////////////////////////////////
    static void InsertionSort(int[]a){
        for(int i=0;i<a.length-1;i++){
            int val = a[i+1] , hole = i+1 ;
            for(int j=i;j>=0;j--){ 
                if(a[j]<val)break;
                else if(a[j]>val){a[j+1] = a[j]; hole--;}
            }
            a[hole] = val ;
        }
    }
// Quick sort  ////////////////////////////////
    static int partition(int[]a , int start , int end){
        int pivot = a[end];
        int i = start-1 ;
        for(int j=start ;j<end;j++){
            if(a[j]<pivot){
                // do swap
                i++ ;
                int t = a[i];
                a[i] = a[j];
                a[j] = t ;
            }
        }
        //swap pivot
        int t1 = a[i+1];
        a[i+1] = pivot ;
        a[end] = t1;
        return i+1 ;
    }
    static void QuickSort(int[]a , int start , int end){
        if(end>start){
            int pivotInd = partition(a,start,end);
            QuickSort(a,start , pivotInd-1);
            QuickSort(a,pivotInd+1 , end);
        }
    }
// Merge sort ////////////////////////////////
    static void merge(int[]a,int start,int mid,int end){
        int leftLen = mid-start +1  ;
        int rightLen = end-mid  ;
        int[] left = new int[leftLen];
        int [] right = new int[rightLen];
        for(int i=0;i<leftLen;i++)left[i]=a[start+i];
        for(int j=0;j<rightLen;j++)right[j]=a[mid+1+j];
        int i= 0 , j = 0 , k = start ;
        while(i<leftLen && j<rightLen){
            if(left[i]< right[j]){
                a[k] = left[i]; 
                k++; i++;   
            }
            else if(right[j]< left[i]){
                a[k] = right[j]; 
                k++; j++;   
            }
        }
        while(i<leftLen){a[k++]=left[i++];}
        while(j<rightLen){a[k++]=right[j++];}
        
    }
    static void MergeSort(int[]a,int start,int end){
        if(end>start){
            int mid = (start+end)/2 ;
            MergeSort(a,start,mid);
            MergeSort(a,mid+1,end);
            merge(a,start,mid,end);
        }
    }
    
    
}
