package com.duberton.common.exception

class BusinessException(val domain: String, override val message: String) : RuntimeException()