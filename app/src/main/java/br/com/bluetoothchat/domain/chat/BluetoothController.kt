package br.com.bluetoothchat.domain.chat

import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {
    val scannedDevices: StateFlow<List<BluetoothDeviceObj>>
    val pairedDevices: StateFlow<List<BluetoothDeviceObj>>

    fun startDiscovery()
    fun stopDiscovery()

    fun release()
}