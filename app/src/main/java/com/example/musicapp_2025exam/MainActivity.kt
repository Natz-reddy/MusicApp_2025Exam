package com.example.musicapp_2025exam

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
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
//Nathaniel Reddy - ST10488460
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

            Column (
                modifier = Modifier.fillMaxSize().background(Color(0xFF3197D9)),verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally

            ){
                Text(text = "Music Playlist", fontSize = 20.sp, fontFamily = FontFamily.SansSerif )

                Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        value = songtitle,
                        onValueChange = { songtitle = it },
                        placeholder = { Text(" Song Title") },
                        modifier = Modifier.width(400.dp))

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = artist,
                    onValueChange = { artist = it },
                    placeholder = { Text(" Artist Name") },
                    modifier = Modifier.width(400.dp))

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = rating,
                    onValueChange = { rating = it },
                    placeholder = { Text(" Rating(1 to 5)") },
                    modifier = Modifier.width(400.dp))

                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = comments,
                    onValueChange = { comments = it },
                    placeholder = { Text(" Comments ") },
                    modifier = Modifier.width(400.dp))

                Spacer(modifier = Modifier.height(10.dp))

                Button(onClick = {
                    if (songtitle.isNotBlank() && artist.isNotBlank() && rating.isNotBlank() && comments.isNotBlank()) {
                       songtitleList.add(songtitle)
                        artistList.add(artist)
                      ratingList.add(rating)
                        commentsList.add(comments)

                       songtitle= ""
                        artist = ""
                       rating = ""
                        comments = ""
                       errormessage = ""
                    } else {
                        errormessage = "Please fill in all fields"
                    }
                }) {
                    Text("Add to PlayList")
                }



                if (errormessage.isNotEmpty()) {
                    Spacer(modifier = Modifier.height(8.dp))

                    Text ( errormessage, color = Color.Red, fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))


                Button(onClick = {
                    val intent = Intent(this@MainActivity, DetailedView::class.java)
                    intent.putStringArrayListExtra("songtitleList", ArrayList(songtitleList))
                    intent.putStringArrayListExtra("artistList", ArrayList(artistList))
                    intent.putStringArrayListExtra("ratingList", ArrayList(ratingList))
                    intent.putStringArrayListExtra("commentsList", ArrayList(commentsList))
                    startActivity(intent)
                }) {
                    Text(text = " View playlist ")
                }


                Spacer(modifier = Modifier.height(10.dp))











            }
            }

            }
        }

