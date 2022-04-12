package com.example.deeplinksend

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.deeplinksend.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setClickListeners()
    }

    private fun setClickListeners() {

/*        <intent-filter android:label="C">
        <action android:name="android.intent.action.VIEW" />

        <category android:name="android.intent.category.DEFAULT" />
        <category android:name="android.intent.category.BROWSABLE" />

        <data
        android:host="host"
        android:pathPattern="/pattern"
        android:scheme="scheme" />
        </intent-filter>*/


        binding.btnActivityA.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("example://test/a")))
        }
        binding.btnActivityB.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("example://test/b")))
        }
        binding.btnActivityC.setOnClickListener {
            //Será utilizado o caminho especificado no arquivo de manifest do outro app.
            //Neste caso temos o caminho que mapeamos no outro app para a activity c
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("scheme://host/pattern")))
        }
    }
}