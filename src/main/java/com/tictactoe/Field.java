package com.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Field {
    private final Map<Integer, Sign> field;

    public Field() {
        field = new HashMap<>();
        field.put(0, Sign.EMPTY);
        field.put(1, Sign.EMPTY);
        field.put(2, Sign.EMPTY);
        field.put(3, Sign.EMPTY);
        field.put(4, Sign.EMPTY);
        field.put(5, Sign.EMPTY);
        field.put(6, Sign.EMPTY);
        field.put(7, Sign.EMPTY);
        field.put(8, Sign.EMPTY);
    }

    public Map<Integer, Sign> getField() {
        return field;
    }

    public int getEmptyFieldIndex() {
        int cross = field.entrySet().stream()
                .filter(e -> e.getValue() == Sign.CROSS)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);

        int emp = field.entrySet().stream()
                .filter(e -> e.getValue() == Sign.EMPTY)
                .map(Map.Entry::getKey)
                .findFirst().orElse(-1);

        if (emp == -1) {
            return -1;
        }


        if(field.get(0) == Sign.NOUGHT && field.get(1) == Sign.NOUGHT && field.get(2) == Sign.EMPTY){
            return 2;
        }
        if(field.get(2) == Sign.NOUGHT && field.get(1) == Sign.NOUGHT && field.get(0) == Sign.EMPTY){
            return 0;
        }

        if(field.get(0) == Sign.NOUGHT && field.get(2) == Sign.NOUGHT && field.get(1) == Sign.EMPTY){
            return 1;
        }

        if(field.get(3) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(5) == Sign.EMPTY){
            return 5;
        }
        if(field.get(4) == Sign.NOUGHT && field.get(5) == Sign.NOUGHT && field.get(3) == Sign.EMPTY){
            return 3;
        }
        if(field.get(5) == Sign.NOUGHT && field.get(3) == Sign.NOUGHT && field.get(4) == Sign.EMPTY){
            return 4;
        }


        if(field.get(6) == Sign.NOUGHT && field.get(7) == Sign.NOUGHT && field.get(8) == Sign.EMPTY){
            return 8;
        }
        if(field.get(7) == Sign.NOUGHT && field.get(8) == Sign.NOUGHT && field.get(6) == Sign.EMPTY){
            return 6;
        }
        if(field.get(8) == Sign.NOUGHT && field.get(6) == Sign.NOUGHT && field.get(7) == Sign.EMPTY){
            return 7;
        }
        if(field.get(0) == Sign.NOUGHT && field.get(3) == Sign.NOUGHT && field.get(6) == Sign.EMPTY){
            return 6;
        }
        if(field.get(3) == Sign.NOUGHT && field.get(6) == Sign.NOUGHT && field.get(0) == Sign.EMPTY){
            return 0;
        }
        if(field.get(6) == Sign.NOUGHT && field.get(0) == Sign.NOUGHT && field.get(3) == Sign.EMPTY){
            return 3;
        }
        if(field.get(1) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(7) == Sign.EMPTY){
            return 7;
        }
        if(field.get(4) == Sign.NOUGHT && field.get(7) == Sign.NOUGHT && field.get(1) == Sign.EMPTY){
            return 1;
        }
        if(field.get(7) == Sign.NOUGHT && field.get(1) == Sign.NOUGHT && field.get(4) == Sign.EMPTY){
            return 4;
        }
        if(field.get(2) == Sign.NOUGHT && field.get(5) == Sign.NOUGHT && field.get(8) == Sign.EMPTY){
            return 8;
        }
        if(field.get(5) == Sign.NOUGHT && field.get(8) == Sign.NOUGHT && field.get(2) == Sign.EMPTY){
            return 2;
        }
        if(field.get(8) == Sign.NOUGHT && field.get(2) == Sign.NOUGHT && field.get(5) == Sign.EMPTY){
            return 5;
        }
        if(field.get(0) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(8) == Sign.EMPTY){
            return 8;
        }
        if(field.get(4) == Sign.NOUGHT && field.get(8) == Sign.NOUGHT && field.get(0) == Sign.EMPTY){
            return 0;
        }
        if(field.get(8) == Sign.NOUGHT && field.get(0) == Sign.NOUGHT && field.get(4) == Sign.EMPTY){
            return 4;
        }

        if(field.get(2) == Sign.NOUGHT && field.get(4) == Sign.NOUGHT && field.get(6) == Sign.EMPTY){
            return 6;
        }
        if(field.get(4) == Sign.NOUGHT && field.get(6) == Sign.NOUGHT && field.get(2) == Sign.EMPTY){
            return 2;
        }
        if(field.get(6) == Sign.NOUGHT && field.get(2) == Sign.NOUGHT && field.get(4) == Sign.EMPTY){
            return 4;
        }


        if (field.get(4) == Sign.EMPTY) {
            return 4;
        }
        if (field.get(4) == Sign.NOUGHT){
            //peroneNextStep
            if(field.get(1) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(7) == Sign.EMPTY){
                return 7;
            }
            if(field.get(5) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(0) == Sign.CROSS && field.get(3) == Sign.EMPTY){
                return 3;
            }
            if(field.get(7) == Sign.CROSS && field.get(0) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(1) == Sign.EMPTY){
                return 1;
            }
            if(field.get(3) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(5) == Sign.EMPTY){
                return 5;
            }

            //peroneRes
            if(field.get(1) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }
            if(field.get(1) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(3) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
            if(field.get(3) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(0) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }
            if(field.get(1) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
            if(field.get(0) == Sign.CROSS && field.get(1) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            if(field.get(3) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(3) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            //perone
            if(field.get(7) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(1) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            if(field.get(9) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }
            if(field.get(1) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
            if(field.get(3) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }
            if(field.get(5) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(3) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
            if(field.get(0) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }


            //trian
            if(field.get(1) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            if(field.get(5) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(3) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }
            if(field.get(1) == Sign.CROSS && field.get(3) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
            // zig
            if(field.get(8) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(7) == Sign.EMPTY){
                return 7;
            }
            if(field.get(0) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(1) == Sign.EMPTY){
                return 1;
            }
            if(field.get(2) == Sign.CROSS && field.get(6) == Sign.CROSS && field.get(1) == Sign.EMPTY){
                return 1;
            }


            if(field.get(2) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(5) == Sign.EMPTY){
                return 5;
            }
            if(field.get(6) == Sign.CROSS && field.get(0) == Sign.CROSS && field.get(3) == Sign.EMPTY){
                return 3;
            }

            // straight
            if(field.get(0) == Sign.CROSS && field.get(1) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            if(field.get(1) == Sign.CROSS && field.get(2) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
            if(field.get(2) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(8) == Sign.CROSS && field.get(5) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            if(field.get(8) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }
            if(field.get(6) == Sign.CROSS && field.get(7) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(6) == Sign.CROSS && field.get(3) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
            if(field.get(0) == Sign.CROSS && field.get(3) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }



        }

        //cross in middle
        if(field.get(4) == Sign.CROSS){
            if(field.get(4) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            if(field.get(2) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(5) == Sign.EMPTY){
                return 5;
            }
            if(field.get(2) == Sign.CROSS && field.get(8) == Sign.CROSS && field.get(5) == Sign.EMPTY){
                return 5;
            }

            if(field.get(0) == Sign.CROSS && field.get(8) == Sign.EMPTY){
                return 8;
            }
            if(field.get(1) == Sign.CROSS && field.get(7) == Sign.EMPTY){
                return 7;
            }
            if(field.get(2) == Sign.CROSS && field.get(6) == Sign.EMPTY){
                return 6;
            }
            if(field.get(3) == Sign.CROSS && field.get(5) == Sign.EMPTY){
                return 5;
            }
            if(field.get(5) == Sign.CROSS && field.get(3) == Sign.EMPTY){
                return 3;
            }
            if(field.get(6) == Sign.CROSS && field.get(2) == Sign.EMPTY){
                return 2;
            }
            if(field.get(7) == Sign.CROSS && field.get(1) == Sign.EMPTY){
                return 1;
            }
            if(field.get(8) == Sign.CROSS && field.get(0) == Sign.EMPTY){
                return 0;
            }
        }

        if (field.get(4) == Sign.NOUGHT && field.get(0) == Sign.EMPTY) {
            return 0;
        }
        if (field.get(4) == Sign.NOUGHT && field.get(8) == Sign.EMPTY) {
            return 8;
        }
        return emp;
    }

    public List<Sign> getFieldData() {
        return field.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public Sign checkWin() {
        List<List<Integer>> winPossibilities = List.of(
                List.of(0, 1, 2),
                List.of(3, 4, 5),
                List.of(6, 7, 8),
                List.of(0, 3, 6),
                List.of(1, 4, 7),
                List.of(2, 5, 8),
                List.of(0, 4, 8),
                List.of(2, 4, 6)
        );

        for (List<Integer> winPossibility : winPossibilities) {
            if (field.get(winPossibility.get(0)) == field.get(winPossibility.get(1))
                && field.get(winPossibility.get(0)) == field.get(winPossibility.get(2))) {
                return field.get(winPossibility.get(0));
            }
        }
        return Sign.EMPTY;
    }
}