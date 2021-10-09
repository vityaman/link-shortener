# LinkShortener

# Requests

## POST: /api/link/post

### Post link to the service

```json
{
	// string - url to shorten
  "link": "https://www.unixtimestamp.com/",  

	// string - passcode for your link
	"passcode": "1234",

	// int64 - time when link will expire (in unixtime), 
	//         null if link won't expire
  "timeExcision": 32847284287 
}
```

```json
{
	// string - url to shorten
  "link": "https://www.unixtimestamp.com/",

	// string - passcode for your link
	"passcode": "1234",

	// int64 - time when link will expire (in unixtime), 
	//         null if link won't expire
  "timeExcision": 1633702947,

  "userAccessData": 
  {
		// string - user login
    "login": "1EaoKA",

		// string - user password
    "password": "0000"
  }
}
```

### Response (200)

```json
{
	// string - short link to pass to .../{shortLink} to redirect to original link
  "shortLink": "47K8aNS",

	// int64 - time in unixtime when the link will expire
  "timeExcision": 342743472
}
```

### Errors:

- 400 - Invalid excision time
- 404 - User not found (wrong login)
- 403 - Access denied (wrong login or password)

## DELETE: /api/link/delete

### Delete your link from the service

```json
{
	// string - short link to to delete
  "shortLink": "47K8aNS",

  "userAccessData": 
  {
		// string - your login
    "login": "1EaoKA",

		// string - your password
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

## POST: /api/user/signUp

### Register user

```json
{
	// string - user name
  "username": "vitya",

	// string - user password
  "password": "0000"
}
```

### Response (200)

```json
{
	// string - user login to use as a part of UserAccessData
	"userLogin": "1EaoKA"
}
```

### Errors:

- No errors

## PUT: /api/user/changePassword

### Change user password

```json
{
	"userAccessData":
	{
		// string - user login
		"login": "1EaoKA",

		// string - user password
		"password": "0000"
	},
	
	// string - new user password
	"newPassword": "1111"
}
```

### Response

```json
{
	"changed": true;
}
```

### Errors:

- 404 - User not found (wrong login)
- 403 - Access denied (wrong login or password, given user is not owner)
