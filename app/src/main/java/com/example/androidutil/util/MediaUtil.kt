package com.example.androidutil.util

import android.graphics.Bitmap
import android.media.MediaMetadataRetriever

object MediaUtil {

    fun getFrameAtTime(path: String?, timeUs: Long): Bitmap? {
        var mmr: MediaMetadataRetriever? = null
        try {
            mmr = MediaMetadataRetriever()
            mmr.setDataSource(path)
            return mmr.getFrameAtTime(timeUs, MediaMetadataRetriever.OPTION_CLOSEST_SYNC)
        } catch (t: Throwable) {
        } finally {
            mmr?.release()
        }
        return null
    }

    fun getVideoDuration(path: String?): Long? {
        var mmr: MediaMetadataRetriever? = null
        try {
            mmr = MediaMetadataRetriever()
            mmr.setDataSource(path)
            return mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION)!!.toLong()
        } catch (t: Throwable) {
        } finally {
            mmr?.release()
        }
        return null
    }
}