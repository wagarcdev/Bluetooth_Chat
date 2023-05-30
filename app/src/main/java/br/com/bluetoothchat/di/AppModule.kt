package br.com.bluetoothchat.di

import android.content.Context
import br.com.bluetoothchat.data.chat.AndroidBluetoothController
import br.com.bluetoothchat.domain.chat.BluetoothController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun porvideBluetoothController(@ApplicationContext context: Context): BluetoothController
        = AndroidBluetoothController(context)
}