package com.coders.guanaflix.data.repositories

import com.coders.guanaflix.domain.model.Show

interface Repository {
    suspend fun getData(): List<Show>
}