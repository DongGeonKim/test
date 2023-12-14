package com.test.exam;

import java.util.IllegalFormatException;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

/**
 * error 처리 예제
 *  - onErrorReturn Operator
 *      - 예외가 발생했을 때, error 이벤트를 발생시키지 않고, default value로 대체해서 emit하고자 할 경우
 *      - try ~ catch 문의 경우, catch해서 return default value 하는 것과 같다.
 */
@Slf4j
public class Example14_46 {
    public static void main(String[] args) {
        getBooks()
                .map(book -> book.getPenName().toUpperCase())
                .onErrorReturn(NullPointerException.class, "no pen name")
                .onErrorReturn(IllegalFormatException.class, "Illegal pen name")
                .subscribe(log::info);
    }

    public static Flux<Book> getBooks() {
        return Flux.fromIterable(SampleData.books);
    }
}