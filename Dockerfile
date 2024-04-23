FROM openjdk

WORKDIR app

COPY target/employeemanagement-0.0.1-SNAPSHOT.war /app/employeemanagement.war

EXPOSE 8080

CMD ["java", "-jar", "employeemanagement.war"]