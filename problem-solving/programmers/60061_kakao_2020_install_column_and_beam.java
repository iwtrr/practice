// https://school.programmers.co.kr/learn/courses/30/lessons/60061

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        Set<Structure> results = new HashSet<>();
        for (int[] command : build_frame) {
            Structure structure = new Structure(command);
            if (command[3] == 0) {
                results.remove(structure);
                if (!validateResults(results, structure)) {
                    results.add(structure);
                }
            } else if (command[3] == 1 && canExist(results, structure)) {
                results.add(structure);
            }
        }

        return results.stream().sorted(
                        Comparator.comparingInt(Structure::x)
                                .thenComparing(Structure::y)
                                .thenComparing(Structure::type))
                .map(result -> new int[]{result.x, result.y, result.type})
                .toArray(int[][]::new);
    }

    private boolean validateResults(Set<Structure> results, Structure structure) {
        for (Structure result : results) {
            if (!canExist(results, result)) {
                return false;
            }
        }

        return true;
    }

    private boolean canExist(Set<Structure> building, Structure structure) {
        int x = structure.x;
        int y = structure.y;

        if (structure.type == 0) {
            return y == 0
                    || building.contains(new Structure(x, y - 1, 0))
                    || building.contains(new Structure(x - 1, y, 1))
                    || building.contains(new Structure(x, y, 1));
        } else if (structure.type == 1) {
            return building.contains(new Structure(x, y - 1, 0))
                    || building.contains(new Structure(x + 1, y - 1, 0))
                    || (building.contains(new Structure(x - 1, y, 1))
                    && building.contains(new Structure(x + 1, y, 1)));
        }

        return false;
    }

    private record Structure(
            int x, int y, int type
    ) {
        public Structure(int[] command) {
            this(command[0], command[1], command[2]);
        }
    }
}