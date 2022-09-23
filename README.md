# TransactionTask
1) register new user 
POST http://localhost:8080/api/v1/auth/register
{
    "email":"test4@gmail.com",
    "password":"test4"
}


2) login request
POST http://localhost:8080/api/v1/auth/login
{
  "email":"test4@gmail.com",
    "password":"test4"
}

3) withdraw-balance
Authorization Bearer (token)
GET http://localhost:8080/withdraw-balance
