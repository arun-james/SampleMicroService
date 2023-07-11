pipeline {
    environment {
    registry = "arunvsdocker/sample_micro_service"
    registryCredential = 'dockerhub_id'
    dockerImage = ''
    }
    agent {
                node{
                    label 'agent_jenkins_docker'
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
            script {
                echo 'Building Docker....'
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Running Docker') {

            steps {
            script {
                echo 'Running Docker....'
                docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
                }
                }
            }
        }
    }
}