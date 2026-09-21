package stackqueue;

public class ServiceQueue {

private String[] requests;
private int front;
private int rear;
private int capacity;

public ServiceQueue(int capacity) {
this.capacity = capacity;
requests = new String[capacity];
front = 0;
rear = -1;
}
public void addRequest(String request) {

if (rear == capacity - 1) {
System.out.println("Queue is full.");
return;
}

requests[++rear] = request;
}
public String processRequest() {

if (front > rear) {
return null;
}

return requests[front++];
}
public void displayQueue() {

if (front > rear) {
System.out.println("No pending requests.");
return;
}

for (int i = front; i <= rear; i++) {
System.out.println(requests[i]);
}
}

}
