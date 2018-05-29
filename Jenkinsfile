pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            echo 'Testing the API with Restlet Client Maven plugin'


            withCredentials([
              string(credentialsId: 'RESTLET_CLIENT_LICENSE', variable: 'RESTLET_CLIENT_LICENSE'),
              string(credentialsId: 'CONTACTS_API_KEY', variable: 'CONTACTS_API_KEY')]) {

                // Maven installation declared in the Jenkins "Global Tool Configuration"
                withMaven(maven: 'Maven 3.5.0') {
                  sh "mvn clean test -B \
                     -Dapi_key=\"$CONTACTS_API_KEY\" \
                     -Dselected_environment='restlet-cloud' \
                     -Dtest_file='src/test/resources/contacts_api_tests.json' \
                     -Dlicense_key=\"$RESTLET_CLIENT_LICENSE\""
                }
                echo 'API tested.'
            }
        }
        stage('Deliver') {
            steps {
                sh './jenkins/scripts/deliver.sh'
            }
        }
    }
}