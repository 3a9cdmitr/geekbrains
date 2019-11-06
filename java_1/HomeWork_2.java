import java.util.Arrays;

public class homework_2 {
    public static void main(String[] args){
        int[] arr1={ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
        int[] arr2= new int[8];
        int[] arr3={1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        int[][] arr5={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};

        reverseAr(arr1);
        System.out.println(Arrays.toString(arr1));
        fillAr(arr2);
        System.out.println(Arrays.toString(arr2));
        changeAr(arr3);
        System.out.println(Arrays.toString(arr3));
        System.out.println(minMaxAr(arr3));
        diagAr(arr5);
        displArr(arr5);
        System.out.println(checkBalance(arr3));
        biasAr(arr3, -2);
        System.out.println(Arrays.toString(arr3));
    }

    public static void reverseAr(int[] arr){
        for (int i=0; i<arr.length;i++)
            if (arr[i]==0) arr[i]=1;
            else arr[i]=0;
    }

    public static void fillAr(int[] arr){
        for (int i=1; i<arr.length;i++)
            arr[i]= i*3+1;
    }

    public static void changeAr(int[] arr){
        for (int i=0;i<arr.length;i++)
            if (arr[i]<6) arr[i]*=2;
    }

    public static String minMaxAr(int[] arr){
        int min=arr[0];
        int max=arr[0];
        for (int el:arr){
            if (el<min) min=el;
            if (el>max) max=el;
        }
        String t="MAX= "+max+"\nMIN="+min;
        return t;
    }

    public static void diagAr(int[][] arr){
        for (int i=0;i<arr.length; i++)
            arr[i][i]=1;
    }

    public static void displArr(int[][] arr){
        for (int i=0;i<arr.length; i++){
            for (int j=0;j<arr[i].length;j++)
                System.out.print(arr[i][j]+"\t");
            System.out.println();
        }
    }

    public static int sumAr(int[] arr){
        int sum=0;
        for (int el:arr) sum+=el;
        return sum;
    }

    public static boolean checkBalance(int[] arr){
        int first=0;
        int sum=sumAr(arr);
        for (int el:arr){
            first+=el;
            if (first==sum-first) return true;
        }
        return false;
    }

    public static void biasAr(int[] arr, int n){
        if (n<0) n=arr.length+n;
        for (int i=0;i<n;i++) {
            int temp = arr[arr.length-1];
            for (int j = arr.length-1; j >0; j--)
                arr[j] = arr[j-1];
            arr[0] = temp;
        }
    }

}
