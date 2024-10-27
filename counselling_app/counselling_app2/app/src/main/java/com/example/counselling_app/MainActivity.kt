package com.example.counselling_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.counselling_app.ui.theme.Counselling_appTheme


class MainActivity : ComponentActivity() {
    private var isHomePageVisible = false // Flag to track the current state

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
                    setContentView(R.layout.activity_main)

                    // Find the button by its ID
                    val buttonGetStarted = findViewById<Button>(R.id.buttonGetStarted)

                    buttonGetStarted.setOnClickListener {
                        if (isHomePageVisible) {
                            // If home_page.xml is visible, switch to activity_main.xml
                            setContentView(R.layout.activity_main)
                            isHomePageVisible = false
                        } else {
                            // If activity_main.xml is visible, switch to home_page.xml
                            setContentView(R.layout.field)
                            isHomePageVisible = true
                        }
                    }
                }
            }
        }
    }

    // The function associated with android:onClick in home_page.xml
    fun onGetStartedButtonClick(view: View) {
        // Toggle between layouts
        if (isHomePageVisible) {
            setContentView(R.layout.field)
            isHomePageVisible = false
        } else {
            setContentView(R.layout.home_page)
            isHomePageVisible = true
        }
    }
    fun back(view: View) {
        // Toggle between layouts
        if (isHomePageVisible) {
            setContentView(R.layout.field)
            isHomePageVisible = false
        } else {
            setContentView(R.layout.activity_main)
            isHomePageVisible = true
        }
    }
    fun onGetStartedButtonClick1(view: View) {
        // Toggle between layouts
        if (isHomePageVisible) {
            setContentView(R.layout.home_page)
            isHomePageVisible = false
        } else {
            setContentView(R.layout.undergraduate)
            isHomePageVisible = true
        }
    }


    fun onGetStartedButton1Click2(view: View) {
        val mcqRadioGroup: RadioGroup = findViewById(R.id.mcqRadioGroup)
        val selectedCategory = when (mcqRadioGroup.checkedRadioButtonId) {
            R.id.option1 -> "Open"
            R.id.option2 -> "OBC"
            R.id.option3 -> "SC"
            R.id.option4 -> "ST"
            R.id.option5 -> "Other"
            else -> "Unknown"
        }

        val percentileEditText: EditText = findViewById(R.id.txt12thPercentage)
        val enteredPercentile = percentileEditText.text.toString().toDoubleOrNull()

        if (enteredPercentile != null) {

            val cutoff = calculateCutoff(selectedCategory, enteredPercentile)
            val message = "Eligible for $selectedCategory: $cutoff"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            if (cutoff == "Eligible") {
                // Open the EligibleActivity
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Invalid percentile entered.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateCutoff(category: String, percentile: Double): Any {
        val cutoffs = mapOf(
            "Open" to 85.0,
            "OBC" to 80.0,
            "SC" to 75.0,
            "ST" to 70.0,
            "Other" to 78.0
        )

        return if (percentile >= cutoffs[category] ?: 0.0) {
            setContentView(R.layout.eligiblepage)
        } else {
            "Not Eligible"
        }
    }

    fun higher(view: View) {
        // Toggle between layouts
        if (isHomePageVisible) {
            setContentView(R.layout.home_page)
            isHomePageVisible = false
        } else {
            setContentView(R.layout.higher)
            isHomePageVisible = true
        }
    }
    fun medical(view:View)
    {
        if(isHomePageVisible){
            setContentView(R.layout.medical_main)
        }
        else {
            setContentView(R.layout.field)
            isHomePageVisible = true
        }
    }



    fun onGetStartedButton1Click3(view: View) {
        val mcqRadioGroup: RadioGroup = findViewById(R.id.mcqRadioGroup)
        val selectedCategory = when (mcqRadioGroup.checkedRadioButtonId) {
            R.id.option1 -> "Open"
            R.id.option2 -> "OBC"
            R.id.option3 -> "SC"
            R.id.option4 -> "ST"
            R.id.option5 -> "Other"
            else -> "Unknown"
        }

        val percentileEditText: EditText = findViewById(R.id.txt12thPercentage)
        val enteredPercentile = percentileEditText.text.toString().toDoubleOrNull()

        if (enteredPercentile != null) {

            val cutoff = calculateCutoff1(selectedCategory, enteredPercentile)
            val message = "Eligible for $selectedCategory: $cutoff"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            if (cutoff == "Eligible") {
                // Open the EligibleActivity
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Invalid percentile entered.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateCutoff1(category: String, percentile: Double): Any {
        val cutoffs = mapOf(
            "Open" to 85.0,
            "OBC" to 80.0,
            "SC" to 75.0,
            "ST" to 70.0,
            "Other" to 78.0
        )

        return if (percentile >= cutoffs[category] ?: 0.0) {
            setContentView(R.layout.eligiblepage)
        } else {
            "Not Eligible"
        }
    }
    fun medical_undergraduate(view:View)
    {
        if(isHomePageVisible){
            setContentView(R.layout.medical_undergraduate)
        }
        else {
            setContentView(R.layout.medical_main)
            isHomePageVisible = true
        }
    }

    fun feedback(view: View) {
        val url = "https://docs.google.com/forms/d/e/1FAIpQLSevdZxzEAPW_gipW3gvTR3J13xps2x29dgJviRGm1R9OGZQ0Q/viewform?vc=0&c=0&w=1&flr=0"
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }


    fun Register(view:View)
    {
        if(isHomePageVisible){
            setContentView(R.layout.register)
        }
        else {
            setContentView(R.layout.login)
            isHomePageVisible = true
        }
    }


    fun loginnow(view:View)
    {
        if(isHomePageVisible){
            setContentView(R.layout.login)
        }
        else {
            setContentView(R.layout.register)
            isHomePageVisible = true
        }
    }


    fun medical_eligible(view: View) {
        val mcqRadioGroup: RadioGroup = findViewById(R.id.mcqRadioGroup)
        val selectedCategory = when (mcqRadioGroup.checkedRadioButtonId) {
            R.id.option1 -> "Open"
            R.id.option2 -> "OBC"
            R.id.option3 -> "SC"
            R.id.option4 -> "ST"
            R.id.option5 -> "Other"
            else -> "Unknown"
        }

        val percentileEditText: EditText = findViewById(R.id.txt12thPercentage)
        val enteredPercentile = percentileEditText.text.toString().toDoubleOrNull()

        if (enteredPercentile != null) {

            val cutoff = calculateCutoff2(selectedCategory, enteredPercentile)
            val message = "Eligible for $selectedCategory: $cutoff"
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

            if (cutoff == "Eligible") {
                // Open the EligibleActivity
                startActivity(intent)
            }
        } else {
            Toast.makeText(this, "Invalid percentile entered.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculateCutoff2(category: String, percentile: Double): Any {
        val cutoffs = mapOf(
            "Open" to 85.0,
            "OBC" to 80.0,
            "SC" to 75.0,
            "ST" to 70.0,
            "Other" to 78.0
        )

        return if (percentile >= cutoffs[category] ?: 0.0) {
            setContentView(R.layout.medicalpage)
        } else {
            "Not Eligible"
        }
    }


    fun medical_back(view:View)
    {
        if(isHomePageVisible){
            setContentView(R.layout.medical_main)
        }
        else {
            setContentView(R.layout.medicalpage)
            isHomePageVisible = true
        }
    }

    fun medical_higher(view:View)
    {
        if(isHomePageVisible){
            setContentView(R.layout.medical_higher)
        }
        else {
            setContentView(R.layout.medical_main)
            isHomePageVisible = true
        }
    }


}



