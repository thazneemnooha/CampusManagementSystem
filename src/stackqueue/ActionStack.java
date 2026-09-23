package stackqueue;

public class ActionStack {

private String[] actions;
private int top;
private int capacity;

public ActionStack(int capacity) {
this.capacity = capacity;
actions = new String[capacity];
top = -1;
}
public void push(String action) {

if (top == capacity - 1) {
System.out.println("Stack is full.");
return;
}

actions[++top] = action;
}
public String pop() {

if (top == -1) {
return null;
}

return actions[top--];
}
public void displayActions() {

if (top == -1) {
System.out.println("No recent actions.");
return;
}

for (int i = top; i >= 0; i--) {
System.out.println(actions[i]);
}
}
}
