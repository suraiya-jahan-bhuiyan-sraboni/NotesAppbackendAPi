package suraiya.my.id.notesapi


class UserResponse(users : Users){
   var id :Int = users.id
     var name : String = users.name
     var username : String = users.username
     var password : String =users.password
}
