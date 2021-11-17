package LC;

public class JZ069 {
    public int peakIndexInMountainArray(int[] arr) {
        // 二分
        int N = arr.length;
        int left = 0, right = N - 1;
        int mid = left + (right - left) / 2;


        while(left < right){

            if(mid == N - 1){
                return mid;
            }

            if(arr[mid] < arr[mid+1]){
                left = mid + 1;
            }else{
                right = mid;
            }

            mid = left + (right - left) / 2;

        }

        return mid;



    }


}
