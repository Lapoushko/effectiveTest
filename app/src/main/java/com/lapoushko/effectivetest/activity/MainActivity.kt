package com.lapoushko.effectivetest.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.lapoushko.common.theme.EffectiveTestTheme
import com.lapoushko.effectivetest.App
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveTestTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    App().Host()
                }
            }
        }
    }
}