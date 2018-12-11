import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by JK on 2018-12-11.
 */
public class ArraysGenerator {

    public Integer[][] getProperPuzzles(int n) {
        int numberOfPuzzles = (int) ((Math.pow(n, 2)));

        Integer[] arrayWithNumbers = IntStream.range(0, numberOfPuzzles).boxed().toArray(Integer[]::new);

        Integer[][] puzzles = new Integer[n][];

        int index = 0;
        for (int i = 0; i < numberOfPuzzles; i += n) {
            puzzles[index] = Arrays.copyOfRange(arrayWithNumbers, i, i + n);
            index++;
        }

        return puzzles;

    }

    public Integer[][] getMixedPuzzles(int n) {
        int numberOfPuzzles = (int) ((Math.pow(n, 2)));

        Integer[] arrayWithNumbers = IntStream.range(0, numberOfPuzzles).boxed().toArray(Integer[]::new);

        List<Integer> list = Arrays.asList(arrayWithNumbers);
        Collections.shuffle(list);
        Integer[] arrayWithShuffledNumbers = (Integer[]) list.toArray();

        Integer[][] puzzles = new Integer[n][];

        int index = 0;
        for (int i = 0; i < numberOfPuzzles; i += n) {
            puzzles[index] = Arrays.copyOfRange(arrayWithShuffledNumbers, i, i + n);
            index++;
        }

        return puzzles;

    }

}
