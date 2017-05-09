public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        String[] extraStr = bowlingCode.split("\\|\\|");
        String[] perblockStr = new String[12];
        String[] temp = extraStr[0].split("\\|");
        for (int i = 0; i < 10; i++) {
            perblockStr[i] = temp[i];
        }
        switch (extraStr.length) {
            case 1 : {
                perblockStr[10] = "--";
                perblockStr[11] = "--";
                break;
            }
            case 2 : {
                switch (extraStr[1].length()) {
                    case 1 : {
                        perblockStr[10] = extraStr[1].charAt(0) + "-";
                        perblockStr[11] = "--";
                        break;
                    }
                    case 2 : {
                        if (extraStr[1].charAt(0) == 'X') {
                            perblockStr[10] = extraStr[1].charAt(0) + "-";
                            perblockStr[11] = extraStr[1].charAt(1) + "-";
                        }
                        else {
                            perblockStr[10] = extraStr[1];
                            perblockStr[11] = "--";
                        }
                        break;
                    }
                }
                break;
            }
        }

        int score = 0;
        for (int i = 0; i < 10; i++) {
            if (perblockStr[i].charAt(0) == 'X') {
                score += 10;
                if (perblockStr[i + 1].charAt(0) == 'X') {
                    score += 10;
                    if (perblockStr[i + 2].charAt(0) == 'X') {
                        score += 10;
                    }
                    else if (perblockStr[i + 2].charAt(0) != '-') {
                        score += perblockStr[i + 2].charAt(0) - 48;
                    }
                }
                else if (perblockStr[i + 1].charAt(1) == '/') {
                    score += 10;
                }
                else {
                    for (int j = 0; j < perblockStr[i + 1].length(); j++) {
                        if (perblockStr[i + 1].charAt(j) != '-') {
                            score += perblockStr[i + 1].charAt(j) - 48;
                        }
                    }
                }
            }
            else if (perblockStr[i].charAt(1) == '/') {
                score += 10;
                if (perblockStr[i + 1].charAt(0) == 'X') {
                    score += 10;
                }
                else if (perblockStr[i + 1].charAt(0) != '-') {
                    score += perblockStr[i + 1].charAt(0) - 48;
                }
            }
            else {
                for (int j = 0; j < perblockStr[i].length(); j++) {
                    if (perblockStr[i].charAt(j) != '-') {
                        score += perblockStr[i].charAt(j) - 48;
                    }
                }
            }
        }
        return score;
    }
}
