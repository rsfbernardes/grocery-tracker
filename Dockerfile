# ---------- Build Stage ----------
FROM maven:3.9.6-amazoncorretto-21 AS build
WORKDIR /app

# Copy POM first and download dependencies (cached layer)
COPY pom.xml .
RUN mvn -q -B dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build without compiling or running tests
RUN mvn -q -Dmaven.test.skip=true package


# ---------- Runtime Stage ----------
FROM amazoncorretto:21-alpine AS runtime
WORKDIR /app

# Add secure non-root user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copy only the final fat jar
COPY --from=build /app/target/*.jar app.jar

# Adjust permissions
RUN chown appuser:appgroup app.jar
USER appuser

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
