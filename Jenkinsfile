node {


   def commit_id
   def dockerImageName = 'anilskp/springcassandra'


   stage('Checkout and Maven Build') {
     	docker.image('maven:latest').inside {
	        echo 'Git Checkout..'        
	        checkout scm
	        echo 'Build'
	        sh "chmod -R 0755 ./"
	        sh 'mvn clean package -U'
        }
    }


}

