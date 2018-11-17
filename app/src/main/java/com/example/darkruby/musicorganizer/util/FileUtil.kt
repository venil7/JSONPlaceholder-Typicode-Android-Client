package com.example.darkruby.musicorganizer.util

import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import java.io.File

fun files(folderPath: String): Observable<File> {
    return Observable.create { emitter ->
        val directory = File(folderPath)
        val files = directory.listFiles()
        for (file in files) {
            emitter.onNext(file)
        }
        emitter.onComplete()
    }
}

fun allFiles(folderPath: String): Observable<File> {
    return files(folderPath)
            .observeOn(Schedulers.io())
            .concatMap { file ->
                if (file.isDirectory) {
                    Observable.concat(Observable.just(file), allFiles(file.absolutePath))
                } else {
                    Observable.just(file)
                }
            }
}
