/* Given a two dimensional matrix representing a map, 1 = water, 0 = land and 9 = treasure
It is guaranteed that there is exactly one treasure on the map. You are travelling on a ship, and 
are not allowed to navigate on land. Return the coordinate of the treasure or, if unreachable, null.

Solution makes use of a breadth first search approach.
*/

import java.util.*;

public class IslandBFS extends Object {

    static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x; this.y = y;
        }

        @Override
        public boolean equals(Object co) {
            Coordinate c = (Coordinate) co;

            if(c.x == this.x && c.y == this.y) return true;
            else return false;
        }
    }

    public static Coordinate findTreasure(int[][] grid) {
        List<Coordinate> visited = new ArrayList<>();
        List<Coordinate> queue = new LinkedList<Coordinate>();

        queue.add(new Coordinate(0, 0));
        while(!queue.isEmpty()) {
            Coordinate c = queue.get(0);
            queue.remove(0);
            if(contains(visited, c) || grid[c.x][c.y] == 0) continue;
            if(grid[c.x][c.y] == 9) return c;

            visited.add(c);
            if(c.x != 0) queue.add(new Coordinate(c.x-1, c.y));
            if(c.y != 0) queue.add(new Coordinate(c.x, c.y-1));
            if(c.x != grid.length - 1) queue.add(new Coordinate(c.x+1, c.y));
            if(c.y != grid[0].length - 1) queue.add(new Coordinate(c.x, c.y+1));
            }

        return null;
        }


    private static boolean contains(List<Coordinate> list, Coordinate c2) {
        for(Coordinate c1 : list)
            if(c1.equals(c2)) return true;
        return false;
    }

    // GIVEN A MAP, YOU CAN ONLY WALK ON 1'S AND NEED TO REACH 9. RETURN THE MINIMUM NUMBER OF STEPS
    public static void main(String... args) {
        long time = System.currentTimeMillis() ;
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 1, 1, 1},
                {1, 1, 1, 0, 0, 9, 1},
                {0, 0, 1, 0, 0, 1, 1}
        };
        Coordinate treasure = findTreasure(grid);
        System.out.println(System.currentTimeMillis() - time);
        System.out.println(treasure.x + " " + treasure.y);
    }
}
