pipeline {
    agent any

    stages {
        stage('Git : Source Code Checkout') {
            steps {
                echo 'Pulling... '
               git branch: 'main',
                url: 'https://github.com/elemejri/projet_kaddem_bi6.git'
            }
        }

        stage('Clean Project with Maven') {
            steps {

                sh 'mvn clean'
            }
        }

        stage('Compile Project with Maven') {
            steps {

                sh 'mvn compile'
            }
        }

        stage('JUNIT-MOCKITO Tests'){
            steps{
                echo'laching units test ...'
                sh 'mvn test'
            }
            post {
                always {
                    junit "**/target/surefire-reports/*.xml"
                }
            }
        }
stage('Nexus Repository Deployment') {
    steps {
        sh 'mvn deploy'
    }
}


 	stage('Build docker image'){
               steps{
                   script{
                       sh 'docker build -t elemejri/kaddem-0.0.1 .'
                   }
               }
           }
   stage('Docker Login') {
               steps {
   				sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u="elemejri" -p="dockerhub" '
   			}
   		}
   	 stage('Push Docker Image to DockerHub') {
                steps {
   		    sh 'docker push elemejri/kaddem-0.0.1 '
   			}
   	    post {
   		always {

   			sh 'docker logout'
   		}
           	}
     }
          	stage('Build and Start Docker Compose') {
                 steps {
                     sh 'docker compose build'
                     sh 'docker compose up -d'
     	    }	}
stage('Start Grafana') {
    steps {
        sh 'docker run -d -p 4005:3000 grafana/grafana'
    }
}

stage('Start Prometheus') {
    steps {
        sh 'docker run -d -p 9096:9090 prom/prometheus'
    }
}
        stage('Email Notification') {
            steps {
                script {
                   mail bcc: '', body: 'test avec sucée ', cc: '', from: '', replyTo: '', subject: 'validation', to: 'mejri.ele@esprit.tn'
                }
            }
        }
    }
}
