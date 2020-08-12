package com.example.sarnaexcel.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sarnaexcel.R
import com.example.sarnaexcel.presenter.RegisterPresenter
import kotlinx.android.synthetic.main.activity_main.*

class RegisterActivity : AppCompatActivity(),IRegisterView {

    override fun OnRegisterResult(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT)    }

    internal lateinit var registerPresenter:RegisterPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerPresenter = RegisterPresenter(this)

        registerButton.setOnClickListener {
            registerPresenter.onRegister(
                emailButtonRegister.text.toString(),
                passwordButtonRegister.text.toString())


        }
//
        alreadyHaveAnAccountButton.setOnClickListener {
            Log.d("MainActivity", "Try to show login activity")

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
//
//        selectPhotoRegistryButton.setOnClickListener {
//            Log.d("MainActivity", "Try to show photo selector")
//
//            val intent = Intent(Intent.ACTION_PICK)
//            intent.type = "image/*"
//            startActivityForResult(intent, 0)
//        }
    }



//    var selectedPhotoUri: Uri? = null

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
//            // proceed and check what the selected image was....
//            Log.d("MainActivity", "Photo was selected")
//
//            selectedPhotoUri = data.data
//
//            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectedPhotoUri)
//
//            selectPhotoImageViewButton.setImageBitmap(bitmap)
//
//            selectPhotoRegistryButton.alpha = 0f
//
//        }
//    }
//
//    private fun registerActivity() {
//        val username = userNameButtonRegister.text.toString()
//        val email = emailButtonRegister.text.toString()
//        val password = passwordButtonRegister.text.toString()
//        val loginActivity = LoginActivity()
//        if (loginActivity.checkEmailAndPassword(this, email, password)) return
//
//        Log.d("MainActivity", "Username is: " + username)
//        Log.d("MainActivity", "Email is: " + email)
//        Log.d("MainActivity", "Password: $password")
//
//        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
//            .addOnCompleteListener {
//                if (!it.isSuccessful) return@addOnCompleteListener
//
//                // else if successful
//                Log.d("Main", "Successfully created user with uid: ${it.result?.user?.uid}")
//                uploadImageToFirebaseStorage()
//
//            }
//            .addOnFailureListener {
//                Log.d("Main", "Failed to create user: ${it.message}")
//                Toast.makeText(this, "Failed to create user: ${it.message}", Toast.LENGTH_SHORT)
//                    .show()
//            }
//    }
//
//    private fun uploadImageToFirebaseStorage() {
//        if (selectedPhotoUri == null) return
//
//        val filename = UUID.randomUUID().toString()
//        val ref = FirebaseStorage.getInstance().getReference("/images/$filename")
//
//        ref.putFile(selectedPhotoUri!!)
//            .addOnSuccessListener {
//                Log.d("MainActivity", "Successfully uploaded image: ${it.metadata?.path}")
//
//                ref.downloadUrl.addOnSuccessListener {
//                    Log.d("MainActivity", "File Location: $it")
//
//                    saveUserToFirebaseDatabase(it.toString())
//                }
//            }
//            .addOnFailureListener {
//                Log.d("MainActivity", "Failed to upload image to storage: ${it.message}")
//            }
//    }
//
//    private fun saveUserToFirebaseDatabase(profileImageUrl: String) {
//        val uid = FirebaseAuth.getInstance().uid ?: ""
//        val ref = FirebaseDatabase.getInstance().getReference("/users/$uid")
//
//        val user = User(
//            uid,
//            userNameButtonRegister.text.toString(),
//            profileImageUrl
//        )
//
//        ref.setValue(user)
//            .addOnSuccessListener {
//                Log.d("MainActivity", "Finally we saved the user to Firebase Database")
//                val intent = Intent(this, MenuActivity::class.java)
//                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
//                startActivity(intent)
//            }
//            .addOnFailureListener {
//                Log.d("MainActivity", "Failed to set value to database: ${it.message}")
//            }
//    }
//


}


