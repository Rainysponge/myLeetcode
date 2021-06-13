package LC;

//        int[] nums2 = {};
//        TreeNode root = new TreeNode();
//        ControlTreeNode control = new ControlTreeNode();
//        TreeNode root = control.buildTree(nums);
//
//        ControlTreeNode control2 = new ControlTreeNode(root);
//        control2.InorderTraversal();
//        System.out.println("");
//        control2.PreorderPrintTraversal();
//        System.out.println("");
//        control2.PostorderTraversal();
//        System.out.println(new lc264().nthUglyNumber(7));

import dataStructure.ControlTreeNode;
import dataStructure.Heap;

//        int[] arr=new int[2000];
//        for(int i=0;i<arr.length;i++){
//            arr[i]=(int)(Math.random()*10000);
//        }
//
//
////        int[] nums = new int[]{2,4,7,5,1,9,14,13,6, 87,45,65, 22,36, 100, 98,77,64, 63};
//        Sort s = new Sort(arr);
//        for(int i=0; i<10;i++){
//            System.out.printf("%d\t", arr[i]);
//        }
//        System.out.println("");
////        s.InsertionSort(3,6);
//
//
//        long startTime=System.nanoTime();   //获取开始时间
//
//        s.QuickSort();//测试的代码段  QuickSort(6): 734600ns 512700ns 729600ns 647300ns
//                                  //InsertionSort : 3165100ns 4013700ns 3630900ns 4056600ns
//                                  //Shell: 555600ns 654400ns 2016000ns 950400ns
//                          //        QuickSort(cutoff=10): 759300ns 617300ns 802400ns 715300ns
//                         //        QuickSort(cutoff=2): 799800ns 878000ns 734800ns 956200ns
//
//        long endTime=System.nanoTime(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime-startTime)+"ns");
//
//
//        for(int i=0; i<10;i++){
//            System.out.printf("%d\t", arr[i]);
//        }
//        int[] t = new int[]{4,6,8,10,1,2,5,11,55,77};
//        Sort s = new Sort(t);
//        int[] m = new int[t.length];
////        s.Merge(m, 0, 4, t.length-1);
//
//        for(int i=0; i<t.length;i++){
//            System.out.printf("%d\t", s.getNums()[i]);
//        }
public class INPUT {
    public static char[][] trans(String[][] a){
        int m = a.length, n = a[0].length, i, j;
        char[][] res = new char[m][n];
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                res[i][j] = a[i][j].charAt(0);
            }
        }
        return res;


    }
    public static void main(String[] args) {
        int[] bloomDay = new int[]{1542,5142,4695,4385,2629,2492,933,1068,151,3960,3790,1196,3842,5147,5526,5528,2259,1708,2714,5462,3016,3262,1175,4348,4826,80,789,5285,3855,3455,3480,4277,648,1748,625,4256,3931,4938,4553,2129,4480,824,3048,2383,3036,2192,2156,7,438,5258,2430,2459,3769,1694,1687,5130,70,3219,4140,2341,1159,3952,4934,4335,2786,3124,5344,803,4586,1000,2821,4769,629,4673,3920,3437,4533,2984,3576,5364,1255,1876,2309,5619,2402,1978,4127,1668,147,4139,292,1499,1786,2435,1988,146,500,3377,3789,1301,1193,1686,3501,3895,1321,1587,4263,593,1580,3652,1638,4905,1927,567,2797,2082,1349,4158,679,4944,4638,4770,3458,2117,2620,938,4121,2374,1478,5269,5548,5125,5237,1693,2188,690,4640,827,2721,2329,430,4423,5510,2312,2493,4884,223,1904,4660,5124,2851,5227,4160,694,5660,5571,834,1704,4550,988,573,3373,5419,311,4280,399,5319,4723,5467,1155,4267,303,4233,770,3087,3306,1042,4192,3736,893,5087,1903,3650,393,5304,2767,3562,5501,4789,1863,1653,2528,5521,3802,3925,2718,5402,2642,304,4171,4356,5486,1426,4526,4541,4310,2160,4542,2850,2396,1612,4780,3921,5219,2585,4027,1861,3799,101,1434,996,203,1216,1654,4382,3791,3417,1912,5337,814,352,3892,3851,3432,2400};
        int m = 49, k = 4;
        int[] seats = new int[]{2, 1, -1};
        String s = "a(bcdefghijkl(mno)p)q";
        String s1 = "sea", s2 = "eat";
        //candiesCount = [7,4,5,3,8], queries = [[0,2,2],[4,2,4],[2,13,1000000000]]
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        new lc474().findMaxForm(strs, 5, 3);
    }

}


