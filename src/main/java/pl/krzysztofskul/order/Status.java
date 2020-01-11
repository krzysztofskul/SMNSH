package pl.krzysztofskul.order;

public enum Status {
    ORDERED_WAITING {
        @Override
        public String toString() {
            return "ORDERED/WAITING";
        }
    },
    IN_PROGRESS {
        @Override
        public String toString() {
            return "IN PROGRESS";
        }
    },
    FINISHED {
        @Override
        public String toString() {
            return "FINISHED";
        }
    };
}