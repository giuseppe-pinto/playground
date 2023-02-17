package exercises.leetcode.longestMountainInArray;

import exercises.leetcode.longestMountainInArray.exception.NotEnoughDataException;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestMountainCalculator {

  public int exec(int[] mountains) throws NotEnoughDataException {
    checkMountains(mountains);

    SortedSet<Integer> results = new TreeSet<>();

    boolean asc = false;
    boolean desc = false;
    AtomicInteger mountainCounter = new AtomicInteger(0);

    for (int i = 0; i < mountains.length; i++) {

      if(i == mountains.length-1){
        if(isThereAMountain(mountainCounter) && desc){
          results.add(mountainCounter.incrementAndGet());
        }
        break;
      }

      if(mountains[i] < mountains[i+1] && (!desc)){
        asc = true;
        mountainCounter.incrementAndGet();
      } else if (mountains[i] > mountains[i+1] && (asc || desc)) {
        asc = false;
        desc = true;
        mountainCounter.incrementAndGet();
      } else {
        if(isThereAMountain(mountainCounter) && desc){
          results.add(mountainCounter.incrementAndGet());
          i--;
        }
        asc = false;
        desc = false;
        mountainCounter.set(0);
      }

    }

    return results.isEmpty() ? 0 : results.last();
  }

  private boolean isThereAMountain(AtomicInteger mountainCounter) {
    return mountainCounter.get() >= 2;
  }

  private void checkMountains(int[] mountains){
    if(mountains.length < 3){
      throw new NotEnoughDataException("There are not enough data in the input");
    }
  }
}
