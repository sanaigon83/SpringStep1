package hello.core.singleton

class Singleton private constructor() {

    companion object {
        @Volatile
        private var obj: Singleton? = null
        fun getInstance(): Singleton {
            val instance = obj ?: Singleton()
            obj = instance
            return instance
        }
    }
}