pipeline {
    agent any

    environment {
        APP_PORT = "9090"
        JAR_FILE = "target/demo-0.0.1-SNAPSHOT.jar"
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

        stage('Test') {
            steps {
                echo "Running Cucumber tests..."
                cucumber buildStatus: 'UNSTABLE',
                    reportTitle: 'Report',
                    fileIncludePattern: '**/*.json',
                    trendsLimit: 10,
                    classifications: [
                        [
                            'key': 'Browser',
                            'value': 'Firefox'
                        ]
                    ]
            }
        }


        stage('Deploy') {
            steps {
                echo "Stopping any existing application instance..."
                sh "pkill -f \"$JAR_FILE\" || true"
                echo "Running the new application instance..."
                sh "nohup java -jar $JAR_FILE --server.port=$APP_PORT"
            }
        }
    }
}
