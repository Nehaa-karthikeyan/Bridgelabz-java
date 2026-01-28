package javacollectionsandstreams.javagenerics;

abstract class CourseType {
    abstract void evaluate();
}

class ExamCourse extends CourseType {
    void evaluate() {
        System.out.println("Exam-based Evaluation");
    }
}

class Course<T extends CourseType> {
    T course;

    Course(T course) {
        this.course = course;
    }

    void startEvaluation() {
        course.evaluate();
    }
}

public class UniversityCourseSystem {
    public static void main(String[] args) {
        Course<ExamCourse> course = new Course<>(new ExamCourse());
        course.startEvaluation();
    }
}

