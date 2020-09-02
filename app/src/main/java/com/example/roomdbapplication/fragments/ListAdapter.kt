package com.example.roomdbapplication.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdbapplication.R
import com.example.roomdbapplication.fragments.list.ListFragmentDirections
import com.example.roomdbapplication.model.User
import kotlinx.android.synthetic.main.item_customer_list_layout.view.*

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_customer_list_layout,parent,false))
    }

    override fun onBindViewHolder(holder: ListAdapter.MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.tv_userId.text = currentItem.id.toString()
        holder.itemView.tv_userFirstName.text = currentItem.firstName.toString()
        holder.itemView.tv_userLastName.text = currentItem.secondName.toString()
        holder.itemView.tv_userAge.text = currentItem.age.toString()

        holder.itemView.rowLayout.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user:List<User>){
        this.userList = user
        notifyDataSetChanged()
    }


    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }
}