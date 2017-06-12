#project brief
weather simulator will return 10 fixed cities weather report which city name, position columns are fixed and others are random based on latitude and time of the year. also for better performance, introduce caching with 5 seconds refresh on weather report.

#how to run
1. switch to weather simulator root folder
2. mvn spring-boot:run

#how to access
GET http://hostname:8088/weather/report

#properties
//cache period, by default 5 second
spring.cache.caffeine.spec=expireAfterWrite=5s 

/*depend on client, line separator will make report have correct line break on each entry
for example, if client is browser, set it to <br/>. if it's curl, leave it empty and application will use system line separator.
*/
line-separator=<br/> 

#how to pass properties when boot up
mvn spring-boot:run -Drun.arguments="--line-separator=,--spring.cache.caffeine.spec=expireAfterWrite=10s"

#algorithm to populate report data
1. condition
	if city in north hemisphere and latitude greater than 30 and month between 1-3 or 10-12
	or in south hemisphere and latitude less than -40 and month between 6-8 
	there will be snow condition. for rest of world and months, no snow
2. temperature
	if condition is rain, temperature is between 5-15
	if condition is sunny, temperature is between 16-45
	if condition is snow, temperature is between -5--45
3. pressure
	if condition is rain, pressure is between 1000-1099
	if condition is sunny, pressure is between 900-990
	if condition is snow, pressure is between 1100-1200
4. humidity
	if condition is rain, humidity is between 71-99
	if condition is sunny, humidity is between 10-30
	if condition is snow, humidity is between 31-70
	
