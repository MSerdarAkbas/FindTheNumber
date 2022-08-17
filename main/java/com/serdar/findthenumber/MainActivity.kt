package com.serdar.findthenumber

import android.app.Application
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    val birSayi= Random.nextInt(0,100)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun tahminet(view: View) {
        val yazilanSayi =editTextNumber.text.toString().toInt()

        if (yazilanSayi < birSayi) {
            Toast.makeText(this, "bigger than this!!", Toast.LENGTH_SHORT).show()
            val snackBarım = Snackbar.make(this, view, "Bundan daha büyük", 1000).show()
        }
        else if (yazilanSayi > birSayi) {
            Toast.makeText(this, "smaller than this!!", Toast.LENGTH_SHORT).show()
            val snackBarım = Snackbar.make(this, view, "Bundan daha küçük", 1000).show()
            }
        else if(yazilanSayi == birSayi) {
            Toast.makeText(this, "CONGRATULATIONS!!", Toast.LENGTH_LONG).show()
            val snackBarım = Snackbar.make(this, view, "TEBRİKLER!!!", 2000).show()
        }
        else {
            Toast.makeText(this, "YOU ENTERED WRONG !", Toast.LENGTH_LONG).show()
            val snackBarım = Snackbar.make(this, view, "YANLIŞ GİRİŞ YAPTINIZ !", 3)
        }

    }

    fun yeniOyun  (view: View){
        var uyariMesaji = AlertDialog.Builder(this)
        uyariMesaji.setTitle("Yeni oyun")
        uyariMesaji.setMessage("Yeni oyun başlatmak istiyor musunuz?")
        uyariMesaji.setPositiveButton("EVET",DialogInterface.OnClickListener { dialog, which ->
            val intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        })
        uyariMesaji.setNegativeButton("HAYIR",DialogInterface.OnClickListener { dialog, which ->
            Toast.makeText(this, "Devam ediyorsunuz", Toast.LENGTH_LONG).show()
        })
        uyariMesaji.show()



    }

}