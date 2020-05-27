package pl.krzysztofskul.project;

public enum  StatusProject {

    STATUS_PROJECT_0 {
        private String name = "AKWIZYCJA / ACQUISITION";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_1 {
        private String name = "PLANOWANIE INSTALACJI / PRELIMINARY PLANNING";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_2 {
        private String name = "OPRACOWYWANIE WYTYCZNYCH / FINAL PLANNING";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_3 {
        private String name = "ADAPTACJA POMIESZCZEŃ / ROOMS ADAPTATION";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_4 {
        private String name = "DOSTAWA URZĄDZEŃ / DEVICES DELIVERY";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_5 {
        private String name = "INSTALACJA URZĄDZEŃ / DEVICES INSTALLATION";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_6 {
        private String name = "URUCHOMIENIE / START UP";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_7 {
        private String name = "SZKOLENIA / TRAININGS";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_8 {
        private String name = "ZAKOŃCZONY / FINISHED";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

    STATUS_PROJECT_9 {
        private String name = "ANULOWANY / CANCELLED";
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    },

}