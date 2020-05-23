package pl.krzysztofskul.user;

public enum UserAction {
        REGISTER {
            @Override
            public String toString() {
                return "REGISTERED";
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
    }