package calculator;

import main.Main;
import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static main.Main.arrayFromRange;
import static org.assertj.core.api.Assertions.assertThat;

//////////////////////////////////// ВАРІАНТ 1
public class CalculatorTest {
    Double beginRange = 0.0;
    Double endRange = 3.0;
    Double step = 0.004;
    @ParameterizedTest
    @CsvSource({"0.7, 1.0", "1.4, -0.329", "3, 0.214"})
    void testCheckCalc(double actual, double expectedNum) {
        assertThat(Main.calc(actual))
                .isCloseTo(expectedNum, Percentage.withPercentage(1.0));
    }
    @Test
    void testCheckStepsByRange() {
        int expectedNum = 750;
        assertThat(Main.calcStepsByRange(beginRange, endRange, step)).isEqualTo(expectedNum);
    }
    @Test
    void testCheckArrayFromRangeByLength() {
        int expectedLength = 750;
        assertThat(arrayFromRange(beginRange, endRange, step).length).isEqualTo(expectedLength);
    }
    @Test
    void testCheckArrayByMinValue() {
        Double expectedValue = -0.47026166327744007;
        assertThat(Main.findMinValue(arrayFromRange(beginRange,endRange,step))).isEqualTo(expectedValue);
    }
    @Test
    void testCheckArrayByMaxValue() {
        Double expectedValue = 1.0;
        assertThat(Main.findMaxValue(arrayFromRange(beginRange,endRange,step))).isEqualTo(expectedValue);
    }
    //116.89288902380378
    @Test
    void testCheckSumArrayValues() {
        Double expectedValue = 116.89288902380378;
        assertThat(Main.sumArrayValues(arrayFromRange(beginRange,endRange,step))).isEqualTo(expectedValue);
    }
    @Test
    void testCheckArithmeticMeanOfArrayValues() {
        Double expectedValue = 0.1558571853650717;
        assertThat(Main.arithmeticMeanOfArrayValues(arrayFromRange(beginRange,endRange,step))).isEqualTo(expectedValue);
    }
}
