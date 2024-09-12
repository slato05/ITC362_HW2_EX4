package com.example.itc362_hw2_ex4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.view.View
import com.example.itc362_hw2_ex4.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var isGo = false
        var isWait = true
        var isStop = false


        binding.button.setOnClickListener {
            if (isGo) {
                // Set background color
                //Resource: https://stackoverflow.com/questions/49957430/how-do-i-set-color-with-setbackgroundcolor-with-color-from-values-colors-xml
                binding.button.setBackgroundColor(ContextCompat.getColor(this, R.color.LimeGreen))

                // Set button text
                binding.button.text = getString(R.string.go)

                // Set visibility of lights
                binding.redLight.visibility = View.INVISIBLE
                binding.yellowLight.visibility = View.INVISIBLE
                binding.greenLight.visibility = View.VISIBLE

                // Reset Boolean vars
                isStop = false
                isGo = false
                isWait = true

            } else if (isWait) {
                // Set background color
                binding.button.setBackgroundColor(ContextCompat.getColor(this, R.color.Yellow))

                // Set button text
                binding.button.text = getString(R.string.wait)

                // Set visibility of lights
                binding.redLight.visibility = View.INVISIBLE
                binding.yellowLight.visibility = View.VISIBLE
                binding.greenLight.visibility = View.INVISIBLE

                // Reset Boolean vars
                isStop = true
                isGo = false
                isWait = false

            } else {
                // Set background color
                binding.button.setBackgroundColor(ContextCompat.getColor(this, R.color.red))

                // Set button text
                binding.button.text = getString(R.string.stop)

                // Set visibility of lights
                binding.redLight.visibility = View.VISIBLE
                binding.yellowLight.visibility = View.INVISIBLE
                binding.greenLight.visibility = View.INVISIBLE

                // Reset Boolean vars
                isStop = false
                isGo = true
                isWait = false
            }
        }
    }
}