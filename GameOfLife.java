public class GameOfLife {

    public static void main(String[] args) {
        int X = 10, Y = 10;

        // Setup so example of each rule working
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        System.out.println("Original Generation");
        generateGrid(grid, X, Y);
        System.out.println();
        nextGeneration(grid, X, Y);
    }

    static void generateGrid(int grid[][], int X, int Y){
        for (int a = 0; a < X; a++) {
            for (int b = 0; b < Y; b++) {
                if (grid[a][b] == 0)
                    System.out.print("-");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
    }

    static void nextGeneration(int grid[][], int X, int Y) {
        int[][] next = new int[X][Y];

        for (int a = 1; a < X - 1; a++) {
            for (int b = 1; b < Y - 1; b++) {
                // number of alive neighbours
                int aliveNeighbours = 0;
                for (int c = -1; c <= 1; c++)
                    for (int d = -1; d <= 1; d++)
                        aliveNeighbours += grid[a + c][b + d];

                aliveNeighbours -= grid[a][b];

                // rule 1, underpopulation
                if ((grid[a][b] == 1) && (aliveNeighbours < 2))
                    next[a][b] = 0;

                    // rule 3, overpopulation
                else if ((grid[a][b] == 1) && (aliveNeighbours > 3))
                    next[a][b] = 0;

                    // rule 4, reproduction
                else if ((grid[a][b] == 0) && (aliveNeighbours == 3))
                    next[a][b] = 1;

                    // rule 2, no change
                else
                    next[a][b] = grid[a][b];
            }
        }

        System.out.println("Next Generation");
        for (int a = 0; a < X; a++) {
            for (int b = 0; b < Y; b++) {
                if (next[a][b] == 0)
                    System.out.print("-");
                else
                    System.out.print("X");
            }
            System.out.println();
        }
    }
}
