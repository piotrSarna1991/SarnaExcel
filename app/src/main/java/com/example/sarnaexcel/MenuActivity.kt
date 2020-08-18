package com.example.sarnaexcel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.sarnaexcel.view.RegisterActivity
import com.example.sarnaexcel.model.TableActivity
import com.example.sarnaexcel.view.View


class MenuActivity : AppCompatActivity(),View {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)




    }

    override fun navigateTo(target: Class<*>) {
        startActivity(Intent(this, target))
    }
}

//    private fun verifyUserIsLoggedIn() {
//        val uid = FirebaseAuth.getInstance().uid
//        if (uid == null) {
//            val intent = Intent(this, RegisterActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
//            startActivity(intent)
//        }
//    }
//    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
//        when (item?.itemId) {
//            R.id.menu_new_file -> {
//                val intent = Intent(this, TableActivity::class.java)
//                startActivity(intent)
//            }
//            R.id.menu_sign_out -> {
//                FirebaseAuth.getInstance().signOut()
//                val intent = Intent(this, RegisterActivity::class.java)
//                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(intent)
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.nav_menu,menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//}