package suraiya.my.id.notesapi

import jakarta.persistence.*

@Entity(name = "notes")

data class Notes(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")  // Primary key for Notes
        val id: Int,

        @Column(name = "title")
        val title: String,

        @Column(name = "description")
        val description: String,
        @Column(name = "userID")
        val userId:Int
                )
