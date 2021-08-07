package com.example.recyclerviewmvvm.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewmvvm.util.IAppConstants
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.databinding.ActivityUsersBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_users.*

@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUsersBinding
    private val userViewModel by viewModels<UsersViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding=DataBindingUtil.setContentView(this,R.layout.activity_users);
        binding.userViewModel=userViewModel

        userViewModel.getUsers();
        userViewModel.users.observe(this, { users->

            rlUsers.also {
                it.layoutManager = GridLayoutManager(this, 2)
                it.setHasFixedSize(true)
                it.adapter = UsersAdapter(users,userViewModel)

                userViewModel.user.observe(this,{user->

                   val intent= Intent(this,UserDetailActivity::class.java).apply {
                       putExtra(IAppConstants.INTENT_KEY_USER,user)
                   }
                    startActivity(intent)

                })
            }

        })

    }
}