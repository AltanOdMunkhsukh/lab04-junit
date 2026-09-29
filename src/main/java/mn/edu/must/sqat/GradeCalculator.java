package mn.edu.must.sqat;

public class GradeCalculator {

    public String letterGrade(double score) {
        if (score < 0 || score > 100) {
            throw new IllegalArgumentException("Score must be between 0 and 100: " + score);
        }
        if (score >= 90) return "A";
        if (score >= 80) return "B";
        if (score >= 70) return "C";
        if (score >= 60) return "D";
        return "F";
    }

    public double totalScore(double att, double lab, double quiz1, double quiz2, double exam) {
        validateComponent(att, 10, "attendance");
        validateComponent(lab, 40, "lab/coursework");
        validateComponent(quiz1, 10, "quiz1");
        validateComponent(quiz2, 10, "quiz2");
        validateComponent(exam, 30, "exam");

        return att + lab + quiz1 + quiz2 + exam;
    }

    private void validateComponent(double value, double max, String name) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be negative: " + value);
        }
        if (value > max) {
            throw new IllegalArgumentException(name + " cannot exceed " + max + ": " + value);
        }
    }
}