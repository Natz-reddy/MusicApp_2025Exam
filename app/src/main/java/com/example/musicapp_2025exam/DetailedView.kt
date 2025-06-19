package com.example.musicapp_2025exam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.musicapp_2025exam.ui.theme.MusicApp_2025ExamTheme

class DetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val songtitleList = intent.getStringArrayListExtra("songtitleList") ?: arrayListOf()
            val artistList = intent.getStringArrayListExtra("artistList") ?: arrayListOf()
            val ratingList = intent.getStringArrayListExtra("ratingList") ?: arrayListOf()
            val commentsList = intent.getStringArrayListExtra("commentsList") ?: arrayListOf()

            var showsongs by remember { mutableStateOf(true) }


            Column (
                modifier = Modifier.fillMaxSize().padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = " Your Playlist ")


                



























                Button(onClick = {
                    val intent = Intent(this@DetailedView, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }) {
                    Text("Back to Home Screen")
                }







            }
        }
            }
        }
