package pl.krzysztofskul.user;

public enum UserBusinessPosition {
    PLANNER {
        @Override
        public String toString() {
            return "Planner";
        }
    },
    PROJECT_MANAGER {
        @Override
        public String toString() {
            return "Project Manager";
        }
    };
}
