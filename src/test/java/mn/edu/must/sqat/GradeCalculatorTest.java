package mn.edu.must.sqat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GradeCalculatorTest {

    // --- letterGrade: typical values ---

    @Test
    @DisplayName("95 оноо A дүн байх ёстой")
    void ninetyFiveIsA() {
        GradeCalculator calc = new GradeCalculator(); // Arrange
        String grade = calc.letterGrade(95.0);         // Act
        assertEquals("A", grade);                        // Assert
    }

    @Test
    @DisplayName("85 оноо B дүн байх ёстой")
    void eightyFiveIsB() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(85.0);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("30 оноо F дүн байх ёстой")
    void thirtyIsF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(30.0);
        assertEquals("F", grade);
    }

    // --- letterGrade: boundary values ---

    @Test
    @DisplayName("90 оноо яг A дүн байх ёстой (хязгаарын тохиолдол)")
    void ninetyIsExactlyA() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(90.0);
        assertEquals("A", grade);
    }

    @Test
    @DisplayName("89.99 оноо B дүн байх ёстой (хязгаараас доогуур)")
    void eightyNinePointNineNineIsB() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(89.99);
        assertEquals("B", grade);
    }

    @Test
    @DisplayName("60 оноо яг D дүн байх ёстой (хязгаарын тохиолдол)")
    void sixtyIsExactlyD() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(60.0);
        assertEquals("D", grade);
    }

    @Test
    @DisplayName("59.99 оноо F дүн байх ёстой (хязгаараас доогуур)")
    void fiftyNinePointNineNineIsF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(59.99);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("0 оноо F дүн байх ёстой (доод хязгаар)")
    void zeroIsF() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(0.0);
        assertEquals("F", grade);
    }

    @Test
    @DisplayName("100 оноо A дүн байх ёстой (дээд хязгаар)")
    void hundredIsA() {
        GradeCalculator calc = new GradeCalculator();
        String grade = calc.letterGrade(100.0);
        assertEquals("A", grade);
    }

    // --- letterGrade: invalid input ---

    @Test
    @DisplayName("-1 оноо IllegalArgumentException шидэх ёстой")
    void negativeScoreThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    @DisplayName("101 оноо IllegalArgumentException шидэх ёстой")
    void aboveHundredThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    // --- totalScore: typical + invalid ---

    @Test
    @DisplayName("Хязгаар дотор бүх компонент өгөхөд зөв нийлбэр гарна")
    void totalScoreWithValidComponents() {
        GradeCalculator calc = new GradeCalculator();
        double total = calc.totalScore(10, 40, 10, 10, 30);
        assertEquals(100.0, total);
    }

    @Test
    @DisplayName("Ирц сөрөг утгатай бол IllegalArgumentException шидэх ёстой")
    void negativeAttendanceThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(-5, 40, 10, 10, 30));
    }

    @Test
    @DisplayName("Лабын оноо дээд хязгаараас хэтэрвэл IllegalArgumentException шидэх ёстой")
    void labAboveMaxThrows() {
        GradeCalculator calc = new GradeCalculator();
        assertThrows(IllegalArgumentException.class,
                () -> calc.totalScore(10, 41, 10, 10, 30));
    }
}