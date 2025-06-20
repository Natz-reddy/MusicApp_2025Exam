package com.example.musicapp_2025exam

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicapp_2025exam.ui.theme.MusicApp_2025ExamTheme

class DetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//arrays that store the data entered
            val songtitleList = intent.getStringArrayListExtra("songtitleList") ?: arrayListOf()
            val artistList = intent.getStringArrayListExtra("artistList") ?: arrayListOf()
            val ratingList = intent.getStringArrayListExtra("ratingList") ?: arrayListOf()
            val commentsList = intent.getStringArrayListExtra("commentsList") ?: arrayListOf()
//variables that allow to show all songs
            var showsongs by remember { mutableStateOf(true) }

// column layout
            Column(
                modifier = Modifier.fillMaxSize().background(Color(0xAD72ABE0)),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = " Your Playlist ", fontSize = 20.sp, fontFamily = FontFamily.SansSerif)
// changing button colors
                Button(
                    onClick = { showsongs = !showsongs }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF046698),
                        contentColor = Color.White
                    )
                ) {//shows or hides some songs
                    Text(if (showsongs) "show songs with low ratings" else "Show all songs")
                }

                Spacer(modifier = Modifier.height(16.dp))
// value to store the index
                val displayIndices = if (showsongs) {
                songtitleList.indices
                } else {//creates an index to count if the value is higher or lower
                ratingList.mapIndexedNotNull { index, qty ->
                qty.toIntOrNull()?.takeIf { it >= 2 }?.let { index }
                }
            }

                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    displayIndices.forEach { i ->//displays the entered information
                        Text(
                            text = "Songs: ${songtitleList[i]}\nArtist: ${artistList[i]}\nRating: ${ratingList[i]}\nComments: ${commentsList[i]}",
                            modifier = Modifier.padding(vertical = 8.dp),
                            fontSize = 16.sp
                        )

                    }

                    Spacer(modifier = Modifier.height(16.dp))


                }

                Button(
                    onClick = {}, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF046698),
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Average Rating")
                }
                //moves back to the home screen
                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        val intent = Intent(this@DetailedView, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF046698),
                        contentColor = Color.White
                    )
                ) {
                    Text("Back to Home Screen")
                }
            }
        }

    }
}

