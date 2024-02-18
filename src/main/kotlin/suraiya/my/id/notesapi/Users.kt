package suraiya.my.id.notesapi

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
class Users(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id : Int,
        @Column(name = "name")
        var name : String,
        @Column(name = "username")
        var username : String,
        @Column(name = "password")
        var password : String
           )