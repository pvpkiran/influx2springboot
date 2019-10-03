# Influx2Springboot

Quick demo to access Influx 2 via springboot app.  
Features include insert and query  

**Instructions**  
1. Install InfluxDb version 2 via docker  
`docker run --name influxdb -p 9999:9999 quay.io/influxdb/influxdb:2.0.0-alpha`
2. Open http://localhost:9999  
   Create a username, organization and bucket(online-order) 
3. Once logged in, check the Tokens tab and get token(LoadData-->Tokens) and organization id(can be seen in url), add it in properties file  
4. Start the application and hit the endpoints to load data and query
 