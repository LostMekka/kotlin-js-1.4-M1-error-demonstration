@file:OptIn(ExperimentalJsExport::class)
package de.lostmekka.js.sandbox

@JsExport
class SomeClass(val x: Int, val inner: SomeOtherClass) {
    fun foo() = inner.bar()
}

@JsExport
class SomeOtherClass {
    fun bar() = "hello"
}
