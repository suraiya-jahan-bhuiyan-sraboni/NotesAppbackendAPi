package suraiya.my.id.notesapi

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class NoteService(@Autowired val userRepository : UserRepository, @Autowired val notesRepository : NotesRepository) {

}