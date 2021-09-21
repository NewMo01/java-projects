
package algorithms;

public class Searching {
    
    // Linear search
    static Integer search(int[]a , int n,int start , int end){
        if(a[start] == n)return start ;
        else if(a[end] == n)return end ;
        if(start<end)return search(a,n,start+1,end-1);
        return null ;
    }
    // Binary search {should use sorted array}
    static Integer BinarySearch(int[]a,int n , int start , int end){
        int mid = (start+end)/2 ;
        if(a[mid] == n)return mid ;
        if(end>start){
            if(n<a[mid])return BinarySearch(a,n,start,mid-1) ;
            else if(n>a[mid])return BinarySearch(a,n,mid+1,end) ;
        }
        return null ;
    }
    
    
    
}
