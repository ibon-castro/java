pipeline {
    agent any

    environment {
        APP_PORT = "9090"  // Match this to the port configured in application.properties
        JAR_FILE = "target/demo-0.0.1-SNAPSHOT.jar"  // Replace with the actual JAR file path
    }

    stages {
        stage('Clean') {
            steps {
                echo "Cleaning the project..."
                sh 'mvn clean'
            }
        }

        stage('Build') {
            steps {
                echo "Building the Spring Boot application..."
                sh 'mvn install'
            }
            post {
                success {
                    archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
                }
            }
        }

        stage('Deploy') {
            steps {
                echo "Stopping any existing application instance..."
                sh "pkill -f \"$JAR_FILE\" || true"
                echo "Running the new application instance..."
                sh "nohup java -jar $JAR_FILE --server.port=$APP_PORT &"
            }
        }
    }
}
