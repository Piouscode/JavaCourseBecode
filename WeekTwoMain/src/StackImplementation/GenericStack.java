package StackImplementation;

import java.util.ArrayList;
import java.util.List;

public class GenericStack<T> {
private final List<T> elements;

public GenericStack() {
	elements = new ArrayList<>();
}

public void push(T item) {
	elements.add(item);
}

public T pop() {
	if (isEmpty()) {
		throw new IllegalStateException("Stack is empty.");
	}
	return elements.remove(elements.size() - 1);
}

public T peek() {
	if (isEmpty()) {
		throw new IllegalStateException("Stack is empty.");
	}
	return elements.get(elements.size() - 1);
}

public boolean isEmpty() {
	return elements.isEmpty();
}
}
