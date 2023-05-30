package br.com.bluetoothchat.presentation

import br.com.bluetoothchat.domain.chat.BluetoothDeviceObj

data class BlueetoothUiState(
    val scannedDevices: List<BluetoothDeviceObj> = emptyList(),
    val pairedDevices: List<BluetoothDeviceObj> = emptyList(),
)
