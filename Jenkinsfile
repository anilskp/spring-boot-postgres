node {


   def commit_id


   stage('Checkout and ANT Build') {
     	docker.image('anilskp/qr-ant:1.0').inside {
	        echo 'Git Checkout..'        
	        checkout scm
	        echo 'Build'
	        sh "chmod -R 0755 ./"
	        sh 'mvn clean package -U'
        }
    }


}

