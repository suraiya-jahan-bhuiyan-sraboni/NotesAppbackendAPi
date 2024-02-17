package suraiya.my.id.notesapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val repository : UserRepository,@Autowired val notesRepository : NotesRepository) {
    fun getAllUser() : MutableList<Users> = repository.findAll()

    fun registerUser(user : Users): String {
        if(repository.findByUsername(user.username)?.username!=null){
            return "User Exists"
        }else{
        if((!user.name.isEmpty()) && (!user.password.isEmpty()) && (!user.username.isEmpty())) {
            repository.save(user)
            return "Registration Successful"
        }
        return "Registration Unsuccessful"
        }
    }
    fun loginUser(username:String, password:String):Users{
        return repository.findByUsernameAndPassword(username,password)
    }
    fun deleteUser(id:Int):String{
        repository.deleteById(id)
        return "Deleted Successfully"
    }
    fun addNoteUser(noteRequest: Notes): Notes?{
        val user: Users = repository.findById(noteRequest.userId).get()
        if (user.username.isNotEmpty() && noteRequest.title.isNotEmpty()){
            return notesRepository.save(noteRequest)
        }
        return null
    }

    fun getUserNotes(userId: Int): List<Notes> {
        return notesRepository.findByUserId(userId)
    }
}