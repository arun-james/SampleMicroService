pipeline {
    agent {
        node {
            label 'docker-agent-alpine'
            }
      }
    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh '''
                mvn clean install -DskipTests
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
                echo 'Deliver....'
                sh '''
                echo "Creating docker image"
                '''
            }
        }
    }
}