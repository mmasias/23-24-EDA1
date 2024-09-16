@startuml

Class TreeNode
Class Tree
Class Node
Class List
Class User
Class Food
Class Day
Interface IDataStructure{
+ bool isEmpty()
+ int size()
+ object[] listData() 
}


Main <|-- Day
Main <|-- Food
Main <|-- User
Day <|-- Tree
Food <|-- TreeNode
Day <|--TreeNode
Tree <|--TreeNode
Tree <|-- List
Food <|-- List
Day <|-- List
TreeNode <|-- List
Main <|-- List
List <|--Node
IDataStructure <|- List

@enduml