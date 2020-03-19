package bowlinggame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class BowlingGameTest {

    BowlingGame bowlingGame = new BowlingGame();


    @Test
    void shouldReturn20_WhenOnePinDownEveryTime() {

        doRolls(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
        Assertions.assertThat(bowlingGame.getScore()).isEqualTo(20);
    }

    @Test
    void shouldReturn0_WhenZeroPinsDownEveryTime() {

        doRolls(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Assertions.assertThat(bowlingGame.getScore()).isEqualTo(0);
    }

    @Test
    void shouldReturnProperAmount_whenSpare() {

        doRolls(5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4);
        Assertions.assertThat(bowlingGame.getScore()).isEqualTo(86);
    }

    @Test
    void shouldReturnProperAmount_whenSpareInLastRoll() {

        doRolls(5, 5, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 4);
        Assertions.assertThat(bowlingGame.getScore()).isEqualTo(92);
    }

    @Test
    void shouldReturnStrike() {

        doRolls(10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10);
        Assertions.assertThat(bowlingGame.getScore()).isEqualTo(300);
    }

    @Test
    void shouldReturnStrike_whenRoll10PinsInLastAttempt() {

        doRolls(4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 10, 7, 2);
        Assertions.assertThat(bowlingGame.getScore()).isEqualTo(91);
    }

    private void doRolls(int... rolls) {
        for (int pins : rolls) {
            bowlingGame.roll(pins);
        }
    }
}

