package yangxinwu.algorithm;

public class PopSort {


   // 冒泡排序
   public void sort(int[] nums,int n){
        for (; n > 0 ; n--) {
            boolean swapFlag = false;
            for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]){
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
                swapFlag = true;
            }
            }

            if (!swapFlag){
                break;
            }
        }

       for (int i = 0; i < nums.length; i++) {
           System.out.println("nums " + nums[i]);
       }

    }


    // 插入排序

    public void insertSort(int[] nums,int n){
        for (int p = 1; p < n ; p++) {
            int temp  = nums[p];
            int i = p;
            for (; i > 0 && nums [i - 1] > temp ; i--) {
                nums[i] = nums[i - 1];
            }
            nums[i] = temp;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums " + nums[i]);
        }
    }



    // 希尔排序

    public void shellSort(int[] nums,int n){

        for (int i = n/2; i >0 ; i = i/2) {
            for (int p = i; p < n ; p++) {
                int temp = nums[p];
                int j = p;
                for (; j >= i && nums[j - i] > temp ; j= j - i) {
                    nums[j] = nums[j - i];
                }
                nums[j] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums " + nums[i]);
        }
    }


    //归并排序
    public void merge(int[] nums,int[] temp,int l,int r,int rightEnd){
       int newNumSize = rightEnd - l + 1;
       int tempIndex = l;
        int leftEnd = r - 1;

       while (l <= leftEnd && r <= rightEnd){
           if (nums[l] < nums[r]){
               temp[tempIndex ++] = nums[l++];
           }else {
               temp[tempIndex ++] = nums[r++];
           }
       }

       while (l <= leftEnd){
           temp[tempIndex ++] = nums[l++];
       }

        while (r <= rightEnd){
            temp[tempIndex ++] = nums[r++];
        }


        for (int i = 0; i < newNumSize; i++,rightEnd -- ) {
            nums[rightEnd] = temp[rightEnd];
        }
    }


    public void MSort(int[] nums ,int[] temp,int l,int rightEnd){

       int center;

       if (l < rightEnd){

           center = (rightEnd + l)/2;

           MSort(nums,temp,l,center);

           MSort(nums,temp,center + 1,rightEnd);

           merge(nums,temp,l,center + 1,rightEnd);

       }
    }


    public void mergeSort(int[] nums,int n){

       int[] temp = new int[n];

       MSort(nums,temp,0,n-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums " + nums[i]);
        }
    }



    public static void main(String[] args) {
     int[] test = {8,3,5,2,7,0,1};
      PopSort popSort = new PopSort();
      popSort.mergeSort(test,test.length);
    }




}
