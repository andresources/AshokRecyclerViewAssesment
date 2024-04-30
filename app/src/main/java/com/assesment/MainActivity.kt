package com.assesment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assesment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mailAdapter: MailAdapter
    private val mailList = ArrayList<MailDetails>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        prepareDataSet()
        mailAdapter = MailAdapter(mailList)
        with(binding){
            rv.layoutManager = LinearLayoutManager(this@MainActivity)
            rv.adapter = mailAdapter
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    mailList.removeAt(position)
                    mailAdapter.notifyItemRemoved(position)
                    Toast.makeText(this@MainActivity,"Deleted",Toast.LENGTH_SHORT).show()
                }

            }).attachToRecyclerView(rv)
            ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT){
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    val position = viewHolder.adapterPosition
                    mailList.removeAt(position)
                    mailAdapter.notifyItemRemoved(position)
                    Toast.makeText(this@MainActivity,"Archive",Toast.LENGTH_SHORT).show()
                }

            }).attachToRecyclerView(rv)
        }
    }
    fun prepareDataSet(){
        mailList.apply {
            add(
                MailDetails(
                sender = "Facebook",
                title = "You got a friend request",
                body = "This is body text",
                time = 1714460754000,
                isFav = true,
                )
            )
            add(MailDetails(
                sender = "Gmail",
                title = "You got a friend request",
                body = "This is body text",
                time = 1714457154000,
                isFav = false
            ))
            add(MailDetails(
                sender = "Twitter",
                title = "You got a friend request",
                body = "This is body text",
                time = 1714370754000,
                isFav = false
            ))
        }
    }
}