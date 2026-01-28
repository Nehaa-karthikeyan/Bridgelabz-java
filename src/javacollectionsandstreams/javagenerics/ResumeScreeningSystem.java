package javacollectionsandstreams.javagenerics;

import java.util.*;

abstract class JobRole {
    abstract void screen();
}

class SoftwareEngineer extends JobRole {
    void screen() {
        System.out.println("Screening Software Engineer Resume");
    }
}

class Resume<T extends JobRole> {
    T role;

    Resume(T role) {
        this.role = role;
    }

    void process() {
        role.screen();
    }

    static void bulkScreen(List<? extends JobRole> roles) {
        for (JobRole role : roles) {
            role.screen();
        }
    }
}

public class ResumeScreeningSystem {
    public static void main(String[] args) {
        Resume<SoftwareEngineer> resume =
                new Resume<>(new SoftwareEngineer());
        resume.process();
    }
}

