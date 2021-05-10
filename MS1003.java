package LC;
//搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。
// 请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回
// 索引值最小的一个。
//

public class MS1003 {
    public int search(int[] arr, int target) {
        int n=arr.length;
        if(n==0){
            return -1;
        }
        int left=0,right=n-1;
        // 1.1 预处理 */
        while(right>=0&&arr[left]==arr[right]){right--;}
        // 1.2 寻找数组最小值的位置 */
        if(arr[left]>arr[right]){
            while(left<right){
                int mid=left+(right-left)/2;
                if(arr[mid]<arr[0]){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
        }
        if(left==right){
            // 指向最小值
            if(target>=arr[0]){
                left=0;
                right--;
            }else{
                right=n-1;
            }
        }
        // 3.搜索target */
        while(right>=0&&left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target){
                right=mid;
            }else if(arr[mid]<target){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return arr[right]==target?right:-1;

    }
}
