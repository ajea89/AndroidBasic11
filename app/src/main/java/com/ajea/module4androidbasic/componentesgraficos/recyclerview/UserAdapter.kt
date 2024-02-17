package com.ajea.module4androidbasic.componentesgraficos.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints.LayoutParams
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.ajea.module4androidbasic.R
import com.squareup.picasso.Picasso
import java.util.ArrayList

class UserAdapter(private val list: ArrayList<User>) : RecyclerView.Adapter<UserViewHolder>() {

    var onItemSelected : ((User) -> Unit)? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item_user, parent, false)
        return UserViewHolder(view)
    }
    override fun getItemCount(): Int  = list.size
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.render(list[position], onItemSelected)
    }
}

class UserViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val ivUser = view.findViewById<ImageView>(R.id.ivUser)
    val tvUser = view.findViewById<TextView>(R.id.tvUser)
    val root = view.findViewById<ConstraintLayout>(R.id.root)
    val card = view.findViewById<CardView>(R.id.card)

    fun render(user:User, onItemSelected : ((User) -> Unit)?){
        tvUser.text = user.email
//        ivUser.setImageResource(R.drawable.img_placeholder)
//        ivUser.setImageDrawable(ContextCompat.getDrawable(tvUser.context, R.drawable.img_placeholder))

        if (user.imageUrl.isNotEmpty()){
            Picasso.get().load(user.imageUrl)
                .error(R.drawable.img_placeholder)
                .placeholder(R.drawable.img_logo)
                .into(ivUser)
        }

        //tvUser.typeface = ResourcesCompat.getFont(tvUser.context, R.font.bernier_shade_regular)

        root.setOnClickListener {
            onItemSelected?.invoke(user)
        }
    }
}