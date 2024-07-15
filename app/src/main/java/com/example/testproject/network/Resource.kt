package com.example.testproject.network

sealed class Resource<T> {

    class Success<T>(val data: T): Resource<T>()
    class Loading<T>(): Resource<T>()
    class Error<T>(val message: String): Resource<T>()
}
