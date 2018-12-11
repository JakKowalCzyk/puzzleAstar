import java.util.LinkedList;
import java.util.List;

/**
 * Created by JKowalczyk on 2018-12-11.
 */
public class PuzzleGame {

    public static void main(String[] args) {
        List<Integer[]> puzzlesSteps = new LinkedList<>();

        setInput(puzzlesSteps);

        Integer[][] puzzle = puzzlesSteps.toArray(new Integer[0][]);

        List<Integer[]> endPuzzlesSteps = new LinkedList<>();
        endPuzzlesSteps.add(new Integer[]{0, 1, 2, 3});
        endPuzzlesSteps.add(new Integer[]{4, 5, 6, 7});
        endPuzzlesSteps.add(new Integer[]{8, 9, 10, 11});
        endPuzzlesSteps.add(new Integer[]{12, 13, 14, 15});
        Integer[][] end = endPuzzlesSteps.toArray(new Integer[0][]);


        ArraysGenerator arraysGenerator = new ArraysGenerator();

        Integer[][] start2 = arraysGenerator.getMixedPuzzles(4);
        Integer[][] end2 = arraysGenerator.getProperPuzzles(4);


        new Game().astar(puzzle, end);

    }

    private static void setInput(List<Integer[]> puzzlesSteps) {
        puzzlesSteps.add(new Integer[]{1, 2, 6, 3});
        puzzlesSteps.add(new Integer[]{4, 9, 5, 7});
        puzzlesSteps.add(new Integer[]{8, 13, 11, 15});
        puzzlesSteps.add(new Integer[]{12, 14, 0, 10});
    }


}