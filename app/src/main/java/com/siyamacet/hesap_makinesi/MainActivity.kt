package com.siyamacet.hesap_makinesi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.siyamacet.hesap_makinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun toplama(view: View) {
        val birinciSayi = binding.editTextNumber.text.toString().toIntOrNull() ?: 0
        val ikinciSayi = binding.editTextNumber2.text.toString().toIntOrNull() ?: 0

        val toplam = birinciSayi + ikinciSayi
        binding.textView.text = "Sonuc: ${toplam}"

    }

    fun bolme(view: View) {
        val birinciSayi = binding.editTextNumber.text.toString().toDoubleOrNull() ?: 0.0
        val ikinciSayi = binding.editTextNumber2.text.toString().toDoubleOrNull() ?: 0.0

        if (ikinciSayi != 0.0) {
            val sonuc = birinciSayi / ikinciSayi
            binding.textView.text = "Sonuc: ${String.format("%.2f", sonuc)}"
        } else {
            Toast.makeText(this@MainActivity, "İkinci sayı sıfır olamaz", Toast.LENGTH_LONG).show()
        }
    }


    fun carpma(view: View) {
        val birinciSayi = binding.editTextNumber.text.toString().toIntOrNull() ?: 0
        val ikinciSayi = binding.editTextNumber2.text.toString().toIntOrNull() ?: 0

        val sonuc = birinciSayi * ikinciSayi
        binding.textView.text = "Sonuc: ${sonuc}"

    }

    fun cikarma(view: View) {
        val birinciSayi = binding.editTextNumber.text.toString().toIntOrNull() ?: 0
        val ikinciSayi = binding.editTextNumber2.text.toString().toIntOrNull() ?: 0

        val sonuc = birinciSayi - ikinciSayi
        binding.textView.text = "Sonuc: ${sonuc}"

    }


}