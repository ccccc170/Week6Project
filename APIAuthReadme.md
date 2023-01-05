# API Authentication

## install

ensure application.properties.example is filled in and renamed to application.properties

### setup users

a get request to  http://localhost:8080/api/users/setup

### get api of user 

http://localhost:8080/api/users/[emailAddress]

e.g
http://localhost:8080/api/users/admin@example.com

## example usage

http://localhost:8080/api/employees/10001/[API_KEY]
1. pass api key
2. convert string api to uuid
3. check role via string 
4. throw AuthenticationException

```java
    @PostMapping("/")
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO, @RequestBody String api) throws AuthenticationException {
        UUID apiKey = UUID.fromString(api);
        User user = userRepository.findByApiKey(apiKey).get();

        if (user.getRole().equals("UPDATE") && user.getRole().equals("ADMIN")) {

            return employeeDAO.save(employeeDTO);
        }
//       TODO: return an authentication error
        throw new AuthenticationException("Not authorised");

    }
```