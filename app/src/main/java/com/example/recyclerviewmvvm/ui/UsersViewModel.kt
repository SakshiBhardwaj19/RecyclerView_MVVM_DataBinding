package com.example.recyclerviewmvvm.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvm.data.User
import com.example.recyclerviewmvvm.data.UsersRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import javax.inject.Singleton

@HiltViewModel
class UsersViewModel @Inject constructor(private val usersRepository: UsersRepository) : ViewModel(){

    private val _users:MutableLiveData<List<User>> = MutableLiveData()
    val users:LiveData<List<User>>
        get() = _users

    private val _user:MutableLiveData<User> = MutableLiveData()
    val user:LiveData<User>
        get() = _user



    /**
     * Function to get users
     */
    fun getUsers(){
        val users=usersRepository.getUsers();
        _users.value=users
    }

    fun onUserClicked(user: User){
        _user.value=user
    }



}