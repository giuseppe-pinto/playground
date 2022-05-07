import java.util.List;
import java.util.TreeSet;

public class Result {


  public static void miniMaxSum(List<Integer> arr) {

    TreeSet<Long> sums = new TreeSet<>();

    for (int i = 0; i < arr.size(); i++) {
      long sum = 0L;
      for (int j = 0; j < arr.size(); j++) {
        if(i != j){
          sum = sum + arr.get(j);
        }
      }
      sums.add(sum);
    }
    System.out.println(sums.first() + " " + sums.last());

  }
}
