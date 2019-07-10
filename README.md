# Spring REST using RSQL/FIQL
Example integrating RSQL/FIQL in Spring REST

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

# technology stack
- spring boot
- spring mvc
- spring data jpa
- hibernate
- H2
- spring boot test
- cz.jirutka.rsql

# thoughts of improvements
- move integration tests to separate profile
- improve integration test performance -> spring context is is started several times
- add mocked tests
