package suraiya.my.id.notesapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/users/")
class UserController(@Autowired val service : UserService) {
/*     @GetMapping("getAll")
    fun getAllUser() : ArrayList<UserResponse> {
        val userList : List<Users> = service.getAllUser()
        val responseList : ArrayList<UserResponse> = arrayListOf()
        userList.forEach { users ->
            responseList.add(UserResponse(users))
        }
        return responseList
    } */

    @PostMapping("RegisterUser")
    fun registerUser(@RequestBody users : Users) : String {
        return service.registerUser(users)
    }

    @PostMapping("loginUser")
    fun loginUser(@RequestBody loginResponse : UserloginResponse) : UserResponse {
        return UserResponse(service.loginUser(loginResponse.username, loginResponse.password))
    }

    @PutMapping("resetPassword")
    fun updatePassword(@RequestParam userName : String, @RequestBody password : Password) : String {
        return service.resetPassword(userName, password)
    }

    @DeleteMapping("deleteUser")
    fun deleteUser(@RequestParam id : Int) : String {
        return service.deleteUser(id)
    }

    @PostMapping("createNote")
    fun createNoteUser(@RequestBody noteRequest : Notes) : Notes? {
        return service.addNoteUser(noteRequest)
    }

    @PostMapping("NotesList")
    fun getUserNotes(@RequestParam userId : Int) : ResponseEntity<List<Notes>> {
        val notes = service.getUserNotes(userId)
        return ResponseEntity.ok(notes)
    }

    @PostMapping("DeleteAllNotes")
    fun deleteAllNotes(@RequestParam userId : Int) : String {
        return service.deleteAllNotes(userId)
    }

    @PostMapping("DeleteSingleNotes")
    fun deleteSingleNotes(@RequestParam id : Int, @RequestParam userId : Int) : String {
        return service.deleteSingleNotes(id, userId)
    }

    @PutMapping("updateSingleNotes")
    fun updateNotes(@RequestBody noteRequest : Notes) : Notes? {
        return service.updateSingleNote(noteRequest)
    }
}