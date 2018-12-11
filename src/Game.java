import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by JKowalczyk on 2018-12-11.
 */
public class Game {
    public void astar(Integer[][] start, Integer[][] end) {
        PuzzleHolder path = null;
        List<Integer[][]> startList = new ArrayList<>();
        startList.add(start);
        PuzzleHolder puzzleHolder = new PuzzleHolder(heuristic(start), startList);

        List<PuzzleHolder> front = new ArrayList<>();
        front.add(puzzleHolder);

        List<Integer[][]> expanded = new ArrayList<>();
        int expandedNodes = 0;

        while (!front.isEmpty()) {
            int i = 0;
            if (front.size() != 1) {
                for (int j = 1; j < front.size(); j++) {
                    if (front.get(i).getDistance() > front.get(j).getDistance()) {
                        i = j;
                    }
                }
            }

            path = front.get(i);
            path.getPuzzles().forEach(integers -> {
                System.out.println(Arrays.deepToString(integers));
            });


            List<PuzzleHolder> holderListCopy = new ArrayList<>(front);
            front = front.subList(0, i);
            front.addAll(holderListCopy.subList(i + 1, holderListCopy.size()));

            Integer[][] endnode = path.getPuzzles().get(path.getPuzzles().size() - 1);

            if (Arrays.deepToString(endnode).equals(Arrays.toString(end))) {
                break;
            }
            if (contains(expanded, endnode)) {
                continue;
            }

            for (Integer[][] k : moves(endnode)) {
                if (contains(expanded, k)) {
                    continue;
                }
                List<Integer[][]> newPaths = new ArrayList<>(path.getPuzzles());
                newPaths.add(k);
                PuzzleHolder newPathHolder = new PuzzleHolder((path.getDistance() + heuristic(k) - heuristic(endnode)), newPaths);
                front.add(newPathHolder);
                expanded.add(endnode);
            }
            expandedNodes += 1;
        }
        System.out.println(expandedNodes);
//        path.getPuzzles().forEach(integers -> {
//            Arrays.stream(integers).forEach(ints -> System.out.println(Arrays.deepToString(ints)));
//        });
        System.out.println();

    }

    public double heuristic(Integer[][] puzzles) {
        double distance = 0;
        for (int i : IntStream.rangeClosed(0, 3).toArray()) {
            for (int j : IntStream.rangeClosed(0, 3).toArray()) {
                if (puzzles[i][j] == 0) {
                    continue;
                }
                distance += Math.abs(i - new Double(puzzles[i][j]) / 4) + Math.abs(j - (puzzles[i][j] % 4));
            }
        }
        return distance;
    }

    public List<Integer[][]> moves(Integer[][] puzzles) {
        List<Integer[][]> output = new ArrayList<>();

        int i = 0;
        while (!Arrays.asList(puzzles[i]).contains(0)) {
            i += 1;
        }

        int j = Arrays.asList(puzzles[i]).indexOf(0);

        if (i > 0) {
            int newup = puzzles[i - 1][j];
            int newdown = puzzles[i][j];

            puzzles[i][j] = newup;
            puzzles[i - 1][j] = newdown;

            output.add(getCopyOfPuzzles(puzzles));

            newup = puzzles[i - 1][j];
            newdown = puzzles[i][j];

            puzzles[i][j] = newup;
            puzzles[i - 1][j] = newdown;
        }

        if (i < 3) {
            int newUp = puzzles[i + 1][j];
            int neDown = puzzles[i][j];

            puzzles[i][j] = newUp;
            puzzles[i + 1][j] = neDown;

            output.add(getCopyOfPuzzles(puzzles));

            newUp = puzzles[i + 1][j];
            neDown = puzzles[i][j];

            puzzles[i][j] = newUp;
            puzzles[i + 1][j] = neDown;

        }

        if (j > 0) {
            int newLeft = puzzles[i][j - 1];
            int newRight = puzzles[i][j];

            puzzles[i][j] = newLeft;
            puzzles[i][j - 1] = newRight;

            output.add(getCopyOfPuzzles(puzzles));

            newLeft = puzzles[i][j - 1];
            newRight = puzzles[i][j];

            puzzles[i][j] = newLeft;
            puzzles[i][j - 1] = newRight;

        }

        if (j < 3) {
            int newLeft = puzzles[i][j + 1];
            int newRight = puzzles[i][j];

            puzzles[i][j] = newLeft;
            puzzles[i][j + 1] = newRight;

            output.add(getCopyOfPuzzles(puzzles));

            newLeft = puzzles[i][j + 1];
            newRight = puzzles[i][j];

            puzzles[i][j] = newLeft;
            puzzles[i][j + 1] = newRight;
        }

        return output;
    }

    private Integer[][] getCopyOfPuzzles(Integer[][] puzzles) {
        Integer[][] puzzlesCopy = new Integer[puzzles.length][puzzles[0].length];
        for (int k = 0; k < puzzles.length; k++)
            for (int l = 0; l < puzzles[k].length; l++)
                puzzlesCopy[k][l] = puzzles[k][l];
        return puzzlesCopy;
    }

    public boolean contains(List<Integer[][]> integers, Integer[][] toCheck) {
        for (Integer[][] checked : integers) {
            if (Arrays.deepToString(checked).equals(Arrays.deepToString(toCheck))) {
                return true;
            }
        }
        return false;
    }

}
