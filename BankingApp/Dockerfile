FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
COPY --from=maven-build /build/target/BankingApp.jar app.jar
EXPOSE 8080
ENTRYPOINT ["/usr/bin/java", "-jar", "app.jar"]