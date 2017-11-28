# mybatis-spring-paging
This sample is for paging using mybatis, spring and thymeleaf.  
The paging needs when a large amount of data matches the search criteria,  

## Draft API

- Page.java
  - The Page.java has PageInformation and search result.  
  - An application can be used objects of Page.java as return values to a screen. 
- PageConditon.java  
  - An application can be specified pageNo and pageSize.
- PageInformation.java
  - An application can be handled paging information.(e.g. totalPage, totalRecords)
