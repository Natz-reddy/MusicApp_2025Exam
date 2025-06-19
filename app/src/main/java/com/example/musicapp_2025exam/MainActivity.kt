package com.example.musicapp_2025exam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.musicapp_2025exam.ui.theme.MusicApp_2025ExamTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val songtitleList = remember { mutableStateListOf< String>() }
            val artistList = remember { mutableStateListOf< String>() }
            val ratingList = remember { mutableStateListOf< String>() }
            val commentsList = remember { mutableStateListOf< String>() }

            var songtitle by remember { mutableStateOf("") }
            var artist by remember { mutableStateOf("") }
            var rating by remember { mutableStateOf("") }
            var comments by remember { mutableStateOf("") }
            var errormessage by remember { mutableStateOf("") }





            }
        }
    }
