package suraiya.my.id.notesapi

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotesRepository : JpaRepository<Notes, Int> {
    fun findByUserId(userId : Int) : List<Notes>
    fun findNotesByUserId(userId : Int) : List<Notes>
    fun deleteNotesByUserId(userId : Int)
    fun deleteByIdAndUserId(id : Int, userId : Int)
}