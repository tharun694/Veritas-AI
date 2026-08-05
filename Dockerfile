# Step 1: Use the light Java 17 image you just downloaded
FROM eclipse-temurin:17-jre-alpine

# Step 2: Set a working directory inside the container
WORKDIR /app

# Step 3: Copy your compiled .jar file into the container
# Replace 'your-app-name.jar' with the actual name in your target folder
COPY target/*.jar app.jar

# Step 4: Tell the container how to run your app
ENTRYPOINT ["java", "-jar", "app.jar"]