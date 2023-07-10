pipeline {
    agent {
        node {
            label 'docker-agent-mvn-jdk17'
            }
      }
    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh '''
                mvn clean package -DskipTests
                '''
            }
        }
        stage('Test') {
            steps {
                echo "Testing.."
                sh '''
                mvn test
                '''
            }
        }
        stage('Create Docker Image') {
            steps {
                echo 'Building Docker....'
                sh '''
                docker build -v /var/run/docker.sock:/var/run/docker.sock -t ajp_lab/sampleMicroService .
                '''
            }
        }
        stage('Running Docker') {
            steps {
                echo 'Running Docker....'
                sh '''
                docker run -v /var/run/docker.sock:/var/run/docker.sock -p 8081:8080 ajp_lab/sampleMicroService -d
                '''
            }
        }
    }
}