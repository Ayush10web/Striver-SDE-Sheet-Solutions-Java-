import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class pascal{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> pascalList = generate(n);
        System.out.println(pascalList);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rowArray = new ArrayList<>();

        for(int i = 0 ; i < numRows ; i++) {
            List<Integer> colArray = new ArrayList<>();
            
            for(int j = 0 ; j <= i ; j++) {
                if(j==0||j==i){
                    colArray.add(1);
                }else{
                    colArray.add(j,rowArray.get(i-1).get(j-1)+rowArray.get(i-1).get(j));
                }
            }
            rowArray.add(colArray);
        }
        return rowArray;
    }
}
