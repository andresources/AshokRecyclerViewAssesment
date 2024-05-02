package com.assesment

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.assesment.databinding.ItemEmailBinding

class MailAdapter(private val mails: List<MailDetails>) :
    RecyclerView.Adapter<MailAdapter.MailViewHolder>() {
    private lateinit var binding: ItemEmailBinding
    inner class MailViewHolder(private val localBinding: ItemEmailBinding) : RecyclerView.ViewHolder(localBinding.root){
        fun bindData(mailDetails: MailDetails,position: Int){
            with(localBinding){
                txtSender.text = mailDetails.sender
                txtTitle.text = mailDetails.title
                txtBody.text = mailDetails.body
                txtTime.text = TimeAgo.getTimeAgo(mailDetails.time)
                if(position%2==0){
                    imgUser.setImageResource(R.drawable.img2)
                }else{
                    imgUser.setImageResource(R.drawable.andimg)
                }
                btnPopup.setOnClickListener {
                    val popUpMenu = PopupMenu(
                        btnPopup.context,
                        btnPopup
                    )
                    popUpMenu.menuInflater.inflate(
                        R.menu.pop_up_menu,
                        popUpMenu.menu
                    )
                    popUpMenu.setOnMenuItemClickListener {
                        when (it.itemId) {
                            R.id.mango -> Toast.makeText(btnPopup.context,"Mango",Toast.LENGTH_SHORT).show()
                            R.id.kiwi -> Toast.makeText(btnPopup.context,"Kiwi",Toast.LENGTH_SHORT).show()
                        }
                        true
                    }

                        popUpMenu.show()

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MailViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        binding =ItemEmailBinding.inflate(layoutInflater,parent,false)
        return MailViewHolder(binding)
    }

    override fun getItemCount(): Int = mails.size

    override fun onBindViewHolder(holder: MailViewHolder, position: Int) {
        val data = mails[position]
        holder.bindData(mails[position],position)
        /*holder.itemView.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context,MailDetailsActivity::class.java)
            intent.putExtra("Data",data)
            context.startActivity(intent)
        }*/
    }


}