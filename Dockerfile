FROM openjdk
MAINTAINER kunwer
WORKDIR /app
COPY target/phonebook.jar /app/phonebook.jar
ENTRYPOINT ["java","-jar","phonebook.jar"]