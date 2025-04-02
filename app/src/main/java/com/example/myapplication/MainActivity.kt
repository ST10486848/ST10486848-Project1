package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity() : AppCompatActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }
    private fun setOnClickListener(unit: Unit) {

    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }
    override fun describeContents(): Int {
        return 0
    }
    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }
        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val displayMeal = findViewById<TextView>(R.id.displayMeal) // Declaring the variables
        val timeofday = findViewById<EditText>(R.id.Timeofday)
        val clickMeButton = findViewById<Button>(R.id.clickMeButton)
        val resetButton = findViewById<Button>(R.id.ResetButton)

     // Get the code to displays meal based on input
        clickMeButton?.setOnClickListener {
            val timeInput = timeofday.text.toString().trim()
displayMeal.text = when (timeInput.lowercase()) {
    "morning"       -> "Breakfast: Pancakes, Eggs and Coffee"
    "mid morning"   -> "Snacks: Apple slices with peanut butter"
    "afternoon"     -> "Turkey and cheese sandwich"
    "mid afternoon" -> "Greek yogurt with granola"
    "evening"       -> "Grilled chicken, steamed broccoli, and rice"
    else           -> "Invalid input. Valid options: Morning, Mid morning, Afternoon, Mid afternoon, Evening"
}

}}}