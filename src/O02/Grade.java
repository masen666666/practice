package O02;

public enum Grade {
    HD(80), D(70), CR(60), P(50), N(0);
    private final int lowerBound;

    Grade(int lowerBound) {
        this.lowerBound = lowerBound;
    }


    public static Grade fromMark(int mark) {
        for (Grade g : Grade.values()) {  // enum
            if (mark >= g.lowerBound) // compare mark with Grade lowerBound then return Grade
                return g;  //return enum value  HD / D /CR/P
        }
        return N;
    }

    public static void main(String[] args) {
//        Grade kk=Grade.fromMark(88);
        System.out.println(Grade.fromMark(88));

        }

    }


