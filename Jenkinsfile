node {


   def commit_id
   def dockerImageName = 'anilskp/springpostgres'


   stage('Checkout and Maven Build') {
     	docker.image('maven:latest').inside {
	        echo 'Git Checkout..'        
	        checkout scm
	        echo 'Build'
	        sh "chmod -R 0755 ./"
		writeFile file:'settings.xml', text:"<settings><localRepository>${pwd()}/.m2repo</localRepository></settings>"
	       // sh 'mvn clean package -U'
		sh 'mvn -B -s settings.xml clean install'
        }
    }


   stage('docker build/push') {
     docker.withRegistry('https://index.docker.io/v1/', 'dockerhub') {
       //def app = docker.build("anilskp/springpostgres", '.')
       def app = docker.build("${dockerImageName}",'.')
       app.push("${commit_id}")
       app.push("latest")
     }
   }

   stage('Cleanup Running Containers') {
    	sh "docker rm -f springpostgres || true"
    }
    stage('Deploy') {
    	docker.withRegistry('https://registry.hub.docker.com', "dockerhub") {
			sh "docker run -d --name springpostgres -p 8888:8080  ${dockerImageName}"
		}
    }
	
}

