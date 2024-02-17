package suraiya.my.id.notesapi

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table( name = "users")
@OnDelete(action = OnDeleteAction.CASCADE)
class Users(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int,
        @Column(name = "name")
         var name: String,
        @Column(name = "username")
         var username: String,
        @Column(name = "password")
         var password: String
        )