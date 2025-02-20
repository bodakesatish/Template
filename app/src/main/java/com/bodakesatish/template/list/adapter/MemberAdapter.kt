package com.bodakesatish.template.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bodakesatish.domain.model.Member
import androidx.recyclerview.widget.RecyclerView
import com.bodakesatish.template.databinding.ItemMemberBinding

class MemberAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var itemList: List<Member> = emptyList()
    private var onMemberClick: ((Member) -> Unit)? = null
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemMemberBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(holder) {
            is MemberViewHolder -> {
                holder.bind(itemList[position])
            }
        }
    }

    override fun getItemCount(): Int = itemList.size

    fun setData(data: List<Member>) {
        itemList = data
        notifyItemRangeChanged(0, data.size)
    }

    fun setOnClickListener(onMemberClick: ((Member)) -> Unit) {
        this.onMemberClick = onMemberClick
    }

    inner class MemberViewHolder(val binding: ItemMemberBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(member: Member) {
            binding.tvFirstName.text = member.firstName
            binding.tvLastName.text = member.lastName
            binding.tvMobile.text = member.mobile

            itemView.rootView.setOnClickListener {
                onMemberClick?.invoke(member)
            }
        }
    }
}