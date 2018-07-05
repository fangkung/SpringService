# Spring Service
Test for create generic DAO using Spring Boot and Hibernate

## Table of Contents
* [File Structure](#file-structure)

### File Structure
```
SpringService/
 ├──src/                                                      * our source files
 │   └──main
 │       ├──java.com.bporamin
 │       │   ├──common.dao
 │       │   |   ├──GenericDao.java                           * Interface generic dao class.
 │       │   │   └──GenericDaoImpl.java                       * Imprementation generic dao class.
 │       │   └──configuration
 │       │       └──HibernateConfiguration.java               * Hibernate configuration class.
 │       └──recources
 │           └──application.properties                        * Application and hibernate variables are configured here.
 └──pom.xml                                                   * What maven uses to manage it's dependencies.
```

___

## License
 [MIT](/LICENSE)
