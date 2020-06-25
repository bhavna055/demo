# Pagination and Sorting

GET /employees

``` 
http://localhost:8080/api/v1/employees?sort=id&size=10&page=0 
```

Response
```
{
  "content": [
    {
      "id": 1,
      "empName": "Chahil",
      "department": "ccd",
      "role": "a"
    },
    {
      "id": 2,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 3,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 4,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 5,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 6,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 7,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 8,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 9,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 10,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "offset": 0,
    "pageSize": 10,
    "pageNumber": 0,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalElements": 78,
  "totalPages": 8,
  "number": 0,
  "size": 10,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "numberOfElements": 10,
  "first": true,
  "empty": false
}
```

GET /employees Desc Order

``` 
http://localhost:8080/api/v1/employees?sort=id,desc&size=10&page=0 
```
Resonse
```
{
  "content": [
    {
      "id": 78,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 77,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 76,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 75,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 74,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 73,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 72,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 71,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 70,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    },
    {
      "id": 69,
      "empName": "bhavna",
      "department": "ccd",
      "role": "manager"
    }
  ],
  "pageable": {
    "sort": {
      "sorted": true,
      "unsorted": false,
      "empty": false
    },
    "offset": 0,
    "pageSize": 10,
    "pageNumber": 0,
    "unpaged": false,
    "paged": true
  },
  "last": false,
  "totalElements": 78,
  "totalPages": 8,
  "number": 0,
  "size": 10,
  "sort": {
    "sorted": true,
    "unsorted": false,
    "empty": false
  },
  "numberOfElements": 10,
  "first": true,
  "empty": false
}
```
