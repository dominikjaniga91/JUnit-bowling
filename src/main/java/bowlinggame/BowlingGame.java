package bowlinggame;

public class BowlingGame {

    int score = 0;
    int roll = 0;
    int[] points = new int[22];

    public int getScore() {
        int frames = 10;
        int coursor = 0;

        for (int i = 0; i < frames; i++) {
            if (points[coursor] == 10) {
                score += 10 + points[coursor + 1] + points[coursor + 2];
                coursor++;
            } else if (points[coursor] + points[coursor + 1] == 10) {
                score += 10 + points[coursor + 2];
                coursor += 2;
            } else {
                score += points[coursor] + points[coursor + 1];
                coursor += 2;
            }
        }

        return score;
    }

    public void roll(int pins) {
        points[roll++] = pins;
    }
}
