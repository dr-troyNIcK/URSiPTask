import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//        Задание:
//        Реализовать метод для генерации номера проекта на Java, Kotlin или Scala
//        Сигнатура метода (java):
//        public static String generateNum(List<Integer> numbers)
//        На вход будет переданы сущетвующие номера в виде масива целых чисел.
//        Необходимо вернуть номер следующего проекта, по следующей логике:
//        Если текущие номера проекта не содержат пропусков, то необходимо вернуть максимальный элемент + 1.
//        Если пропуски есть, необходимо вернуть минимальный из них.
//        Пропуском называется разница между номерами больше или равная единицы (f(1,3) содержит пропуск, а f(1,2) нет).
//        Переданные номера проектов могут дублироваться, но сгенерированный методом номер не должен повторять существующий.
//        Номера проектов неотрицательные.
//        Пример:
//        f(1,2,3) = 4
//        f(1,3) = 2
//        f(2) = 1
//        Сгенерированный номер необходимо вернуть в формате трехразрядной строки, т.е.:
//        f(1) = "001"
//        f(10) = "010"
//        f(100) = "100"
//        В реализации приветствуется функциональный стиль.
//        Оцениваться будет качество кода и его корректность.
//        Решение необходимо залить в публичный репозиторий и предоставить ссылку.

public class URSiPTask {

    public static String geneNum(List<Integer> numbers) {

        final List<Integer> listOfSkipMinNumbers = new ArrayList<>();
        Integer maxElementOfList = numbers.stream()
                .distinct()
                .sorted()
                .reduce(0, (i1, i2) -> {
                    if (i2 - i1 != 1) {
                        listOfSkipMinNumbers.add(i1 + 1);
                    }
                    return i2;
                });
        System.out.printf("in: %s, listOfSkipMinNumbers: %s, maxElementOfList: %d%n",
                numbers, listOfSkipMinNumbers, maxElementOfList);
        return String.format("%03d", listOfSkipMinNumbers.size() != 0 ?
                listOfSkipMinNumbers.get(0) : maxElementOfList + 1);
    }
}
