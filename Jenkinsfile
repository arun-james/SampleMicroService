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
        stage('Sonar') {

            steps {
                echo "Analysing Code.."
                sh '''
                mvn sonar:sonar
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
        stage('publish Docker') {

            steps {
            script {
                echo 'publishing Docker....'
                docker.withRegistry( '', registryCredential ) {
                dockerImage.push()
                }
                }
            }
        }
        stage('Run Docker') {

            steps {
            script {
                echo 'Running Docker....'
                sh '''
                docker rm -f sample_microservice
                docker run -p 8083:8080 --network bridge -d --name sample_microservice arunvsdocker/sample_micro_service:$BUILD_NUMBER
                '''
                }
            }
        }
    }
}