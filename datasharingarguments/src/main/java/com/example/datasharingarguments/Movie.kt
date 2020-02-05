package com.example.datasharingarguments

import java.io.Serializable

data class Movie(val title: String, val release: String, val running: Int, val image: Int) : Serializable