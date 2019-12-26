pipeline {
  //Donde se va a ejecutar el Pipeline
  agent {
    label 'Slave_Induccion'
  }

  //Opciones especÃ­ficas de Pipeline dentro del Pipeline
  options {
    	buildDiscarder(logRotator(numToKeepStr: '3'))
 	disableConcurrentBuilds()
  }

  //Una secciÃ³n que define las herramientas \u201Cpreinstaladas\u201D en Jenkins
  tools {
    jdk 'JDK8_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
    gradle 'Gradle5.6_Centos' //Preinstalada en la ConfiguraciÃ³n del Master
  }

  //AquÃ­ comienzan los \u201Citems\u201D del Pipeline
  stages{
  

	stage('Checkout'){
		steps{
			echo "------------>Checkout<------------"
				checkout([
					$class: 'GitSCM', 
					branches: [[name: '*/master']], 
					doGenerateSubmoduleConfigurations: false, 
					extensions: [], 
					gitTool: 'Git_Centos', 
					submoduleCfg: [], 
					userRemoteConfigs: [[
					credentialsId: 'GitHub_SebastianLondonoCB', 
					url:'https://github.com/SebastianLondonoCB/ADN-Ceiba.git'
				]]
			])
		}
	}
	
	stage('Compile & Unit Tests') {
		steps{
			echo "------------>Clean Tests<------------"
			sh 'gradle --b ./cinema/infraestructura/build.gradle clean'
			echo "------------>Unit Tests<------------"
			sh 'gradle --b ./cinema/infraestructura/build.gradle test'
		}
	}
	

	stage('Static Code Analysis') {
		steps{
			echo '------------>Análisis de código estático<------------'
			withSonarQubeEnv('Sonar') {
				sh "${tool name: 'SonarScanner', type:'hudson.plugins.sonar.SonarRunnerInstallation'}/bin/sonar-scanner"
			}
		}
	}

	stage('Build') {
		steps{
			echo "------------>Build<------------"
			//Construir sin tarea test que se ejecutó previamente
			sh 'gradle --b ./cinema/infraestructura/build.gradle test'
		}
	}
  }

	post {
		failure {
			echo 'This will run only if failed'
			mail (to: 'sebastian.londono@ceiba.com.co',subject: "Failed Pipeline:${currentBuild.fullDisplayName}",body: "Something is wrong with ${env.BUILD_URL}")
		}
		
		success {
			echo 'This will run only if successful'
			junit 'cinema/infraestructura/build/test-results/test/*.xml' 
		}
	}
}
