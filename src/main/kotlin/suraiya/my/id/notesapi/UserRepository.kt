package suraiya.my.id.notesapi

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<Users, Int> {
    fun findByUsername(username : String) : Users?
    fun findByUsernameAndPassword(username : String, password : String) : Users

}