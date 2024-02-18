package suraiya.my.id.notesapi

import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService(@Autowired val repository : UserRepository,@Autowired val notesRepository : NotesRepository) {
    fun getAllUser() : MutableList<Users> = repository.findAll()

    fun registerUser(user : Users): String {
        if(repository.findByUsername(user.username)?.username!=null){
            return "User Exists"
        }else{
        if((user.name.isNotEmpty()) && (user.password.isNotEmpty()) && (user.username.isNotEmpty())) {
            repository.save(user)
            return "Registration Successful"
        }
        return "Registration Unsuccessful"
        }
    }
    fun loginUser(username:String, password:String):Users{
        return repository.findByUsernameAndPassword(username,password)
    }
    fun resetPassword(username : String,password : Password):String{
       val user= repository.findByUsername(username)
        if (user!=null){
            repository.save(Users(user.id,user.name,user.username,password.password))
            return "password reset successful! New password is : ${password.password} ! Save it on secure place!"
        }else{
            return "Invalid Request"
        }
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
    @Transactional
    fun deleteAllNotes(userId : Int):String{
        if (notesRepository.findNotesByUserId(userId).isNotEmpty()){
         notesRepository.deleteNotesByUserId(userId)
        return "All notes deleted successfully"
        }else{
            return "Empty Notes List!"
        }
    }
   @Transactional
    fun deleteSingleNotes(id : Int,userId : Int):String{
        if(notesRepository.findById(id).isPresent){
            notesRepository.deleteByIdAndUserId(id, userId)
            return "Deleted!"
        }else{
            return "Invalid Try!"
        }
    }
    fun updateSingleNote(noteRequest : Notes):Notes?{
        val note=notesRepository.findById(noteRequest.id).get()
        if (noteRequest.title.isNotEmpty() && noteRequest.description.isNotEmpty()){
            val update=Notes(note.id,noteRequest.title,noteRequest.description,note.userId)
            return notesRepository.save(update)
        }else{
            return null
        }
    }
}