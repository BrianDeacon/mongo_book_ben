mongo_book_ben
==============

https://www.youtube.com/watch?v=SKRma7PDW10


Consider the following simplified data model from our business: 

 

User: 

- userId

- zero or more favorite companies 

 

Company: 

- stateId

- name

- zero or more historical documents 

 

Document: 

- docId 

- description 

- filed by exactly one company

 

Design a class structure with data fields that can accommodate this data model. All ID’s are 

assumed to be unique strings.
