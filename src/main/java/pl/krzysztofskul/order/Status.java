package pl.krzysztofskul.order;

public enum Status {
    ORDERED_WAITING {
        @Override
        public String toString() {
            return "OCZEKUJE / WAITING";
        }
    },
    IN_PROGRESS {
        @Override
        public String toString() {
            return "W TOKU / IN PROGRESS";
        }
    },
    FINISHED {
        @Override
        public String toString() {
            return "ZAKOŃCZONY / FINISHED";
        }
    };
}