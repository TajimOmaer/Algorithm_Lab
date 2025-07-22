package marge_sort;
class Marge_Sort {
    void marge(int arr[], int left, int mid, int right){
        int L = mid - left + 1;
        int R = right - mid;
        
        int left_array[] = new int[L];
        int right_array[] = new int[R];
        
            for(int i=0; i<L; ++i){
                left_array[i] = arr[left + i];
            }
            
            for(int j=0; j<R; ++j){
                right_array[j] = arr[mid + 1 + j];
            }
            
            int i = 0, j = 0;
            int k = left; 
            
        while(i<L && j<R){
            if(left_array[i] <= right_array[j]){
                arr[k] = left_array[i];
                    i++;
            }
            else{
                arr[k] = right_array[j];
                    j++;
             }
                    k++;
        }
        while(i<L){
            arr[k] = left_array[i];
                i++;
                k++;
        }
        while(j<R){
            arr[k] = right_array[j];
                j++;
                k++;
        }
    }
    void Sort(int arr[], int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            Sort(arr, left, mid);
            Sort(arr, mid+1, right); 
            marge(arr, left, mid, right);
        }
    }
    public static void main(String[] args){
        int arr[] = {90, 23, 101, 45, 65, 23, 67, 89, 34, 23};
        Marge_Sort object = new Marge_Sort();
        object.Sort(arr, 0, arr.length - 1);
        
        System.out.println("Sorted Array is: ");
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]+"");
        }
    }
}

When the Code Run , That Ans given: 
/*
Sorted Array is: 
23
23
23
34
45
65
67
89
90
101
BUILD SUCCESSFUL (total time: 0 seconds)
*/
