# spring-data-jpa-h2-web-demo
A simple spring boot project with data jpa, h2 and web for demonstation purpose

# usage
|                |Operator                          |Example                         |
|----------------|-------------------------------|-----------------------------|
|Equal To|`==`|`id==1`            |
|Not Equal To|`!=`|`firstName!=Peter`            |
|Greater Than|`=gt=`|`id=gt=1'`            |
|Greater Or Equal To|`=ge=`|`id=ge=1`            |
|Less Than|`=lt=`|`id=lt=2`            |
|Less Or Equal To|`=le=`|`id=le=2`            |
|In|`=in=`|`firstName=in=(Peter,Hannes)`            |
|Not In|`=out=`|`firstName=out=(Peter,Hannes)`            |
|Logical AND|`;`|`id==1;active=1`            |
|Logical OR|`,`|`id==1,active=1`            |
|Logical Group|`()`|`(id==1,id==2);active=1`            |


# thoughts of improvements
- move integration tests to separate profile
- improve integration test performance -> spring context is is started several times
- add mocked tests