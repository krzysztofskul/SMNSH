# First stage: complete build environment
FROM maven:3.5.0-jdk-8-alpine AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package war
RUN mvn clean package



# Second stage: minimal tomcat runtime environment
FROM bitnami/tomcat:9.0

ENV ALLOW_EMPTY_PASSWORD=yes

# copy war from the first stage
COPY --from=builder target/smnsh*.war /opt/bitnami/tomcat/webapps/smnsh.war