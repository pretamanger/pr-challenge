package com.pret.friend.tree.data

import com.pret.friend.tree.abstractions.User
import org.springframework.stereotype.Component

@Component
class DataComponent {
    fun users()= setOf(
        User(1, "Alicia Keys"),
        User(2, "John Wick"),
        User(3, "Debbie Harry"),
        User(4, "Porter Robinson"),
        User(5, "Stephen Fry"),
        User(6, "Gandalf Grey"),
        User(7, "Billy Ocean"),
        User(8, "Fred Perry"),
        User(9, "Elvis Presley"),
        User(10, "Reese Witherspoon")
    )

    fun friendships()=setOf(
        1 to 5,
        2 to 4,
        9 to 10,
        2 to 3,
        6 to 3,
        8 to 10,
        8 to 4,
        3 to 1,
        10 to 5,
        2 to 7,
        4 to 9,
        5 to 3,
        2 to 9
    )
}