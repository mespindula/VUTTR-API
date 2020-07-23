# VUTTR-API
Very Useful Tools to Remember

# Para obter Token
    POST /sign-up Content-Type: application/json
    {
     username = cliente
     password = 123
    }
    
# Para realizar Build/Deploy Maven
	mvn clean install
	mvn dockerfile:push
	
# Swagger
	http://localhost:3000/swagger-ui.html
	
# Docker
	https://hub.docker.com/r/mespindula/vuttr-api
	docker run -it -p 3000:3000 mespindula/vuttr-api:0.0.1-SNAPSHOT