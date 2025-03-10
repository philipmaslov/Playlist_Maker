package com.example.playlistmaker

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SearchActivity : AppCompatActivity() {

    private var searchValue = SEARCH_INPUT_DEF

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search)

        val inputEditText = findViewById<EditText>(R.id.input_edit_text)
        val clearButton = findViewById<ImageView>(R.id.clear_button)

        clearButton.setOnClickListener {
            inputEditText.setText("")
        }

        val simpleTextWatcher = object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                clearButton.visibility = clearButtonVisibility(p0)
                searchValue = p0.toString()
            }

            override fun afterTextChanged(p0: Editable?) {

            }
        }
        inputEditText.addTextChangedListener(simpleTextWatcher)

    }

    override fun onResume() {
        super.onResume()
        findViewById<EditText>(R.id.input_edit_text).setText(searchValue)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SEARCH_INPUT, searchValue)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        searchValue = savedInstanceState.getString(SEARCH_INPUT, SEARCH_INPUT_DEF).toString()
    }

    companion object {
        const val SEARCH_INPUT = "SEARCH_INPUT"
        const val SEARCH_INPUT_DEF = ""
    }
}

private fun clearButtonVisibility(p0: CharSequence?): Int {
    return if (p0.isNullOrEmpty()) {
        View.GONE
    } else {
        View.VISIBLE
    }
}