package com.duberton.common.validation

inline fun throwIf(condition: Boolean, throwable: () -> Throwable) {
    if (condition) throw throwable()
}