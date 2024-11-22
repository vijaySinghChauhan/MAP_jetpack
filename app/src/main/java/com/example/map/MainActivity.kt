package com.example.map

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.map.ui.theme.MAPTheme
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //AIzaSyCeapw_hxMbYfvZA6El8t3huHKntDgOZwY
        enableEdgeToEdge()
        setContent {
            MAPTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MapScreen()
                }
            }
        }
    }
}

@Composable
fun MapScreen() {
    val atasehir = LatLng(40.9971, 29.1007)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(atasehir, 15f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    )
}

//@Composable
//fun MapScreen1() {
//    val atasehir1 = LatLng(40.9971, 29.1007)
//    val atasehir2 = LatLng(40.9967, 29.0570)
//
//    val cameraPositionState = rememberCameraPositionState {
//        position = CameraPosition.fromLatLngZoom(atasehir1, 15f)
//    }
//
//    var uiSettings by remember {
//        mutableStateOf(MapUiSettings(zoomControlsEnabled = true))
//    }
//    var properties by remember {
//        mutableStateOf(MapProperties(mapType = MapType.SATELLITE))
//    }
//
//    GoogleMap(
//        modifier = Modifier.matchParentSize(),
//        cameraPositionState = cameraPositionState,
//        properties = properties,
//        uiSettings = uiSettings
//    ) {
//        Marker(
//            state = MarkerState(position = atasehir1),
//            title = "Marker 1"
//        )
//        Marker(
//            state = MarkerState(position = atasehir2),
//            title = "Marker 2"
//        )
//    }
//}