package com.example.testindoors

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    val GALLERY_REQUEST = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val photoPickerIntent = Intent(Intent.ACTION_PICK)
            photoPickerIntent.type = "image/*"
            startActivityForResult(photoPickerIntent, GALLERY_REQUEST)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, imageReturnedIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent)
        val bitmap: Bitmap? = null
        val imageView = findViewById<View>(R.id.imageView) as ImageView
        val imageView2 = findViewById<View>(R.id.imageView2) as ImageView

        when(requestCode){
            1 -> if (resultCode == RESULT_OK){
                val selectedImage: Uri? = imageReturnedIntent?.getData()
                imageView.setImageURI(selectedImage)
            }
            2 -> if (resultCode == RESULT_OK){
                val selectedImage: Uri? = imageReturnedIntent?.getData()
                imageView2.setImageURI(selectedImage)
            }
        }
    }


}