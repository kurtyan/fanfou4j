# fanfou4j  
fanfou sdk for java  

## Usage  

### Create instance of `FanfouClient`  

```java
Authencator usernamePasswordAuthenticator = new UsernamePasswordAuthenticator("username", "password");
FanfouProfile profile = new FanfouProfile(usernamePasswordAuthenticator);
FanfouClient client = new FanfouClient(profile);

```

### Create instance of api request

```java
ListTrendsRequest request = new ListTrendsRequest();
```

### Get api response by calling execute() on FanfouClient against request instance  

```java
ListTrendsResponse response = client.execute(request);
```

## List of Apis

### Account
### User