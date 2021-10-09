# LinkShortener  

<br/>

## UML
https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=link-shortener-uml.drawio#Uhttps%3A%2F%2Fdrive.google.com%2Fuc%3Fid%3D1aJHRVMyybg_d6RVno8LgX1PEP-q5Vgl7%26export%3Ddownload

# Requests  

<br/>

## POST: /api/link/post  

<br/>

### Post link to the service  
link: string - url to shorten  
passcode: string - passcode for your link  
timeExcision: int64 - time when link will expire (in unixtime), null if link won't expire  
```json
{ 
  	"link": "https://www.unixtimestamp.com/",  
	"passcode": "1234",
  	"timeExcision": 32847284287 
}
```
  

link: string - url to shorten  
passcode: string - passcode for your link  
timeExcision: int64 - time when link will expire (in unixtime), null if link won't expire  
userAccessData.login: string - user login  
userAccessData.password: string - user password  
```json
{
	"link": "https://www.unixtimestamp.com/",
	"passcode": "1234",
 	"timeExcision": 1633702947,
  	"userAccessData": 
  	{
    		"login": "1EaoKA",	
    		"password": "0000"
  	}
}
```
  
  
### Response (200)
shortLink: string - short link to pass to .../{shortLink} to redirect to original link  
timeExcision: int64 - time in unixtime when the link will expire  
```json
{
	"shortLink": "47K8aNS",
	"timeExcision": 342743472
}
```
  
### Errors:
- 400 - Invalid excision time
- 404 - User not found (wrong login)
- 403 - Access denied (wrong login or password)


<br/><br/>

## DELETE: /api/link/delete  

<br/>

### Delete your link from the service  
shortLink: string - short link to to delete  
userAccessData.login: string - user login  
userAccessData.password: string - user password  
```json
{
	"shortLink": "47K8aNS",
  	"userAccessData": 
  	{
    		"login": "1EaoKA",
	    	"password": "0000"
  	}
}
```
  

### Response (200)
```json
{
	"deleted": true
}
```

### Errors:
- 404 - User not found (wrong login)
- 404 - Link not found (wrong link shortLink)
- 403 - Access denied (wrong login or password, given user is not owner)

<br/><br/>

## POST: /api/user/signUp

<br/>

### Register user  
username: string - user name  
password: string - user password  
```json
{
  	"username": "vitya",
  	"password": "0000"
}
```

### Response (200)
userLogin: string - user login to use as a part of UserAccessData  
```json
{
	"userLogin": "1EaoKA"
}
```

### Errors:
- No errors


<br/><br/>

## PUT: /api/user/changePassword

<br/>

### Change user password
newPassword: string - new user password  
userAccessData.login: string - user login  
userAccessData.password: string - user password  
```json
{
	"userAccessData":
	{
		"login": "1EaoKA",
		"password": "0000"
	},
	"newPassword": "1111"
}
```

### Response
```json
{
	"changed": true
}
```

### Errors:
- 404 - User not found (wrong login)
- 403 - Access denied (wrong login or password, given user is not owner)
