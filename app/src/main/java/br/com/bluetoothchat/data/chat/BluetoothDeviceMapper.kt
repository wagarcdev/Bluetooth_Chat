package br.com.bluetoothchat.data.chat

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import br.com.bluetoothchat.domain.chat.BluetoothDeviceObj

@SuppressLint("MissingPermission")
fun BluetoothDevice.toBluetoothDeviceObj(): BluetoothDeviceObj {
    return BluetoothDeviceObj(
        name = name,
        macAddress = address
    )
}