package br.com.bluetoothchat.presentation.components

import android.bluetooth.BluetoothDevice
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.bluetoothchat.domain.chat.BluetoothDeviceObj
import br.com.bluetoothchat.presentation.BlueetoothUiState

@Composable
fun DeviceScreen(
    state: BlueetoothUiState,
    onStartScan: () -> Unit,
    onStopScan: () -> Unit,
) {
    Column(modifier = Modifier.fillMaxSize()) {

        BluetoothDevicesList(
            pairedDevices = state.pairedDevices,
            scannedDevices = state.scannedDevices,
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(
                onClick = onStartScan,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF018A01)
                )
            ) {
                Text("Start SCAN")
            }
            Button(
                onClick = onStopScan,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF5E0000)
                )
            ) {
                Text("Stop SCAN")
            }
        }
    }
}

@Composable
fun BluetoothDevicesList(
    pairedDevices: List<BluetoothDeviceObj>,
    scannedDevices: List<BluetoothDeviceObj>,
    onClick: (BluetoothDeviceObj) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                text = "Paired Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(pairedDevices){ device ->
            Text(
                text = device.name ?: "(no name)",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(device) }
                    .padding(16.dp)
            )
        }

        item {
            Text(
                text = "Scanned Devices",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
        }

        items(scannedDevices){ device ->
            Text(
                text = device.name ?: "(no name)",
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onClick(device) }
                    .padding(16.dp)
            )
        }
    }
}