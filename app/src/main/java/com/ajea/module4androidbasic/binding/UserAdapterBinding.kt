package com.ajea.module4androidbasic.binding

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ajea.module4androidbasic.R
import com.ajea.module4androidbasic.componentesgraficos.recyclerview.User
import com.ajea.module4androidbasic.databinding.RecyclerviewItemUserBinding
import com.squareup.picasso.Picasso

class UserAdapterBinding(private val list: ArrayList<User>) : RecyclerView.Adapter<UserViewHolderBinding>() {

    var onItemSelected : ((User) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolderBinding {
        val binding = RecyclerviewItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolderBinding(binding)
    }
    override fun getItemCount(): Int  = list.size
    override fun onBindViewHolder(holder: UserViewHolderBinding, position: Int) {
        holder.bind(list[position], onItemSelected)
    }
}

/**
 * RecyclerviewItemUserBinding as parameter in viewHolder to use binding.root in ViewHolder constructor
 * **/
class UserViewHolderBinding(val binding : RecyclerviewItemUserBinding) : RecyclerView.ViewHolder(binding.root){
    fun bind(user:User, onItemSelected : ((User) -> Unit)?){
        //We can use binding(this is pass in our constructor) to use every component in our layout like tvUser, ivUser or root
        binding.tvUser.text = user.email

        if (user.imageUrl.isNotEmpty()){
            Picasso.get().load(user.imageUrl)
                .error(R.drawable.img_placeholder)
                .placeholder(R.drawable.img_logo)
                .into(binding.ivUser)
        }

        binding.root.setOnClickListener {
            onItemSelected?.invoke(user)
        }
    }
}