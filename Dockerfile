FROM openjdk
LABEL authors="asyed"

WORKDIR app

COPY target/employeemanagement-0.0.1-SNAPSHOT.war /app/employeemanagement.war

EXPOSE 8081

CMD ["java", "-jar", "employeemanagement.war"]