# Use the official Python image from the DockerHub
FROM python:3.9-slim

# Set the working directory in docker
WORKDIR /app

# Install the requests library
RUN pip install requests

# Copy the content of the local src directory to the working directory
COPY ./src/app.py .

# Specify the command to run on container start
CMD ["python", "./app.py"]
