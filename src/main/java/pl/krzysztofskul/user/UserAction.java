package pl.krzysztofskul.user;

public enum UserAction {
        REGISTER {
            @Override
            public String toString() {
                return "REGISTERED";
            }
        },
        EMAIL_CONFIGURATION {
            @Override
            public String toString() {
                return "EMAIL CONFIGURATION SET";
            }
        },
        LOG_IN {
            @Override
            public String toString() {
                return "LOGGED IN";
            }
        },
        PROJECT_CREATE {
            @Override
            public String toString() {
                return "CREATED NEW PROJECT";
            }
        },
        PROJECT_DELETE {
            @Override
            public String toString() {
                return "DELETED PROJECT";
            }
        },
        DEMO_MODE_START {
            @Override
            public String toString() {
                return "DEMO MODE START";
            }
        },
        DEMO_MODE_OFF {
            @Override
            public String toString() {
                return "DEMO MODE OFF";
            }
        }
    }