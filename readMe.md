
Postman:
获取token：
POST http://localhost:5000/oauth/token
Headers: 
  Authorization: Basic U2FtcGxlQ2xpZW50SWQ6c2VjcmV0
Body: 
  grant_type: password
  username: admin
  password: admin
获取资源：
GET http://localhost:9090/foo
Headers: 
  Authorization: bearer 4ceb67a9-5905-4398-a8ac-f22aace1ba08

