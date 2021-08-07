package com.example.recyclerviewmvvm.data

import javax.inject.Inject


class UsersRepository @Inject constructor() {

    /**
     * Function to get dummy users data
     */
    fun getUsers(): List<User>{

       val users=ArrayList<User>()

        var user=User("Rahul",28,"Noida","I am a Software Engineer")
        users.add(user)

        user=User("Ishani",23,"Gurugram", "I am an Architect")
        users.add(user)

        user=User("Saanvi",18,"Delhi", "I am a Product Manager")
        users.add(user)

        user=User("Priyanka",30,"Meerut","I am a Student")
        users.add(user)

        user=User("Ritesh",40,"Gurugram", "I am a Sales Manager")
        users.add(user)

        return users

    }
}