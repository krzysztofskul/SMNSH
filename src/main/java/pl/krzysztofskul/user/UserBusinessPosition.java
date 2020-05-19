package pl.krzysztofskul.user;

public enum UserBusinessPosition {
    ADMIN {
        @Override
        public String toString() {
            return "ADMINI / ADMIN";
        }
    },
    PLANNER {
        @Override
        public String toString() {
            return "Projektant/Planista / Designer/Planner";
        }
    },
    PROJECT_MANAGER {
        @Override
        public String toString() {
            return "Kierownik projektu / Project Manager";
        }
    },
    SALES_REP {
        @Override
        public String toString() {
            return "Przedstawiciel handlowy / Sales rep.";
        }
        public String toStringPL() {
            return "Przedstawiciel handlowy";
        }
        public String toStringEN() {
            return "Sales rep.";
        }
    }
}