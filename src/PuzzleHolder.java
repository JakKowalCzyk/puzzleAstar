import java.util.ArrayList;
import java.util.List;

/**
 * Created by JKowalczyk on 2018-12-11.
 */
class PuzzleHolder {

    private double distance;
    private List<Integer[][]> puzzles = new ArrayList<>();

    public PuzzleHolder() {
    }

    public PuzzleHolder(double distance, List<Integer[][]> puzzles) {
        this.distance = distance;
        this.puzzles = puzzles;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Integer[][]> getPuzzles() {
        return puzzles;
    }

    public void setPuzzles(List<Integer[][]> puzzles) {
        this.puzzles = puzzles;
    }
}

