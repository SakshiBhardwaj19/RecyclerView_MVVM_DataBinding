package com.example.recyclerviewmvvm.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewmvvm.R
import com.example.recyclerviewmvvm.data.User
import com.example.recyclerviewmvvm.databinding.RecyclerViewUserBinding

/**
 * Adapter to bind user in recyclerview
 */
class UsersAdapter(private val users: List<User>, private val userViewModel: UsersViewModel) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.recycler_view_user,
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user=users[position]
        holder.recyclerviewUserBinding.user = user

        holder.recyclerviewUserBinding.root.setOnClickListener {
            userViewModel.onUserClicked(user)
        }
    }

    override fun getItemCount() = users.size


    inner class UserViewHolder(
        val recyclerviewUserBinding: RecyclerViewUserBinding
    ) : RecyclerView.ViewHolder(recyclerviewUserBinding.root)

}