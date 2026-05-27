/**
 * Демонстрация работы собственной реализации односвязного списка. */
public class Main {
    public static void main(String[] args) {
        // Создаём пустой список строк
        SinglyLinkedList<String> list = new SinglyLinkedList<>();

        // Добавляем элементы в конец
        list.addLast("Москва");
        list.addLast("Екатеринбург");
        list.addLast("Казань");

        // Добавляем элемент в начало
        list.addFirst("Санкт-Петербург");

        System.out.println("Список: " + list);
        System.out.println("Размер: " + list.size());
        System.out.println("Элемент с индексом 2: " + list.get(2));
        System.out.println("Содержит \"Казань\": " + list.contains("Казань"));

        // Удаляем первый элемент
        list.remove(0);
        System.out.println("После удаления первого: " + list);
        System.out.println("Размер: " + list.size());
    }
}
