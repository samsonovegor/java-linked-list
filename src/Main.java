/**
 * Демонстрация работы собственной реализации односвязного списка.
 */
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

        // Вставляем элемент на позицию 2
        list.add(2, "Новосибирск");
        System.out.println("После add(2, Новосибирск): " + list);

        // Поиск по значению
        System.out.println("indexOf(Казань): " + list.indexOf("Казань"));
        System.out.println("contains(Владивосток): " + list.contains("Владивосток"));

        // Доступ по индексу и удаление
        System.out.println("get(1): " + list.get(1));
        list.remove(0);
        System.out.println("После remove(0): " + list);
        System.out.println("Размер: " + list.size());

        // Очистка
        list.clear();
        System.out.println("После clear – isEmpty: " + list.isEmpty());
    }
}
