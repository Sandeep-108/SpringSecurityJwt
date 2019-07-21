curl for create token

POST /login HTTP/1.1
Host: localhost:8080
Content-Type: application/json
{
	"mobileNo":"sandy",
	"id":"12"
}

curl for validation
POST /send HTTP/1.1
Host: localhost:8080
Authorization: eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzYW5keSIsInVzZXJJZCI6IjEyIn0.6mmZrLZ4E-OzQY--JUiIzAsbhyxrP-Qhzd6J0yqtwHfa2CogvEQeHSCPjrMXKBMBRZHVQ9e_NX_qBG1XstXQ1A
