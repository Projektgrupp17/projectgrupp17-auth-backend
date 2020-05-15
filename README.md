# projectgrupp17-auth-backend
auth service for iot project using JWT
implemented with spring

Unit testing with Junit and Mockito.

Integration testing using SpringBoot test tools.

![Java CI with Gradle](https://github.com/krummelur/projectgrupp17-auth-backend/workflows/Java%20CI%20with%20Gradle/badge.svg?branch=master)


## Purpose
Provides secure user creation authentication based on token and refreshToken flow.

### User creation:
* New users can be created (see the api documentation). Passwords are stored as salted hashes.

### User authentication mechanism:
* A short lived token along with an ID of a long lived refresh-token is provided on authentication.

* A server requiring identity verification can use the public key to verify the permissons and valididty of the token.

* A client with an outdated refresh token can get a new short-lived refresh token by supplying the outdated access-token along with a refresh-token.

The default access level is **user**.


## Endpoints

### Default
**URL:** / (get) 

**DESCRIPION:** get api version.

**RESULTSUCCESS:** API version string

**RESULTERROR:** NONE

### Register 
**URL:** /register/    (post)

**DESCRIPTION:** Registers a new user, body:

**BODY:**
```
{
username: <username>,
email: <email>,
password: <password>,
agency: <an existing agency>
}
```
**RESULTSUCCESS:** 201

**RESULTERROR:** 400 on invalid username/email/password, or the username/email exists

### Login
**URL:** auth/login (post)

**DESCRIPTION:** Logs in an existing user, body:

**BODY:**
```
{
email: <email>,
password: <password>,
}
```
**RESULTSUCCESS:** 201 Returns a refresh-token id, and an short-lived accesstoken.

**RESULTERROR:** 400 on missing userdata 

**RESULTERROR:** 401 on bad password/username combination

### Logout
**URL:** auth/logout (post)

**DESCRIPTION:** Logs out an existing user, destroying the refresh token, headers:

**HEADERS:**
```
* Auth-Token: <JWT-access-token>,
* Refresh-Token: <refresh-token-id>
```
**RESULTSUCCESS:** Always 200 when refresh token is sent

**RESULTERROR:** 400 if the refresh-token is missing

### Refresh
**URL:** auth/refresh

**DESCRIPTION:** Gets a new access-token from an expired access-token and non-expired refresh-token, headers:
```
- Auth-Token: <JWT-access-token>,
- Refresh-Token: <refresh-token-id>
```
**RESULTSUCCESS:** A short-lived JWT access token.

**RESULTERROR:** 400 if missing headers

**RESULTERROR:** 401 with explanation on invalid/expired/etc. tokens


# build
* gradle build - builds and tests app and checks for test coverage.

## Environment
* AUTH_IOT_ENVIRONMENT: PRODUCTION|TEST 
#### production
* SQL_USERNAME: username for database
* SQL_PASSWORD: password for database
* SQL_HOST: mysql host
* SQL_DB_NAME: database name
