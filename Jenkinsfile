pipeline {
    environment {
    registry = "arunvsdocker/sample_micro_service"
    registryCredential = 'dockerhub_id'
    dockerImage = ''
    }
    agent none
    stages {
        stage('Build') {
        agent {
                node {
                    label 'docker-agent-mvn-jdk17'
                    }
              }
            steps {
                echo "Building.."
                sh '''
                mvn clean package -DskipTests
                '''
            }
        }
        stage('Test') {
        agent {
                node {
                    label 'docker-agent-mvn-jdk17'
                    }
              }
            steps {
                echo "Testing.."
                sh '''
                mvn test
                '''
            }
        }
        stage('Create Docker Image') {
        agent {
            node{
                label 'agent_jenkins_docker'
            }
        }
            steps {
            script {
                echo 'Building Docker....'
                dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('Running Docker') {
        agent {
                    node{
                        label 'agent_jenkins_docker'
                    }
                }
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