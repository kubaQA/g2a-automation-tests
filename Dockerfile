# Use the official Gradle image with the correct platform
FROM --platform=linux/arm64 gradle:8.0-jdk17 AS builder

# Set the working directory
WORKDIR /app

# Copy all files to the container
COPY . .

# Build the project to download dependencies and compile the code
RUN gradle build --no-daemon --stacktrace --info

# Use a Selenium image that supports ARM architecture
FROM --platform=linux/arm64 selenium/standalone-chrome:4.22.0-20240621

# Set the working directory
WORKDIR /app

# Copy the build artifacts from the builder stage
COPY --from=builder /app /app

# Expose the display port for GUI applications
ENV DISPLAY=:99

# Set the entry point to run tests with Gradle
ENTRYPOINT ["gradle", "test", "--no-daemon"]
