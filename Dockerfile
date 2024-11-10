FROM openjdk:21-jdk-oraclelinux8
COPY target/employeeManagement-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT [ "java","-jar","/application.jar" ]
