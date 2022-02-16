package pl.krzysztofskul.project;

public enum  StatusProject {

	STATUS_PROJECT_0("0", "AKWIZYCJA / ACQUISITION"),
	STATUS_PROJECT_1("1", "PLANOWANIE INSTALACJI / PRELIMINARY PLANNING"),
	STATUS_PROJECT_2("2", "OPRACOWYWANIE WYTYCZNYCH / FINAL PLANNING"),
	STATUS_PROJECT_3("3", "ADAPTACJA POMIESZCZEŃ / ROOMS ADAPTATION"),
	STATUS_PROJECT_4("4", "DOSTAWA URZĄDZEŃ / DEVICES DELIVERY"),
	STATUS_PROJECT_5("5", "INSTALACJA URZĄDZEŃ / DEVICES INSTALLATION"),
	STATUS_PROJECT_6("6", "URUCHOMIENIE / START UP"),
	STATUS_PROJECT_7("7", "SZKOLENIA / TRAININGS"),
	STATUS_PROJECT_8("8", "ZAKOŃCZONY / FINISHED"),
	STATUS_PROJECT_9("9", "ANULOWANY / CANCELLED");

	
	public String code;
	public String name;
	
	StatusProject(String code, String name){
		this.code = code;
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	};
	
	
	
	
//    STATUS_PROJECT_0 {
//        private String name = "AKWIZYCJA / ACQUISITION";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_1 {
//        private String name = "PLANOWANIE INSTALACJI / PRELIMINARY PLANNING";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_2 {
//        private String name = "OPRACOWYWANIE WYTYCZNYCH / FINAL PLANNING";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_3 {
//        private String name = "ADAPTACJA POMIESZCZEŃ / ROOMS ADAPTATION";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_4 {
//        private String name = "DOSTAWA URZĄDZEŃ / DEVICES DELIVERY";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_5 {
//        private String name = "INSTALACJA URZĄDZEŃ / DEVICES INSTALLATION";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_6 {
//        private String name = "URUCHOMIENIE / START UP";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_7 {
//        private String name = "SZKOLENIA / TRAININGS";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_8 {
//        private String name = "ZAKOŃCZONY / FINISHED";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    },
//
//    STATUS_PROJECT_9 {
//        private String name = "ANULOWANY / CANCELLED";
//        public String code;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        @Override
//        public String toString() {
//            return name;
//        }
//    }

    
    
}