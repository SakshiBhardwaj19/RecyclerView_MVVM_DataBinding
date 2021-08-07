package com.example.recyclerviewmvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.recyclerviewmvvm.IAppConstants
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.data.User
import com.example.recyclerviewmvvm.databinding.ActivityUserDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        binding=DataBindingUtil.setContentView(this,R.layout.activity_user_detail)

        binding.user=intent.getParcelableExtra(IAppConstants.INTENT_KEY_USER)



    }
}