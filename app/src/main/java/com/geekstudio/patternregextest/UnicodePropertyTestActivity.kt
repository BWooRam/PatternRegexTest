package com.geekstudio.patternregextest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.geekstudio.patternregextest.ui.theme.PatternRegexTestTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    private val TAG = javaClass.simpleName
    private val totalDummy: List<String> by lazy {
        arrayListOf<String>().apply {
            addAll(Pattern.languageDummy)
            addAll(Pattern.numberDummy)
            addAll(Pattern.specialLanguageDummy)
            add(Pattern.spaceDummy)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PatternRegexTestTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 40.dp)
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        SampleTitle("\\p{L} 테스트", true)
                        SampleButton("테스트 시작") {
                            for (lan in totalDummy) {
                                for (char in lan.toCharArray()) {
                                    val convertString = char.toString()
                                    val result = Pattern.isRegexMatches(convertString)
                                    Log.d(
                                        TAG,
                                        "p{L} 테스트 char = $char, convertString = $convertString, result = $result"
                                    )
                                }
                            }
                        }
                        SampleTitle("\\p{N} 테스트", true)
                        SampleButton("테스트 시작") {
                            for (lan in totalDummy) {
                                for (char in lan.toCharArray()) {
                                    val convertString = char.toString()
                                    val result =
                                        Pattern.isRegexMatches(convertString, regex = "\\p{N}")
                                    Log.d(
                                        TAG,
                                        "p{N} 테스트 char = $char, convertString = $convertString, result = $result"
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SampleTitle(title: String, isFirst: Boolean = false) {
    val defaultModifier = if (isFirst) {
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 4.dp)
    } else {
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(top = 30.dp)
    }

    Text(
        text = title,
        modifier = defaultModifier,
        textAlign = TextAlign.Start,
        style = TextStyle(color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
    )
}

@Composable
fun SampleButton(name: String, onClick: () -> Unit) {
    Button(modifier = Modifier.wrapContentSize(), onClick = onClick) {
        Text(name)
    }
}