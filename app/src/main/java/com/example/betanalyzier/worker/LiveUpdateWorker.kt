package com.example.betanalyzier.worker

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.betanalyzier.R
import com.example.betanalyzier.data.api.RetrofitClient

class LiveUpdateWorker(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        return try {
            // En una app real, aquí llamaríamos a un repositorio
            // val liveMatches = repository.getLiveMatches()
            
            // Simulación de detección de cambio en favorito
            showNotification("¡GOL en LaLiga!", "Real Madrid 1 - 0 Barcelona (Minuto 23')")

            Result.success()
        } catch (e: Exception) {
            Result.retry()
        }
    }

    private fun showNotification(title: String, message: String) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "live_scores_channel"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                "Resultados en Directo",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(applicationContext, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()

        // Nota: En Android 13+ se requiere permiso de notificación
        notificationManager.notify(System.currentTimeMillis().toInt(), notification)
    }
}
