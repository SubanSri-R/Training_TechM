package Task6;
public class Task_6 {
    public static <T> boolean areEqual(T[] array1, T[] array2) {
        if (array1.length != array2.length) {
            return false;
        }
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] array1 = {77,55,22,33};
        Integer[] array2 = {77,55,22,33};
        Integer[] array3 = {1, 2, 3, 5};

        System.out.println(areEqual(array1, array2));
        System.out.println(areEqual(array1, array3));

        String[] arr={"aa","bb","cc"};
        String[] arr1={"aa","bb","cc"};
        String[] arr2={"ba","ab","cc"};

        System.out.println(areEqual(arr, arr1));
        System.out.println(areEqual(arr1, arr2));
    }
}
