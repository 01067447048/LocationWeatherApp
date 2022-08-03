package com.jaehyeon.domain.repository

import android.location.Location

/**
 * Created by Jaehyeon on 2022/08/03.
 */
interface LocationRepository {
    suspend fun getCurrentLocation(): Location?
}