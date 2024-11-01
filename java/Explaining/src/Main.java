public class Main {
    public static void main(String[] args){

//        int N = 1000;
//        int[] a = new int[N*N*N*N];

//        int N = 200;
//        int[] b = new int[N*N*N*N];


        int[] numbers  = new int[10];

        for (int i =0; i < numbers.length; i++){
            numbers[i] = (int)(Math.random() * 100) + 1;
        }

        System.out.printf("%n%nOriginal array:%n");
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("%2$d %1$d%n", numbers[i], i);
        }

        System.out.printf("%n%nArray in reverse order:%n");
        for(int j= numbers.length -1; j>= 0; j--){
            System.out.printf("%2$d %1$d%n", numbers[j], j);
        }
    }
}