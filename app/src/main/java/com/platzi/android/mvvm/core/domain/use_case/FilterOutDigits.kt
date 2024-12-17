package com.platzi.android.mvvm.core.domain.use_case

class FilterOutDigits {
    operator fun invoke(text: String): String {
        return text.filter { it.isDigit() }
    }
}