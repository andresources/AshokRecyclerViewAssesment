package com.assesment

import abhishek.pathak.recyclerviewdemos.decorators.CustomBackgroundItemDecorator
import abhishek.pathak.recyclerviewdemos.decorators.FirstNLastItemDecorator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.LayoutAnimationController
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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
            btnLinear.setOnClickListener {
                rv.layoutManager = LinearLayoutManager(this@MainActivity)
                rv.adapter = mailAdapter
            }
            btnGrid.setOnClickListener {
                rv.layoutManager = GridLayoutManager(this@MainActivity,2)
                rv.adapter = mailAdapter
            }
            btnStaggered.setOnClickListener {
                rv.layoutManager = StaggeredGridLayoutManager(2,0)
                rv.adapter = mailAdapter
            }
            btnHorizontal.setOnClickListener {
                rv.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                rv.adapter = mailAdapter
            }
            btnDecorator2.setOnClickListener {
                val spaceItemDecoration = FirstNLastItemDecorator(
                    resources.getDimensionPixelSize(R.dimen._50dp),
                    resources.getDimensionPixelSize(R.dimen._10dp)
                )
                rv.layoutManager =
                    LinearLayoutManager(this@MainActivity)
                rv.addItemDecoration(spaceItemDecoration)
                rv.adapter = mailAdapter
            }

            btnDecorator3.setOnClickListener {
                val uiDecorator = CustomBackgroundItemDecorator(
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.progress)!!,
                    resources.getDimensionPixelSize(R.dimen._50dp),
                    resources.getDimensionPixelSize(R.dimen._50dp)
                )
                rv.layoutManager =
                    LinearLayoutManager(this@MainActivity)
                rv.addItemDecoration(uiDecorator)
                rv.adapter = mailAdapter
            }

            btnDecorator3.setOnClickListener {
                val uiDecorator = CustomBackgroundItemDecorator(
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.progress)!!,
                    resources.getDimensionPixelSize(R.dimen._50dp),
                    resources.getDimensionPixelSize(R.dimen._50dp)
                )
                rv.layoutManager =
                    LinearLayoutManager(this@MainActivity)
                rv.addItemDecoration(uiDecorator)
                rv.adapter = mailAdapter
            }

            btnDecorator3.setOnClickListener {
                val uiDecorator = CustomBackgroundItemDecorator(
                    ContextCompat.getDrawable(this@MainActivity, R.drawable.progress)!!,
                    resources.getDimensionPixelSize(R.dimen._50dp),
                    resources.getDimensionPixelSize(R.dimen._50dp)
                )
                rv.layoutManager =
                    LinearLayoutManager(this@MainActivity)
                rv.addItemDecoration(uiDecorator)
                rv.adapter = mailAdapter
            }

            btnAnim.setOnClickListener {

                rv.layoutManager =
                    LinearLayoutManager(this@MainActivity)
                val animation: LayoutAnimationController =
                    AnimationUtils.loadLayoutAnimation(this@MainActivity, R.anim.layout_animation)
                rv.layoutAnimation = animation
                rv.adapter = mailAdapter
            }

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