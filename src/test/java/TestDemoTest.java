import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class TestDemoTest {
    private TestDemo testDemo;

    @BeforeEach
    void setUp() {
        testDemo = new TestDemo();
    }

    // Tests the addPositive method with various parameter combinations
    @ParameterizedTest
    @MethodSource("argumentsForAddPositive")
    void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
        if (!expectException) {
            assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
        } else {
            assertThatThrownBy(() -> testDemo.addPositive(a, b))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    // Provides arguments for the parameterized test of addPositive method
    private static Stream<Arguments> argumentsForAddPositive() {
        return Stream.of(
                arguments(2, 4, 6, false),
                arguments(-2, 4, 0, true),
                arguments(0, 4, 0, true)
                // We can add more test if needed 
        );
    }

    // Tests the randomNumberSquared method by mocking the getRandomInt method
    @Test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo mockDemo = spy(testDemo);
        doReturn(5).when(mockDemo).getRandomInt();
        int fiveSquared = mockDemo.randomNumberSquared();
        assertThat(fiveSquared).isEqualTo(25);
    }
}

