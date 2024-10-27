package com.example.counselling_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.counselling_app.ui.theme.Counselling_appTheme

class Main1Activity : ComponentActivity() {
    private var isHomePageVisible1 = false // Flag to track the current state

    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Counselling_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Initially, set the content to activity_main.xml
                    setContentView(R.layout.home_page)

                    // Find the button by its ID
                    val buttonGetStarted = findViewById<Button>(R.id.textView5)

                    buttonGetStarted.setOnClickListener {
                        if (isHomePageVisible1) {
                            // If home_page.xml is visible, switch to activity_main.xml
                            setContentView(R.layout.home_page)
                            isHomePageVisible1 = false
                        } else {
                            // If activity_main.xml is visible, switch to home_page.xml
                            setContentView(R.layout.undergraduate)
                            isHomePageVisible1 = true
                        }
                    }
                }
            }
        }
    }

    // The function associated with android:onClick in .xml
    fun onGetStartedButtonClick1(view: View) {
        // Toggle between layouts
        if (isHomePageVisible1) {
            setContentView(R.layout.home_page)
            isHomePageVisible1 = false
        } else {
            setContentView(R.layout.undergraduate)
            isHomePageVisible1 = true
        }
    }
}

