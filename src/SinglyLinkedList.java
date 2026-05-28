/**
 * Односвязный список – собственная реализация структуры данных.
 * Хранит элементы в виде цепочки узлов, где каждый узел ссылается на следующий.
 *
 * @param <T> тип хранимых элементов
 */
public class SinglyLinkedList<T> {

    /** Узел списка: хранит данные и ссылку на следующий узел. */
    private static class Node<T> {
        T data;        // данные узла
        Node<T> next;  // ссылка на следующий узел (null, если узел последний)

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head; // ссылка на первый узел списка
    private int size;     // текущее количество элементов

    /** Создаёт пустой список. */
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /** Добавляет элемент в начало списка. */
    public void addFirst(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = head;
        head = newNode;
        size++;
    }

    /** Добавляет элемент в конец списка. */
    public void addLast(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /** Вставляет элемент на заданную позицию (нумерация с нуля). */
    public void add(int index, T value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index);
        }
        if (index == 0) {
            addFirst(value);
            return;
        }
        Node<T> prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node<T> newNode = new Node<>(value);
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }

    /** Возвращает элемент по индексу (нумерация с нуля). */
    public T get(int index) {
        checkIndex(index);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    /** Удаляет элемент по индексу и возвращает удалённое значение. */
    public T remove(int index) {
        checkIndex(index);
        T removed;
        if (index == 0) {
            removed = head.data;
            head = head.next;
        } else {
            Node<T> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            removed = prev.next.data;
            prev.next = prev.next.next;
        }
        size--;
        return removed;
    }

    /** Проверяет, содержится ли указанное значение в списке. */
    public boolean contains(T value) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** Возвращает индекс первого вхождения элемента, или -1 если не найден. */
    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /** Очищает список, удаляя все элементы. */
    public void clear() {
        head = null;
        size = 0;
    }

    /** Возвращает количество элементов в списке. */
    public int size() {
        return size;
    }

    /** Возвращает true, если список пуст. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Проверяет корректность индекса. */
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Недопустимый индекс: " + index);
        }
    }

    /** Возвращает строковое представление списка в виде [a, b, c]. */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
